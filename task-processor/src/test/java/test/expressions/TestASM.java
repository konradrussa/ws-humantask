package test.expressions;

import java.util.Date;
import java.util.List;

import object.ObjectPreparator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.junit.Test;

import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.util.SBQLUtil;


public class TestASM {
	
	@Test
	public void testGetInput() {
		TaskInstance container = new TaskInstance("ApproveClaim");
		
		container.getContent().add(ObjectPreparator.getRequestObject());
		SBAStore store = new SBAStore();
		store.loadContainer(container);
		
		System.out.println("!!! store print !!!");
		store.printDataStore();
		
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("getInput(\"ClaimApprovalRequest\").amount");
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
	public void testGetOutput() {
		wsht.runtime.expressions.sbql.store.TaskInstance container = new wsht.runtime.expressions.sbql.store.TaskInstance("task2");
		
		container.getContent().add(ObjectPreparator.getRequestObject());
		SBAStore store = new SBAStore();
		store.loadContainer(container);
		
		System.out.println("!!! store print !!!");
		store.printDataStore();
		
		
		ENVS.getInstance().setStore(store);
		List<Long> rootOIDs = ((ComplexObject)store.objectMap.get(0L)).childOIDs;
		ENVS.getInstance().init(true, rootOIDs.toArray(new Long[0]));
		
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("getOutput(\"ClaimApprovalRequest\").person.lastname");
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
	public void testActualOwner() {
		wsht.runtime.expressions.sbql.store.TaskInstance container = new wsht.runtime.expressions.sbql.store.TaskInstance("ApproveClaim");
		
		container.getContent().add(ObjectPreparator.getRequestObject());
		
		container.fillInActualOwner("owner1");
		
		SBAStore store = new SBAStore();
		store.loadContainer(container);
		
		System.out.println("!!! store print !!!");
		store.printDataStore();
		
		ENVS.getInstance().setStore(store);
		List<Long> rootOIDs = ((ComplexObject)store.objectMap.get(0L)).childOIDs;
		ENVS.getInstance().init(true, rootOIDs.toArray(new Long[0]));

		ANTLRStringStream antlrStringStream = new ANTLRStringStream("getActualOwner(\"ApproveClaim\").id");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
        
        try {
			parser.evaluator();
			System.out.println(SBQLUtil.deref(QRES.getInstance().pop(false)));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		}
		
		/*
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("getOutput(\"ClaimApprovalRequest\").amount");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
        
        try {
			parser.evaluator();
			System.out.println(Util.deref(QRES.getInstance().pop(false)));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		}
		*/
	}
	
	

}
