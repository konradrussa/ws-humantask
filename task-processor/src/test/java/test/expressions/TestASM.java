package test.expressions;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.util.Util;


public class TestASM {
	
	@Test
	public void testGetInput() {
		wsht.runtime.expressions.sbql.store.Container container = new wsht.runtime.expressions.sbql.store.Container("ApproveClaim");
		
		container.getContent().add(new ClaimApprovalRequest());
		SBAStore store = new SBAStore();
		store.loadContainer(container);
		
		System.out.println("!!! store print !!!");
		store.printDataStore();
		
		
		ENVS.getInstance().setStore(store);
		List<Long> rootOIDs = ((ComplexObject)store.objectMap.get(0L)).childOIDs;
		ENVS.getInstance().init(true, rootOIDs.toArray(new Long[0]));
		
		ANTLRStringStream antlrStringStream = new ANTLRStringStream("getInput(\"ClaimApprovalRequest\").amount");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser parser = new SBQLParser(tokens);
        
        try {
			parser.evaluator();
			System.out.println(Util.deref(QRES.getInstance().pop(false)));
		} catch (RecognitionException e) {
			throw new WSHTExpressionException(e.getMessage());
		}
		
	}
	
	@Test
	public void testGetOutput() {
		wsht.runtime.expressions.sbql.store.Container container = new wsht.runtime.expressions.sbql.store.Container("task2");
		
		container.getContent().add(new ClaimApprovalRequest());
		SBAStore store = new SBAStore();
		store.loadContainer(container);
		
		System.out.println("!!! store print !!!");
		store.printDataStore();
		
		
		ENVS.getInstance().setStore(store);
		List<Long> rootOIDs = ((ComplexObject)store.objectMap.get(0L)).childOIDs;
		ENVS.getInstance().init(true, rootOIDs.toArray(new Long[0]));
		
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
		
	}
	
	@Test
	public void testActualOwner() {
		wsht.runtime.expressions.sbql.store.Container container = new wsht.runtime.expressions.sbql.store.Container("ApproveClaim");
		
		container.getContent().add(new ClaimApprovalRequest());
		
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
			System.out.println(Util.deref(QRES.getInstance().pop(false)));
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
	
	class ClaimApprovalRequest {
		
		public Cust cust1 = new Cust("idCust2", "Bruce", "Willis", null);
		public Cust cust2 = new Cust("idCust1", "John", "Rambo", new Location(34));
		public String region = "regionalClerks";
		
		
		public Integer prio = 2;
		
		public Date activateAt = new Date();
		public Integer amount = 2000;
		
	}
	
	class Cust {
		public Cust(String id, String firstname, String lastname, Location locata) {
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.locata = locata;
		}
		public String id;
		public Location locata;
		public String firstname;
		public String lastname;
		
	}
	
	class Location {
		public Location(Integer locationId) {
			this.locationId = locationId;
		}
		public Integer locationId;
	}

}
