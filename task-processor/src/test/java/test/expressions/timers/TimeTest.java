package test.expressions.timers;

import java.util.Date;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.joda.time.DateTime;
import org.junit.Test;

import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.ast.operators.wsht.utils.OperatorUtils;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.util.SBQLUtil;

public class TimeTest {
	
	@Test
	public void test() {
		String duration = "PT4H";
		
		long millis = OperatorUtils.calculateDuration(duration);
		long time = System.currentTimeMillis() + millis;
		System.out.println("duration "+duration+" millis is = " + millis + " formated to now + duration =" + new DateTime(time));
		
		String dateTime = "2022-05-30T09:00:00";
		Date computedDate = OperatorUtils.returnDateDeadline(dateTime);
		boolean elapsed = OperatorUtils.checkComputedDateElapsed(computedDate);
		System.out.println("DateTime "+dateTime+" elapsed ? = " + elapsed + " data " + computedDate);
	}

	@Test
	public void testDuration() {
		

		SBAStore store = new SBAStore();
		store.loadContainer(new TaskInstance("taskI"));
		store.printDataStore();
		
		
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("waitFor(\"PT15H\")");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
        
        try {
			parser.evaluator();
			System.out.println(SBQLUtil.deref(QRES.getInstance().pop(false)));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		}
		
	}
	
	@Test
	public void testTime() {
		

		SBAStore store = new SBAStore();
		TaskInstance taskInstance = new TaskInstance("taskI");
		store.loadContainer(taskInstance);
		store.printDataStore();
		
		
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("waitUntil(\"2002-05-30T09:00:00\")");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
        
        try {
			parser.evaluator();
			System.out.println(SBQLUtil.deref(QRES.getInstance().pop(false)));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		}
		
	}
}
