package test.expressions.sbql;

import java.io.IOException;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLLexer;
import wsht.runtime.expressions.sbql.qres.grammar.SBQLParser;
import wsht.runtime.expressions.sbql.store.SBAStore;
import wsht.runtime.expressions.sbql.store.object.ComplexObject;
import wsht.runtime.expressions.sbql.util.Util;



public class ParserMain {

	public static void main(String[] args) throws  IOException {
		
		SBAStore store = new SBAStore();
		//error store.loadObject();
		store.printDataStore();
		ENVS.getInstance().setStore(store);
		
		List<Long> rootOIDs = ((ComplexObject)store.objectMap.get(0L)).childOIDs;
		ENVS.getInstance().init(true,rootOIDs.toArray(new Long[0]));
		
		query22();
		
		query1();
		query2();
		query3();
		query4();
		query5();
		query6();
		query7();
		query8();
		query9();
		query10();
		query11();
		query12();
		query13();
		query14();
		query15();
		query16();
		
		query17();
		query18();
		query19();
		query20();
		query21();
		query22();
		query23();
		query24();
		query25();
		query26();
		query27();
		query28();
		query29();
		query30();
		query31();
		query32();
		query33();
		query34();
		query35();
		query36();
		query37();
		query38();
		query39();
		query40();
		query41();
		query42();
		query43();
		query44();
		query45();
		query46();
		query47();
		query48();
		query49();
		query50();
		query51();
		query52();
		query53();
		query54();
		query55();
		query56();
		query57();
		query58();
		query59();
		query60();
		query61();
		query62();
		query63();
		query64();
		query65();
		query66();
		query67();
		query68();
		query69();
		query70();
		query71();
		query72();
		query73();
		query74();
		query75();
		query76();
		query77();
		query78();
		query79();
		query80();
		query81();
		query82();
		query83();
		query84();
		query85();
		query86();
		query88();
		query89();
		query90();
		query91();
		query92();
		query93();
		query94();
		query95();
		query96();
		query97();
		query98();
		query99();
		query100();
		query101();
		query102();
		query103();
		query104();
		query105();
		query106();
		query107();
		query108();
		query109();
		query110();
		query111();
		query100();
		query101();
		query102();
		query103();
		query104();
		query105();
		query106();
		query107();
		query108();
		query109();
		query110();
		query111();
		query112();
		query113();
		query114();
		query115();
		query116();
		query117();
		query118();
		query119();
		query120();
		query121();
		query122();
		query123();
		query124();
		query125();
		query126();
		query127();
		query128();
		query129();
		query130();
		query131();
		query132();
		
	}
	
	private static void query1() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("all (1) (true)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	
	private static void query2() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("all (bag(1, bag(2,3) groupas wew) as num) (num == 2)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	
	private static void query3() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("all (emp) (married)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query4() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true and false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query5() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("booleanValue and true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	
	private static void query6() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("false and true and 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query7() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("any (1) (true)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	
	private static void query8() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("any (bag(1, bag(2,3) groupas wew) as num) (num == 1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	
	private static void query9() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("any (emp) (married)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query10() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 as liczba");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query11() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2) as num");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query12() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2) as num");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}

	private static void query13() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query14() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query15() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1+2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query16() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(bag(1,2,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query17() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("integerNumber");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query18() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("realNumber");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query19() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("booleanValue");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query20() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("stringValue");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query21() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("pomidor");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query22() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("sampleComplexObj");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query23() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query24() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(bag(1,2),3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query25() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(bag(1,2),bag(3,4))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query26() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("10/5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query27() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5/3.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query28() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50/5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query29() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50/5.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query30() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1 as x).(x)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query31() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2).(\"Ala\")");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query32() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("emp.book.author");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query33() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2).(\"Ala\")");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query34() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 == 2");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query35() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("integerNumber == 10");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query36() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2) == 2");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
//        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	
	private static void query37() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("booleanValue == true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query38() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("stringValue == \"Ala\"");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query39() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 == true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query40() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5 == \"5\"");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query41() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5.50 == 5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query42() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 > 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query43() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3 > 2.99");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query44() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("24.35 > 24.34");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query45() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 >= 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query46() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3 >= 2.99");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query47() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("24.35 >= 24.34");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query48() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2,3) groupas num");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query49() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 groupas liczba");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query50() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2,3) intersect bag(2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query51() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(bag(1,2,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query52() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(bag(1,2,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query53() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 intersect 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query54() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2) intersect (2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query55() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2) intersect (1,2)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query56() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(\"ala\",2,3) intersect bag(2,3.40)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query57() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 join 2");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query58() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1 as n) join n");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query59() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(emp) join (married)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query60() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(emp as e) join (e.married)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query61() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 <= 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query62() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("24.34 <= 24.35");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query63() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("2.99 <= 3");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query64() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 < 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query65() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("24.34 < 24.35");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query66() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("2.99 < 3");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query67() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("max(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query68() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("max (bag(1,3.35,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query69() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("min(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query70() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("min (bag(1.01,2.35,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query71() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("10-5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query72() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5-3.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query73() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50-5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query74() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50-5.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query75() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("10%5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query76() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5%3.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query77() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50%5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query78() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50%5.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query79() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("10*5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	private static void query80() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5*3.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query81() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50*5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query82() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50*5.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query83() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true or false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query84() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("booleanValue or false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query85() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true or false or 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query86() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("10+5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query87() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("5+3.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query88() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50+5");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query89() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.50+5.50");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query90() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3+\"Ala\"");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query91() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("3.5+\"Ala\"");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query92() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("\"Ala\"+3.7");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query93() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true+\"Ala\"");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query94() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true+\"Ala\"");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query95() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("struct(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query96() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("struct(1,2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query97() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("struct(1+2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query98() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("struct(struct(1,2,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query99() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 union 2");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query100() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(bag(1,2)) union (bag(3,4))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query101() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2) union (3,4)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query102() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("unique(bag(1,2,1))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query103() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("unique(bag(1.01,2,1.01,\"ala\"))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query104() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2) where true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query105() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2,3) as n where n == 1 ");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query106() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("emp where married");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query107() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("sum(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query108() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("sum(bag(1.01,2.35,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query109() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("count(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query110() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("count(bag(1.01,2.35,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query111() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("count(1.01,2.35,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	private static void query112() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("empty(1)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query113() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("empty (bag(1.01,2.35,3))");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query114() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("empty (1 where false)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query115() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("not true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query116() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("not false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query117() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true xor false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query118() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true xor true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query119() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("false xor true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query120() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("booleanValue xor true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query121() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true nand false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query122() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("false nand true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query123() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("false nand false");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query124() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true nand true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query125() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true xor true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query126() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("true xor true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query127() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("booleanValue nand true");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query128() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(2,3) in bag(1,2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query129() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("1 in 1");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query130() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2) in (2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query131() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("(1,2) in (1,2)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
//        try {
//			g.evaluator();
//		} catch (RecognitionException e) {
//			e.printStackTrace();
//		}
//		System.out.println(Util.deref(QRES.getInstance().pop(false)));
//		System.out.println("QRES " + QRES.getInstance().getStackSize());
//		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
//		System.out.println();
	}
	private static void query132() {
        ANTLRStringStream antlrStringStream = new ANTLRStringStream("bag(1,2,3) minus bag(2,3)");
    	SBQLLexer lex = new SBQLLexer(antlrStringStream);
        TokenStream tokens = new CommonTokenStream(lex);
        SBQLParser g = new SBQLParser(tokens);
        try {
			g.evaluator();
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		System.out.println(Util.deref(QRES.getInstance().pop(false)));
		System.out.println("QRES " + QRES.getInstance().getStackSize());
		System.out.println("ENVS " + ENVS.getInstance().getStackSize());
		System.out.println();
	}
	
	
}
