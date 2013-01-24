package wsht.runtime.expressions.sbql.ast.operators.wsht.ext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.springframework.stereotype.Service;

import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.util.SBQLUtil;

@Service("expressionContextService")
public class ExpressionContextService implements IValuable {
	
	private TaskInstance taskInstance;
	
	public TaskInstance getTaskInstance() {
		return taskInstance;
	}

	public void setTaskInstance(TaskInstance taskInstance) {
		this.taskInstance = taskInstance;
	}
	
	public void setUpTaskInstance(TaskInstance taskInstance) {
		setTaskInstance(taskInstance);
	}

	public AbstractQueryResult eval(String expression, boolean nullable) throws SBQLEvalException {
		if(taskInstance == null) {
			cleanStorage();
			throw new WSHTExpressionException("error - Task Instance absent !");
		}
		SBAStore store = new SBAStore();
		store.loadContainer(taskInstance);
		store.printDataStore();
		
		return evaluateExpression(expression, nullable);
	}
	
	public Map<String, AbstractQueryResult> evalInputConditions(Set<String> expressions, Object instance, boolean nullable) throws SBQLEvalException {
		if(instance == null) {
			throw new WSHTExpressionException("error - Object passed for evaluation not instantiated !");
		}
		cleanStorage();
		Map<String, AbstractQueryResult> queryResults = new HashMap<String, AbstractQueryResult>();
		SBAStore store = new SBAStore();
		store.loadContainer(instance);
		store.printDataStore();
		for(String expression : expressions) {
			AbstractQueryResult ret = evaluateExpression(expression, nullable);
			queryResults.put(expression, ret);
		}
		cleanStorage();
		return queryResults;
	}
	

	public AbstractQueryResult evalExternal(String expression, Object instance, boolean nullable) throws SBQLEvalException {
		if(instance == null) {
			throw new WSHTExpressionException("error - Object passed for evaluation not instantiated !");
		}
		cleanStorage();
		SBAStore store = new SBAStore();
		store.loadContainer(instance);
		store.printDataStore();
		AbstractQueryResult ret = evaluateExpression(expression, nullable);
		cleanStorage();
		return ret;
	}
	
	private void cleanStorage() {
		ENVS.clear();
	}
	
	private AbstractQueryResult evaluateExpression(String expression, boolean nullable) throws SBQLEvalException {
        try {
        	SBQLParser parser = prepareParserForExpression(expression);
			parser.evaluator();
			return SBQLUtil.deref(QRES.getInstance().pop(nullable));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		} catch(Throwable t) {
			throw new WSHTExpressionException(t.getMessage());
		}
	}
	
	private SBQLParser prepareParserForExpression(String expression) {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream(expression);
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
		return parser;
	}

	
}
