package test.expressions.sbql;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.Assert;
import org.junit.Test;

import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.util.SBQLUtil;

public class TestParser {

	@Test
	public void testParser() {
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("7 / 3.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
		
		Assert.assertNotNull(parser);
		
		try {
			parser.evaluator();
			System.out.println(SBQLUtil.deref(QRES.getInstance().pop(false)));
			System.out.println("QRES " + QRES.getInstance().getStackSize());
			System.out.println("ENVS " + ENVS.getInstance().getStackSize());
			System.out.println();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}
}
