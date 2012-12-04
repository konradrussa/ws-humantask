package wsht.runtime.expressions.sbql.ast.operators.wsht.ext;

import java.util.List;

import javax.annotation.Resource;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.springframework.stereotype.Service;

import wsht.runtime.db4o.IDB4oInterface;
import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.store.Container;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.util.Util;

import com.db4o.ObjectSet;

@Service("expContextService")
public class ExpContextService implements IValuable {
	
	@Resource
	private IDB4oInterface db4oInterface;
	
	public AbstractQueryResult eval(String expression, boolean nullable) throws WSHTExpressionException {
		
		ObjectSet<?> storeDB = (ObjectSet<?>) db4oInterface.qbe(Container.class);
		Container container = (Container) storeDB.get(0);
		SBAStore store = new SBAStore();
		store.loadContainer(container);
		store.printDataStore();
		ENVS.getInstance().setStore(store);
		List<Long> rootOIDs = ((ComplexObject)store.objectMap.get(0L)).childOIDs;
		ENVS.getInstance().init(true, rootOIDs.toArray(new Long[0]));
		
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(expression);
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
        
        try {
			parser.evaluator();
			return Util.deref(QRES.getInstance().pop(nullable));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		}
	}
	
}
