// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g 2012-06-24 20:31:03

package wsht.runtime.expressions.sbql.qres.grammar;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.*;
import wsht.runtime.expressions.sbql.ast.expressions.*;
import wsht.runtime.expressions.sbql.ast.terminals.*;
import wsht.runtime.expressions.sbql.ast.operators.*;
import wsht.runtime.expressions.sbql.ast.operators.wsht.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SBQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LEFT_BRACKET", "RIGHT_BRACKET", "INTEGERLITERAL", "DOUBLELITERAL", "BOOLEANLITERAL", "STRINGLITERAL", "IDENTLITERAL", "PLUS", "MINUS", "CONCAT_F", "CONCAT_WITH_DELIMITER_F", "VOTE_F", "VOTE_ON_STRING_F", "LEAST_FREQUENT_OCCURENCE_F", "MOST_FREQUENT_OCCURENCE_F", "GET_ACTUAL_OWNER_F", "GET_BUSINESS_ADMINISTRATORS_F", "GET_COUNT_OF_FINISHED_SUBTASKS_F", "GET_COUNT_OF_SUBTASKS_F", "GET_COUNT_OF_SUBTASKS_IN_STATE_F", "GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F", "GET_EXCLUDED_OWNERS_F", "GET_INPUT_F", "GET_LOGICAL_PEOPLE_GROUP_F", "GET_OUTCOME_F", "GET_OUTPUT_F", "GET_POTENTIAL_OWNERS_F", "GET_SUBTASK_OUTPUT_F", "GET_SUBTASK_OUTPUTS_F", "GET_TASK_INITIATOR_F", "GET_TASK_PRIORITY_F", "GET_TASK_STAKEHOLDERS_F", "WAIT_FOR_F", "WAIT_UNTIL_F", "SUM", "MIN", "MAX", "AVG", "COUNT", "STRUCT", "BAG", "AS", "GROUPAS", "MULT", "DIV", "MOD", "OR", "AND", "EQUALS", "NOTEQUALS", "GT", "LT", "GE", "LE", "DOT", "WHERE", "COMA", "ALL", "ANY", "MINUS_F", "UNION_F", "EXCEPT_F", "INTERSECT_F", "NOT", "UNIQUE", "EXISTS", "DIGIT", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "ESC_SEQ", "EXPONENT", "DELIMLITERAL", "WS"
    };
    public static final int GET_EXCLUDED_OWNERS_F=25;
    public static final int WHERE=59;
    public static final int LEAST_FREQUENT_OCCURENCE_F=17;
    public static final int EXPONENT=75;
    public static final int LT=55;
    public static final int INTEGERLITERAL=6;
    public static final int VOTE_ON_STRING_F=16;
    public static final int MOD=49;
    public static final int LEFT_BRACKET=4;
    public static final int OCTAL_ESC=73;
    public static final int BOOLEANLITERAL=8;
    public static final int MAX=40;
    public static final int EQUALS=52;
    public static final int COUNT=42;
    public static final int NOT=67;
    public static final int AND=51;
    public static final int SUM=38;
    public static final int GROUPAS=46;
    public static final int EOF=-1;
    public static final int IDENTLITERAL=10;
    public static final int AS=45;
    public static final int ESC_SEQ=74;
    public static final int CONCAT_WITH_DELIMITER_F=14;
    public static final int CONCAT_F=13;
    public static final int GET_LOGICAL_PEOPLE_GROUP_F=27;
    public static final int GET_SUBTASK_OUTPUT_F=31;
    public static final int AVG=41;
    public static final int ALL=61;
    public static final int WAIT_FOR_F=36;
    public static final int RIGHT_BRACKET=5;
    public static final int GET_SUBTASK_OUTPUTS_F=32;
    public static final int PLUS=11;
    public static final int DIGIT=70;
    public static final int EXISTS=69;
    public static final int VOTE_F=15;
    public static final int DOT=58;
    public static final int DELIMLITERAL=76;
    public static final int GET_OUTCOME_F=28;
    public static final int UNION_F=64;
    public static final int GET_ACTUAL_OWNER_F=19;
    public static final int GET_COUNT_OF_SUBTASKS_IN_STATE_F=23;
    public static final int UNIQUE=68;
    public static final int GE=56;
    public static final int MINUS_F=63;
    public static final int GET_POTENTIAL_OWNERS_F=30;
    public static final int GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F=24;
    public static final int GET_TASK_STAKEHOLDERS_F=35;
    public static final int UNICODE_ESC=72;
    public static final int GET_BUSINESS_ADMINISTRATORS_F=20;
    public static final int DOUBLELITERAL=7;
    public static final int HEX_DIGIT=71;
    public static final int EXCEPT_F=65;
    public static final int NOTEQUALS=53;
    public static final int STRUCT=43;
    public static final int WAIT_UNTIL_F=37;
    public static final int MIN=39;
    public static final int MULT=47;
    public static final int MINUS=12;
    public static final int COMA=60;
    public static final int GET_OUTPUT_F=29;
    public static final int WS=77;
    public static final int ANY=62;
    public static final int MOST_FREQUENT_OCCURENCE_F=18;
    public static final int GET_INPUT_F=26;
    public static final int BAG=44;
    public static final int STRINGLITERAL=9;
    public static final int OR=50;
    public static final int GET_TASK_PRIORITY_F=34;
    public static final int GT=54;
    public static final int GET_COUNT_OF_SUBTASKS_F=22;
    public static final int DIV=48;
    public static final int INTERSECT_F=66;
    public static final int GET_TASK_INITIATOR_F=33;
    public static final int LE=57;
    public static final int GET_COUNT_OF_FINISHED_SUBTASKS_F=21;

    // delegates
    // delegators


        public SBQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SBQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SBQLParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g"; }


      
      Interpreter interpreter = new Interpreter();

      public String getErrorMessage(RecognitionException e, String[] tokenNames)
      {
        List stack = getRuleInvocationStack(e, this.getClass().getName());
        String msg = null;
        if ( e instanceof NoViableAltException ) {
          NoViableAltException nvae = (NoViableAltException)e;
          msg = " no viable alt; token="+e.token+
            " (decision="+nvae.decisionNumber+
            " state "+nvae.stateNumber+")"+
            " decision=<<"+nvae.grammarDecisionDescription+">>";
        }
        else {
          msg = super.getErrorMessage(e, tokenNames);
        }
        return stack+" "+msg;
      }


    public static class evaluator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "evaluator"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:47:1: evaluator : e= intersectExpression EOF ;
    public final SBQLParser.evaluator_return evaluator() throws RecognitionException {
        SBQLParser.evaluator_return retval = new SBQLParser.evaluator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF1=null;
        SBQLParser.intersectExpression_return e = null;


        CommonTree EOF1_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:48:7: (e= intersectExpression EOF )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:48:9: e= intersectExpression EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_intersectExpression_in_evaluator81);
            e=intersectExpression();

            state._fsp--;

            adaptor.addChild(root_0, e.getTree());
            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_evaluator83); 
            EOF1_tree = (CommonTree)adaptor.create(EOF1);
            adaptor.addChild(root_0, EOF1_tree);

            System.out.println((e!=null?((CommonTree)e.tree):null).toStringTree().replaceAll("null","")); (e!=null?e.expr:null).accept(interpreter);

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "evaluator"

    public static class terminalExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "terminalExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:51:1: terminalExpression returns [Expression expr] : ( LEFT_BRACKET e1= intersectExpression RIGHT_BRACKET | INTEGERLITERAL | DOUBLELITERAL | BOOLEANLITERAL | STRINGLITERAL );
    public final SBQLParser.terminalExpression_return terminalExpression() throws RecognitionException {
        SBQLParser.terminalExpression_return retval = new SBQLParser.terminalExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEFT_BRACKET2=null;
        Token RIGHT_BRACKET3=null;
        Token INTEGERLITERAL4=null;
        Token DOUBLELITERAL5=null;
        Token BOOLEANLITERAL6=null;
        Token STRINGLITERAL7=null;
        SBQLParser.intersectExpression_return e1 = null;


        CommonTree LEFT_BRACKET2_tree=null;
        CommonTree RIGHT_BRACKET3_tree=null;
        CommonTree INTEGERLITERAL4_tree=null;
        CommonTree DOUBLELITERAL5_tree=null;
        CommonTree BOOLEANLITERAL6_tree=null;
        CommonTree STRINGLITERAL7_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:52:7: ( LEFT_BRACKET e1= intersectExpression RIGHT_BRACKET | INTEGERLITERAL | DOUBLELITERAL | BOOLEANLITERAL | STRINGLITERAL )
            int alt1=5;
            switch ( input.LA(1) ) {
            case LEFT_BRACKET:
                {
                alt1=1;
                }
                break;
            case INTEGERLITERAL:
                {
                alt1=2;
                }
                break;
            case DOUBLELITERAL:
                {
                alt1=3;
                }
                break;
            case BOOLEANLITERAL:
                {
                alt1=4;
                }
                break;
            case STRINGLITERAL:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:52:9: LEFT_BRACKET e1= intersectExpression RIGHT_BRACKET
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    LEFT_BRACKET2=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_terminalExpression110); 
                    LEFT_BRACKET2_tree = (CommonTree)adaptor.create(LEFT_BRACKET2);
                    adaptor.addChild(root_0, LEFT_BRACKET2_tree);

                    pushFollow(FOLLOW_intersectExpression_in_terminalExpression116);
                    e1=intersectExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    RIGHT_BRACKET3=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_terminalExpression118); 
                    RIGHT_BRACKET3_tree = (CommonTree)adaptor.create(RIGHT_BRACKET3);
                    adaptor.addChild(root_0, RIGHT_BRACKET3_tree);

                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:53:9: INTEGERLITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    INTEGERLITERAL4=(Token)match(input,INTEGERLITERAL,FOLLOW_INTEGERLITERAL_in_terminalExpression130); 
                    INTEGERLITERAL4_tree = (CommonTree)adaptor.create(INTEGERLITERAL4);
                    adaptor.addChild(root_0, INTEGERLITERAL4_tree);

                    retval.expr = new IntegerTerminal(Integer.parseInt((INTEGERLITERAL4!=null?INTEGERLITERAL4.getText():null)));

                    }
                    break;
                case 3 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:54:9: DOUBLELITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    DOUBLELITERAL5=(Token)match(input,DOUBLELITERAL,FOLLOW_DOUBLELITERAL_in_terminalExpression142); 
                    DOUBLELITERAL5_tree = (CommonTree)adaptor.create(DOUBLELITERAL5);
                    adaptor.addChild(root_0, DOUBLELITERAL5_tree);

                    retval.expr = new DoubleTerminal(Double.parseDouble((DOUBLELITERAL5!=null?DOUBLELITERAL5.getText():null)));

                    }
                    break;
                case 4 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:55:9: BOOLEANLITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BOOLEANLITERAL6=(Token)match(input,BOOLEANLITERAL,FOLLOW_BOOLEANLITERAL_in_terminalExpression154); 
                    BOOLEANLITERAL6_tree = (CommonTree)adaptor.create(BOOLEANLITERAL6);
                    adaptor.addChild(root_0, BOOLEANLITERAL6_tree);

                    retval.expr = new BooleanTerminal(Boolean.parseBoolean((BOOLEANLITERAL6!=null?BOOLEANLITERAL6.getText():null)));

                    }
                    break;
                case 5 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:56:9: STRINGLITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STRINGLITERAL7=(Token)match(input,STRINGLITERAL,FOLLOW_STRINGLITERAL_in_terminalExpression166); 
                    STRINGLITERAL7_tree = (CommonTree)adaptor.create(STRINGLITERAL7);
                    adaptor.addChild(root_0, STRINGLITERAL7_tree);


                              String s = new String((STRINGLITERAL7!=null?STRINGLITERAL7.getText():null)).replaceAll("\"", "");
                              retval.expr = new StringTerminal(s);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "terminalExpression"

    public static class nameExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:61:1: nameExpression returns [Expression expr] : ( IDENTLITERAL | e1= terminalExpression );
    public final SBQLParser.nameExpression_return nameExpression() throws RecognitionException {
        SBQLParser.nameExpression_return retval = new SBQLParser.nameExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENTLITERAL8=null;
        SBQLParser.terminalExpression_return e1 = null;


        CommonTree IDENTLITERAL8_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:62:7: ( IDENTLITERAL | e1= terminalExpression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==IDENTLITERAL) ) {
                alt2=1;
            }
            else if ( (LA2_0==LEFT_BRACKET||(LA2_0>=INTEGERLITERAL && LA2_0<=STRINGLITERAL)) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:62:10: IDENTLITERAL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    IDENTLITERAL8=(Token)match(input,IDENTLITERAL,FOLLOW_IDENTLITERAL_in_nameExpression201); 
                    IDENTLITERAL8_tree = (CommonTree)adaptor.create(IDENTLITERAL8);
                    adaptor.addChild(root_0, IDENTLITERAL8_tree);

                    retval.expr = new NameExpression(new IdentTerminal((IDENTLITERAL8!=null?IDENTLITERAL8.getText():null)));

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:63:10: e1= terminalExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_terminalExpression_in_nameExpression218);
                    e1=terminalExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nameExpression"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:66:1: unaryExpression returns [Expression expr] : ( PLUS | MINUS )* nameExpression ;
    public final SBQLParser.unaryExpression_return unaryExpression() throws RecognitionException {
        SBQLParser.unaryExpression_return retval = new SBQLParser.unaryExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS9=null;
        Token MINUS10=null;
        SBQLParser.nameExpression_return nameExpression11 = null;


        CommonTree PLUS9_tree=null;
        CommonTree MINUS10_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:67:7: ( ( PLUS | MINUS )* nameExpression )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:67:9: ( PLUS | MINUS )* nameExpression
            {
            root_0 = (CommonTree)adaptor.nil();

             boolean positive = true; 
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:68:7: ( PLUS | MINUS )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==PLUS) ) {
                    alt3=1;
                }
                else if ( (LA3_0==MINUS) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:68:8: PLUS
            	    {
            	    PLUS9=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpression260); 
            	    PLUS9_tree = (CommonTree)adaptor.create(PLUS9);
            	    adaptor.addChild(root_0, PLUS9_tree);


            	    }
            	    break;
            	case 2 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:68:15: MINUS
            	    {
            	    MINUS10=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpression264); 
            	    MINUS10_tree = (CommonTree)adaptor.create(MINUS10);
            	    adaptor.addChild(root_0, MINUS10_tree);

            	     positive = !positive; 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            pushFollow(FOLLOW_nameExpression_in_unaryExpression271);
            nameExpression11=nameExpression();

            state._fsp--;

            adaptor.addChild(root_0, nameExpression11.getTree());
             retval.expr = (nameExpression11!=null?nameExpression11.expr:null);
                    if (!positive)
                      retval.expr = new MinusUnaryOperator(retval.expr);
                  

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class concatExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:78:1: concatExpression returns [Expression expr] : (e1= unaryExpression | ( CONCAT_F unaryExpression ) );
    public final SBQLParser.concatExpression_return concatExpression() throws RecognitionException {
        SBQLParser.concatExpression_return retval = new SBQLParser.concatExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONCAT_F12=null;
        SBQLParser.unaryExpression_return e1 = null;

        SBQLParser.unaryExpression_return unaryExpression13 = null;


        CommonTree CONCAT_F12_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:79:7: (e1= unaryExpression | ( CONCAT_F unaryExpression ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LEFT_BRACKET||(LA4_0>=INTEGERLITERAL && LA4_0<=MINUS)) ) {
                alt4=1;
            }
            else if ( (LA4_0==CONCAT_F) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:79:9: e1= unaryExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_unaryExpression_in_concatExpression323);
                    e1=unaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:80:9: ( CONCAT_F unaryExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:80:9: ( CONCAT_F unaryExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:80:10: CONCAT_F unaryExpression
                    {
                    CONCAT_F12=(Token)match(input,CONCAT_F,FOLLOW_CONCAT_F_in_concatExpression337); 
                    CONCAT_F12_tree = (CommonTree)adaptor.create(CONCAT_F12);
                    adaptor.addChild(root_0, CONCAT_F12_tree);

                    pushFollow(FOLLOW_unaryExpression_in_concatExpression340);
                    unaryExpression13=unaryExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, unaryExpression13.getTree());
                    retval.expr = new ConcatFunction((unaryExpression13!=null?unaryExpression13.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "concatExpression"

    public static class concatWithDelimiterExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatWithDelimiterExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:83:1: concatWithDelimiterExpression returns [Expression expr] : (e1= concatExpression | ( CONCAT_WITH_DELIMITER_F concatExpression ) );
    public final SBQLParser.concatWithDelimiterExpression_return concatWithDelimiterExpression() throws RecognitionException {
        SBQLParser.concatWithDelimiterExpression_return retval = new SBQLParser.concatWithDelimiterExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONCAT_WITH_DELIMITER_F14=null;
        SBQLParser.concatExpression_return e1 = null;

        SBQLParser.concatExpression_return concatExpression15 = null;


        CommonTree CONCAT_WITH_DELIMITER_F14_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:84:7: (e1= concatExpression | ( CONCAT_WITH_DELIMITER_F concatExpression ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LEFT_BRACKET||(LA5_0>=INTEGERLITERAL && LA5_0<=CONCAT_F)) ) {
                alt5=1;
            }
            else if ( (LA5_0==CONCAT_WITH_DELIMITER_F) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:84:9: e1= concatExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_concatExpression_in_concatWithDelimiterExpression379);
                    e1=concatExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:85:9: ( CONCAT_WITH_DELIMITER_F concatExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:85:9: ( CONCAT_WITH_DELIMITER_F concatExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:85:10: CONCAT_WITH_DELIMITER_F concatExpression
                    {
                    CONCAT_WITH_DELIMITER_F14=(Token)match(input,CONCAT_WITH_DELIMITER_F,FOLLOW_CONCAT_WITH_DELIMITER_F_in_concatWithDelimiterExpression393); 
                    CONCAT_WITH_DELIMITER_F14_tree = (CommonTree)adaptor.create(CONCAT_WITH_DELIMITER_F14);
                    adaptor.addChild(root_0, CONCAT_WITH_DELIMITER_F14_tree);

                    pushFollow(FOLLOW_concatExpression_in_concatWithDelimiterExpression396);
                    concatExpression15=concatExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, concatExpression15.getTree());
                    retval.expr = new ConcatWithDelimiterFunction((concatExpression15!=null?concatExpression15.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "concatWithDelimiterExpression"

    public static class voteExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voteExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:88:1: voteExpression returns [Expression expr] : (e1= concatWithDelimiterExpression | ( VOTE_F concatWithDelimiterExpression ) );
    public final SBQLParser.voteExpression_return voteExpression() throws RecognitionException {
        SBQLParser.voteExpression_return retval = new SBQLParser.voteExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VOTE_F16=null;
        SBQLParser.concatWithDelimiterExpression_return e1 = null;

        SBQLParser.concatWithDelimiterExpression_return concatWithDelimiterExpression17 = null;


        CommonTree VOTE_F16_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:89:7: (e1= concatWithDelimiterExpression | ( VOTE_F concatWithDelimiterExpression ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LEFT_BRACKET||(LA6_0>=INTEGERLITERAL && LA6_0<=CONCAT_WITH_DELIMITER_F)) ) {
                alt6=1;
            }
            else if ( (LA6_0==VOTE_F) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:89:9: e1= concatWithDelimiterExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_concatWithDelimiterExpression_in_voteExpression429);
                    e1=concatWithDelimiterExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:90:9: ( VOTE_F concatWithDelimiterExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:90:9: ( VOTE_F concatWithDelimiterExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:90:10: VOTE_F concatWithDelimiterExpression
                    {
                    VOTE_F16=(Token)match(input,VOTE_F,FOLLOW_VOTE_F_in_voteExpression442); 
                    VOTE_F16_tree = (CommonTree)adaptor.create(VOTE_F16);
                    adaptor.addChild(root_0, VOTE_F16_tree);

                    pushFollow(FOLLOW_concatWithDelimiterExpression_in_voteExpression444);
                    concatWithDelimiterExpression17=concatWithDelimiterExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, concatWithDelimiterExpression17.getTree());
                    retval.expr = new VoteFunction((concatWithDelimiterExpression17!=null?concatWithDelimiterExpression17.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "voteExpression"

    public static class voteOnStringExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "voteOnStringExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:92:1: voteOnStringExpression returns [Expression expr] : (e1= voteExpression | ( VOTE_ON_STRING_F voteExpression ) );
    public final SBQLParser.voteOnStringExpression_return voteOnStringExpression() throws RecognitionException {
        SBQLParser.voteOnStringExpression_return retval = new SBQLParser.voteOnStringExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token VOTE_ON_STRING_F18=null;
        SBQLParser.voteExpression_return e1 = null;

        SBQLParser.voteExpression_return voteExpression19 = null;


        CommonTree VOTE_ON_STRING_F18_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:93:7: (e1= voteExpression | ( VOTE_ON_STRING_F voteExpression ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==LEFT_BRACKET||(LA7_0>=INTEGERLITERAL && LA7_0<=VOTE_F)) ) {
                alt7=1;
            }
            else if ( (LA7_0==VOTE_ON_STRING_F) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:93:9: e1= voteExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_voteExpression_in_voteOnStringExpression475);
                    e1=voteExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:94:9: ( VOTE_ON_STRING_F voteExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:94:9: ( VOTE_ON_STRING_F voteExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:94:10: VOTE_ON_STRING_F voteExpression
                    {
                    VOTE_ON_STRING_F18=(Token)match(input,VOTE_ON_STRING_F,FOLLOW_VOTE_ON_STRING_F_in_voteOnStringExpression488); 
                    VOTE_ON_STRING_F18_tree = (CommonTree)adaptor.create(VOTE_ON_STRING_F18);
                    adaptor.addChild(root_0, VOTE_ON_STRING_F18_tree);

                    pushFollow(FOLLOW_voteExpression_in_voteOnStringExpression490);
                    voteExpression19=voteExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, voteExpression19.getTree());
                    retval.expr = new VoteOnStringFunction((voteExpression19!=null?voteExpression19.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "voteOnStringExpression"

    public static class leastFrequentOccurenceExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "leastFrequentOccurenceExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:97:1: leastFrequentOccurenceExpression returns [Expression expr] : (e1= voteOnStringExpression | ( LEAST_FREQUENT_OCCURENCE_F voteOnStringExpression ) );
    public final SBQLParser.leastFrequentOccurenceExpression_return leastFrequentOccurenceExpression() throws RecognitionException {
        SBQLParser.leastFrequentOccurenceExpression_return retval = new SBQLParser.leastFrequentOccurenceExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LEAST_FREQUENT_OCCURENCE_F20=null;
        SBQLParser.voteOnStringExpression_return e1 = null;

        SBQLParser.voteOnStringExpression_return voteOnStringExpression21 = null;


        CommonTree LEAST_FREQUENT_OCCURENCE_F20_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:98:7: (e1= voteOnStringExpression | ( LEAST_FREQUENT_OCCURENCE_F voteOnStringExpression ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LEFT_BRACKET||(LA8_0>=INTEGERLITERAL && LA8_0<=VOTE_ON_STRING_F)) ) {
                alt8=1;
            }
            else if ( (LA8_0==LEAST_FREQUENT_OCCURENCE_F) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:98:9: e1= voteOnStringExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_voteOnStringExpression_in_leastFrequentOccurenceExpression528);
                    e1=voteOnStringExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:99:9: ( LEAST_FREQUENT_OCCURENCE_F voteOnStringExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:99:9: ( LEAST_FREQUENT_OCCURENCE_F voteOnStringExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:99:10: LEAST_FREQUENT_OCCURENCE_F voteOnStringExpression
                    {
                    LEAST_FREQUENT_OCCURENCE_F20=(Token)match(input,LEAST_FREQUENT_OCCURENCE_F,FOLLOW_LEAST_FREQUENT_OCCURENCE_F_in_leastFrequentOccurenceExpression541); 
                    LEAST_FREQUENT_OCCURENCE_F20_tree = (CommonTree)adaptor.create(LEAST_FREQUENT_OCCURENCE_F20);
                    adaptor.addChild(root_0, LEAST_FREQUENT_OCCURENCE_F20_tree);

                    pushFollow(FOLLOW_voteOnStringExpression_in_leastFrequentOccurenceExpression544);
                    voteOnStringExpression21=voteOnStringExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, voteOnStringExpression21.getTree());
                    retval.expr = new LeastFrequentOccurenceFunction((voteOnStringExpression21!=null?voteOnStringExpression21.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "leastFrequentOccurenceExpression"

    public static class mostFrequentOccurenceExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mostFrequentOccurenceExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:101:1: mostFrequentOccurenceExpression returns [Expression expr] : (e1= leastFrequentOccurenceExpression | ( MOST_FREQUENT_OCCURENCE_F leastFrequentOccurenceExpression ) );
    public final SBQLParser.mostFrequentOccurenceExpression_return mostFrequentOccurenceExpression() throws RecognitionException {
        SBQLParser.mostFrequentOccurenceExpression_return retval = new SBQLParser.mostFrequentOccurenceExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MOST_FREQUENT_OCCURENCE_F22=null;
        SBQLParser.leastFrequentOccurenceExpression_return e1 = null;

        SBQLParser.leastFrequentOccurenceExpression_return leastFrequentOccurenceExpression23 = null;


        CommonTree MOST_FREQUENT_OCCURENCE_F22_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:102:7: (e1= leastFrequentOccurenceExpression | ( MOST_FREQUENT_OCCURENCE_F leastFrequentOccurenceExpression ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LEFT_BRACKET||(LA9_0>=INTEGERLITERAL && LA9_0<=LEAST_FREQUENT_OCCURENCE_F)) ) {
                alt9=1;
            }
            else if ( (LA9_0==MOST_FREQUENT_OCCURENCE_F) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:102:9: e1= leastFrequentOccurenceExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_leastFrequentOccurenceExpression_in_mostFrequentOccurenceExpression576);
                    e1=leastFrequentOccurenceExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:103:9: ( MOST_FREQUENT_OCCURENCE_F leastFrequentOccurenceExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:103:9: ( MOST_FREQUENT_OCCURENCE_F leastFrequentOccurenceExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:103:10: MOST_FREQUENT_OCCURENCE_F leastFrequentOccurenceExpression
                    {
                    MOST_FREQUENT_OCCURENCE_F22=(Token)match(input,MOST_FREQUENT_OCCURENCE_F,FOLLOW_MOST_FREQUENT_OCCURENCE_F_in_mostFrequentOccurenceExpression589); 
                    MOST_FREQUENT_OCCURENCE_F22_tree = (CommonTree)adaptor.create(MOST_FREQUENT_OCCURENCE_F22);
                    adaptor.addChild(root_0, MOST_FREQUENT_OCCURENCE_F22_tree);

                    pushFollow(FOLLOW_leastFrequentOccurenceExpression_in_mostFrequentOccurenceExpression592);
                    leastFrequentOccurenceExpression23=leastFrequentOccurenceExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, leastFrequentOccurenceExpression23.getTree());
                    retval.expr = new MostFrequentOccurenceFunction((leastFrequentOccurenceExpression23!=null?leastFrequentOccurenceExpression23.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mostFrequentOccurenceExpression"

    public static class getActualOwnerExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getActualOwnerExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:106:1: getActualOwnerExpression returns [Expression expr] : (e1= mostFrequentOccurenceExpression | ( GET_ACTUAL_OWNER_F mostFrequentOccurenceExpression ) );
    public final SBQLParser.getActualOwnerExpression_return getActualOwnerExpression() throws RecognitionException {
        SBQLParser.getActualOwnerExpression_return retval = new SBQLParser.getActualOwnerExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_ACTUAL_OWNER_F24=null;
        SBQLParser.mostFrequentOccurenceExpression_return e1 = null;

        SBQLParser.mostFrequentOccurenceExpression_return mostFrequentOccurenceExpression25 = null;


        CommonTree GET_ACTUAL_OWNER_F24_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:107:7: (e1= mostFrequentOccurenceExpression | ( GET_ACTUAL_OWNER_F mostFrequentOccurenceExpression ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LEFT_BRACKET||(LA10_0>=INTEGERLITERAL && LA10_0<=MOST_FREQUENT_OCCURENCE_F)) ) {
                alt10=1;
            }
            else if ( (LA10_0==GET_ACTUAL_OWNER_F) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:107:9: e1= mostFrequentOccurenceExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_mostFrequentOccurenceExpression_in_getActualOwnerExpression625);
                    e1=mostFrequentOccurenceExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:108:9: ( GET_ACTUAL_OWNER_F mostFrequentOccurenceExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:108:9: ( GET_ACTUAL_OWNER_F mostFrequentOccurenceExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:108:10: GET_ACTUAL_OWNER_F mostFrequentOccurenceExpression
                    {
                    GET_ACTUAL_OWNER_F24=(Token)match(input,GET_ACTUAL_OWNER_F,FOLLOW_GET_ACTUAL_OWNER_F_in_getActualOwnerExpression638); 
                    GET_ACTUAL_OWNER_F24_tree = (CommonTree)adaptor.create(GET_ACTUAL_OWNER_F24);
                    adaptor.addChild(root_0, GET_ACTUAL_OWNER_F24_tree);

                    pushFollow(FOLLOW_mostFrequentOccurenceExpression_in_getActualOwnerExpression641);
                    mostFrequentOccurenceExpression25=mostFrequentOccurenceExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, mostFrequentOccurenceExpression25.getTree());
                    retval.expr = new GetActualOwnerFunction((mostFrequentOccurenceExpression25!=null?mostFrequentOccurenceExpression25.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getActualOwnerExpression"

    public static class getBusinessAdministratorsExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getBusinessAdministratorsExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:111:1: getBusinessAdministratorsExpression returns [Expression expr] : (e1= getActualOwnerExpression | ( GET_BUSINESS_ADMINISTRATORS_F getActualOwnerExpression ) );
    public final SBQLParser.getBusinessAdministratorsExpression_return getBusinessAdministratorsExpression() throws RecognitionException {
        SBQLParser.getBusinessAdministratorsExpression_return retval = new SBQLParser.getBusinessAdministratorsExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_BUSINESS_ADMINISTRATORS_F26=null;
        SBQLParser.getActualOwnerExpression_return e1 = null;

        SBQLParser.getActualOwnerExpression_return getActualOwnerExpression27 = null;


        CommonTree GET_BUSINESS_ADMINISTRATORS_F26_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:112:7: (e1= getActualOwnerExpression | ( GET_BUSINESS_ADMINISTRATORS_F getActualOwnerExpression ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LEFT_BRACKET||(LA11_0>=INTEGERLITERAL && LA11_0<=GET_ACTUAL_OWNER_F)) ) {
                alt11=1;
            }
            else if ( (LA11_0==GET_BUSINESS_ADMINISTRATORS_F) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:112:9: e1= getActualOwnerExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getActualOwnerExpression_in_getBusinessAdministratorsExpression674);
                    e1=getActualOwnerExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:113:9: ( GET_BUSINESS_ADMINISTRATORS_F getActualOwnerExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:113:9: ( GET_BUSINESS_ADMINISTRATORS_F getActualOwnerExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:113:10: GET_BUSINESS_ADMINISTRATORS_F getActualOwnerExpression
                    {
                    GET_BUSINESS_ADMINISTRATORS_F26=(Token)match(input,GET_BUSINESS_ADMINISTRATORS_F,FOLLOW_GET_BUSINESS_ADMINISTRATORS_F_in_getBusinessAdministratorsExpression687); 
                    GET_BUSINESS_ADMINISTRATORS_F26_tree = (CommonTree)adaptor.create(GET_BUSINESS_ADMINISTRATORS_F26);
                    adaptor.addChild(root_0, GET_BUSINESS_ADMINISTRATORS_F26_tree);

                    pushFollow(FOLLOW_getActualOwnerExpression_in_getBusinessAdministratorsExpression690);
                    getActualOwnerExpression27=getActualOwnerExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getActualOwnerExpression27.getTree());
                    retval.expr = new GetBusinessAdministratorsFunction((getActualOwnerExpression27!=null?getActualOwnerExpression27.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getBusinessAdministratorsExpression"

    public static class getCountOfFinishedSubTasksExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCountOfFinishedSubTasksExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:116:1: getCountOfFinishedSubTasksExpression returns [Expression expr] : (e1= getBusinessAdministratorsExpression | ( GET_COUNT_OF_FINISHED_SUBTASKS_F getBusinessAdministratorsExpression ) );
    public final SBQLParser.getCountOfFinishedSubTasksExpression_return getCountOfFinishedSubTasksExpression() throws RecognitionException {
        SBQLParser.getCountOfFinishedSubTasksExpression_return retval = new SBQLParser.getCountOfFinishedSubTasksExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_COUNT_OF_FINISHED_SUBTASKS_F28=null;
        SBQLParser.getBusinessAdministratorsExpression_return e1 = null;

        SBQLParser.getBusinessAdministratorsExpression_return getBusinessAdministratorsExpression29 = null;


        CommonTree GET_COUNT_OF_FINISHED_SUBTASKS_F28_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:117:7: (e1= getBusinessAdministratorsExpression | ( GET_COUNT_OF_FINISHED_SUBTASKS_F getBusinessAdministratorsExpression ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LEFT_BRACKET||(LA12_0>=INTEGERLITERAL && LA12_0<=GET_BUSINESS_ADMINISTRATORS_F)) ) {
                alt12=1;
            }
            else if ( (LA12_0==GET_COUNT_OF_FINISHED_SUBTASKS_F) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:117:9: e1= getBusinessAdministratorsExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getBusinessAdministratorsExpression_in_getCountOfFinishedSubTasksExpression729);
                    e1=getBusinessAdministratorsExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:118:9: ( GET_COUNT_OF_FINISHED_SUBTASKS_F getBusinessAdministratorsExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:118:9: ( GET_COUNT_OF_FINISHED_SUBTASKS_F getBusinessAdministratorsExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:118:10: GET_COUNT_OF_FINISHED_SUBTASKS_F getBusinessAdministratorsExpression
                    {
                    GET_COUNT_OF_FINISHED_SUBTASKS_F28=(Token)match(input,GET_COUNT_OF_FINISHED_SUBTASKS_F,FOLLOW_GET_COUNT_OF_FINISHED_SUBTASKS_F_in_getCountOfFinishedSubTasksExpression742); 
                    GET_COUNT_OF_FINISHED_SUBTASKS_F28_tree = (CommonTree)adaptor.create(GET_COUNT_OF_FINISHED_SUBTASKS_F28);
                    adaptor.addChild(root_0, GET_COUNT_OF_FINISHED_SUBTASKS_F28_tree);

                    pushFollow(FOLLOW_getBusinessAdministratorsExpression_in_getCountOfFinishedSubTasksExpression745);
                    getBusinessAdministratorsExpression29=getBusinessAdministratorsExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getBusinessAdministratorsExpression29.getTree());
                    retval.expr = new GetCountOfFinishedSubTasksFunction((getBusinessAdministratorsExpression29!=null?getBusinessAdministratorsExpression29.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCountOfFinishedSubTasksExpression"

    public static class getCountOfSubTasksExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCountOfSubTasksExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:121:1: getCountOfSubTasksExpression returns [Expression expr] : (e1= getCountOfFinishedSubTasksExpression | ( GET_COUNT_OF_SUBTASKS_F getCountOfFinishedSubTasksExpression ) );
    public final SBQLParser.getCountOfSubTasksExpression_return getCountOfSubTasksExpression() throws RecognitionException {
        SBQLParser.getCountOfSubTasksExpression_return retval = new SBQLParser.getCountOfSubTasksExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_COUNT_OF_SUBTASKS_F30=null;
        SBQLParser.getCountOfFinishedSubTasksExpression_return e1 = null;

        SBQLParser.getCountOfFinishedSubTasksExpression_return getCountOfFinishedSubTasksExpression31 = null;


        CommonTree GET_COUNT_OF_SUBTASKS_F30_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:122:7: (e1= getCountOfFinishedSubTasksExpression | ( GET_COUNT_OF_SUBTASKS_F getCountOfFinishedSubTasksExpression ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LEFT_BRACKET||(LA13_0>=INTEGERLITERAL && LA13_0<=GET_COUNT_OF_FINISHED_SUBTASKS_F)) ) {
                alt13=1;
            }
            else if ( (LA13_0==GET_COUNT_OF_SUBTASKS_F) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:122:9: e1= getCountOfFinishedSubTasksExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getCountOfFinishedSubTasksExpression_in_getCountOfSubTasksExpression784);
                    e1=getCountOfFinishedSubTasksExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:123:9: ( GET_COUNT_OF_SUBTASKS_F getCountOfFinishedSubTasksExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:123:9: ( GET_COUNT_OF_SUBTASKS_F getCountOfFinishedSubTasksExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:123:10: GET_COUNT_OF_SUBTASKS_F getCountOfFinishedSubTasksExpression
                    {
                    GET_COUNT_OF_SUBTASKS_F30=(Token)match(input,GET_COUNT_OF_SUBTASKS_F,FOLLOW_GET_COUNT_OF_SUBTASKS_F_in_getCountOfSubTasksExpression797); 
                    GET_COUNT_OF_SUBTASKS_F30_tree = (CommonTree)adaptor.create(GET_COUNT_OF_SUBTASKS_F30);
                    adaptor.addChild(root_0, GET_COUNT_OF_SUBTASKS_F30_tree);

                    pushFollow(FOLLOW_getCountOfFinishedSubTasksExpression_in_getCountOfSubTasksExpression800);
                    getCountOfFinishedSubTasksExpression31=getCountOfFinishedSubTasksExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getCountOfFinishedSubTasksExpression31.getTree());
                    retval.expr = new GetCountOfSubTasksFunction((getCountOfFinishedSubTasksExpression31!=null?getCountOfFinishedSubTasksExpression31.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCountOfSubTasksExpression"

    public static class getCountOfSubTasksInStateExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCountOfSubTasksInStateExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:126:1: getCountOfSubTasksInStateExpression returns [Expression expr] : (e1= getCountOfSubTasksExpression | ( GET_COUNT_OF_SUBTASKS_IN_STATE_F getCountOfSubTasksExpression ) );
    public final SBQLParser.getCountOfSubTasksInStateExpression_return getCountOfSubTasksInStateExpression() throws RecognitionException {
        SBQLParser.getCountOfSubTasksInStateExpression_return retval = new SBQLParser.getCountOfSubTasksInStateExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_COUNT_OF_SUBTASKS_IN_STATE_F32=null;
        SBQLParser.getCountOfSubTasksExpression_return e1 = null;

        SBQLParser.getCountOfSubTasksExpression_return getCountOfSubTasksExpression33 = null;


        CommonTree GET_COUNT_OF_SUBTASKS_IN_STATE_F32_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:127:7: (e1= getCountOfSubTasksExpression | ( GET_COUNT_OF_SUBTASKS_IN_STATE_F getCountOfSubTasksExpression ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LEFT_BRACKET||(LA14_0>=INTEGERLITERAL && LA14_0<=GET_COUNT_OF_SUBTASKS_F)) ) {
                alt14=1;
            }
            else if ( (LA14_0==GET_COUNT_OF_SUBTASKS_IN_STATE_F) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:127:9: e1= getCountOfSubTasksExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getCountOfSubTasksExpression_in_getCountOfSubTasksInStateExpression839);
                    e1=getCountOfSubTasksExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:128:9: ( GET_COUNT_OF_SUBTASKS_IN_STATE_F getCountOfSubTasksExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:128:9: ( GET_COUNT_OF_SUBTASKS_IN_STATE_F getCountOfSubTasksExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:128:10: GET_COUNT_OF_SUBTASKS_IN_STATE_F getCountOfSubTasksExpression
                    {
                    GET_COUNT_OF_SUBTASKS_IN_STATE_F32=(Token)match(input,GET_COUNT_OF_SUBTASKS_IN_STATE_F,FOLLOW_GET_COUNT_OF_SUBTASKS_IN_STATE_F_in_getCountOfSubTasksInStateExpression852); 
                    GET_COUNT_OF_SUBTASKS_IN_STATE_F32_tree = (CommonTree)adaptor.create(GET_COUNT_OF_SUBTASKS_IN_STATE_F32);
                    adaptor.addChild(root_0, GET_COUNT_OF_SUBTASKS_IN_STATE_F32_tree);

                    pushFollow(FOLLOW_getCountOfSubTasksExpression_in_getCountOfSubTasksInStateExpression855);
                    getCountOfSubTasksExpression33=getCountOfSubTasksExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getCountOfSubTasksExpression33.getTree());
                    retval.expr = new GetCountOfSubTasksInStateFunction((getCountOfSubTasksExpression33!=null?getCountOfSubTasksExpression33.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCountOfSubTasksInStateExpression"

    public static class getCountOfSubTasksWithOutcomeExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCountOfSubTasksWithOutcomeExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:131:1: getCountOfSubTasksWithOutcomeExpression returns [Expression expr] : (e1= getCountOfSubTasksInStateExpression | ( GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F getCountOfSubTasksInStateExpression ) );
    public final SBQLParser.getCountOfSubTasksWithOutcomeExpression_return getCountOfSubTasksWithOutcomeExpression() throws RecognitionException {
        SBQLParser.getCountOfSubTasksWithOutcomeExpression_return retval = new SBQLParser.getCountOfSubTasksWithOutcomeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F34=null;
        SBQLParser.getCountOfSubTasksInStateExpression_return e1 = null;

        SBQLParser.getCountOfSubTasksInStateExpression_return getCountOfSubTasksInStateExpression35 = null;


        CommonTree GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F34_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:132:7: (e1= getCountOfSubTasksInStateExpression | ( GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F getCountOfSubTasksInStateExpression ) )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==LEFT_BRACKET||(LA15_0>=INTEGERLITERAL && LA15_0<=GET_COUNT_OF_SUBTASKS_IN_STATE_F)) ) {
                alt15=1;
            }
            else if ( (LA15_0==GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:132:9: e1= getCountOfSubTasksInStateExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getCountOfSubTasksInStateExpression_in_getCountOfSubTasksWithOutcomeExpression894);
                    e1=getCountOfSubTasksInStateExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:133:9: ( GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F getCountOfSubTasksInStateExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:133:9: ( GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F getCountOfSubTasksInStateExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:133:10: GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F getCountOfSubTasksInStateExpression
                    {
                    GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F34=(Token)match(input,GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F,FOLLOW_GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F_in_getCountOfSubTasksWithOutcomeExpression907); 
                    GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F34_tree = (CommonTree)adaptor.create(GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F34);
                    adaptor.addChild(root_0, GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F34_tree);

                    pushFollow(FOLLOW_getCountOfSubTasksInStateExpression_in_getCountOfSubTasksWithOutcomeExpression910);
                    getCountOfSubTasksInStateExpression35=getCountOfSubTasksInStateExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getCountOfSubTasksInStateExpression35.getTree());
                    retval.expr = new GetCountOfSubTasksWithOutcomeFunction((getCountOfSubTasksInStateExpression35!=null?getCountOfSubTasksInStateExpression35.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCountOfSubTasksWithOutcomeExpression"

    public static class getExcludedOwnersExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getExcludedOwnersExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:136:1: getExcludedOwnersExpression returns [Expression expr] : (e1= getCountOfSubTasksWithOutcomeExpression | ( GET_EXCLUDED_OWNERS_F getCountOfSubTasksWithOutcomeExpression ) );
    public final SBQLParser.getExcludedOwnersExpression_return getExcludedOwnersExpression() throws RecognitionException {
        SBQLParser.getExcludedOwnersExpression_return retval = new SBQLParser.getExcludedOwnersExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_EXCLUDED_OWNERS_F36=null;
        SBQLParser.getCountOfSubTasksWithOutcomeExpression_return e1 = null;

        SBQLParser.getCountOfSubTasksWithOutcomeExpression_return getCountOfSubTasksWithOutcomeExpression37 = null;


        CommonTree GET_EXCLUDED_OWNERS_F36_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:137:7: (e1= getCountOfSubTasksWithOutcomeExpression | ( GET_EXCLUDED_OWNERS_F getCountOfSubTasksWithOutcomeExpression ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==LEFT_BRACKET||(LA16_0>=INTEGERLITERAL && LA16_0<=GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F)) ) {
                alt16=1;
            }
            else if ( (LA16_0==GET_EXCLUDED_OWNERS_F) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:137:9: e1= getCountOfSubTasksWithOutcomeExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getCountOfSubTasksWithOutcomeExpression_in_getExcludedOwnersExpression943);
                    e1=getCountOfSubTasksWithOutcomeExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:138:9: ( GET_EXCLUDED_OWNERS_F getCountOfSubTasksWithOutcomeExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:138:9: ( GET_EXCLUDED_OWNERS_F getCountOfSubTasksWithOutcomeExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:138:10: GET_EXCLUDED_OWNERS_F getCountOfSubTasksWithOutcomeExpression
                    {
                    GET_EXCLUDED_OWNERS_F36=(Token)match(input,GET_EXCLUDED_OWNERS_F,FOLLOW_GET_EXCLUDED_OWNERS_F_in_getExcludedOwnersExpression956); 
                    GET_EXCLUDED_OWNERS_F36_tree = (CommonTree)adaptor.create(GET_EXCLUDED_OWNERS_F36);
                    adaptor.addChild(root_0, GET_EXCLUDED_OWNERS_F36_tree);

                    pushFollow(FOLLOW_getCountOfSubTasksWithOutcomeExpression_in_getExcludedOwnersExpression959);
                    getCountOfSubTasksWithOutcomeExpression37=getCountOfSubTasksWithOutcomeExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getCountOfSubTasksWithOutcomeExpression37.getTree());
                    retval.expr = new GetExcludedOwnersFunction((getCountOfSubTasksWithOutcomeExpression37!=null?getCountOfSubTasksWithOutcomeExpression37.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getExcludedOwnersExpression"

    public static class getInputExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getInputExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:140:1: getInputExpression returns [Expression expr] : (e1= getExcludedOwnersExpression | ( GET_INPUT_F getExcludedOwnersExpression ) );
    public final SBQLParser.getInputExpression_return getInputExpression() throws RecognitionException {
        SBQLParser.getInputExpression_return retval = new SBQLParser.getInputExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_INPUT_F38=null;
        SBQLParser.getExcludedOwnersExpression_return e1 = null;

        SBQLParser.getExcludedOwnersExpression_return getExcludedOwnersExpression39 = null;


        CommonTree GET_INPUT_F38_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:141:7: (e1= getExcludedOwnersExpression | ( GET_INPUT_F getExcludedOwnersExpression ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LEFT_BRACKET||(LA17_0>=INTEGERLITERAL && LA17_0<=GET_EXCLUDED_OWNERS_F)) ) {
                alt17=1;
            }
            else if ( (LA17_0==GET_INPUT_F) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:141:9: e1= getExcludedOwnersExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getExcludedOwnersExpression_in_getInputExpression991);
                    e1=getExcludedOwnersExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:142:9: ( GET_INPUT_F getExcludedOwnersExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:142:9: ( GET_INPUT_F getExcludedOwnersExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:142:10: GET_INPUT_F getExcludedOwnersExpression
                    {
                    GET_INPUT_F38=(Token)match(input,GET_INPUT_F,FOLLOW_GET_INPUT_F_in_getInputExpression1004); 
                    GET_INPUT_F38_tree = (CommonTree)adaptor.create(GET_INPUT_F38);
                    adaptor.addChild(root_0, GET_INPUT_F38_tree);

                    pushFollow(FOLLOW_getExcludedOwnersExpression_in_getInputExpression1007);
                    getExcludedOwnersExpression39=getExcludedOwnersExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getExcludedOwnersExpression39.getTree());
                    retval.expr = new GetInputFunction((getExcludedOwnersExpression39!=null?getExcludedOwnersExpression39.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getInputExpression"

    public static class getLogicalPeopleGroupExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getLogicalPeopleGroupExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:145:1: getLogicalPeopleGroupExpression returns [Expression expr] : (e1= getInputExpression | ( GET_LOGICAL_PEOPLE_GROUP_F getInputExpression ) );
    public final SBQLParser.getLogicalPeopleGroupExpression_return getLogicalPeopleGroupExpression() throws RecognitionException {
        SBQLParser.getLogicalPeopleGroupExpression_return retval = new SBQLParser.getLogicalPeopleGroupExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_LOGICAL_PEOPLE_GROUP_F40=null;
        SBQLParser.getInputExpression_return e1 = null;

        SBQLParser.getInputExpression_return getInputExpression41 = null;


        CommonTree GET_LOGICAL_PEOPLE_GROUP_F40_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:146:7: (e1= getInputExpression | ( GET_LOGICAL_PEOPLE_GROUP_F getInputExpression ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LEFT_BRACKET||(LA18_0>=INTEGERLITERAL && LA18_0<=GET_INPUT_F)) ) {
                alt18=1;
            }
            else if ( (LA18_0==GET_LOGICAL_PEOPLE_GROUP_F) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:146:9: e1= getInputExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getInputExpression_in_getLogicalPeopleGroupExpression1046);
                    e1=getInputExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:147:9: ( GET_LOGICAL_PEOPLE_GROUP_F getInputExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:147:9: ( GET_LOGICAL_PEOPLE_GROUP_F getInputExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:147:10: GET_LOGICAL_PEOPLE_GROUP_F getInputExpression
                    {
                    GET_LOGICAL_PEOPLE_GROUP_F40=(Token)match(input,GET_LOGICAL_PEOPLE_GROUP_F,FOLLOW_GET_LOGICAL_PEOPLE_GROUP_F_in_getLogicalPeopleGroupExpression1059); 
                    GET_LOGICAL_PEOPLE_GROUP_F40_tree = (CommonTree)adaptor.create(GET_LOGICAL_PEOPLE_GROUP_F40);
                    adaptor.addChild(root_0, GET_LOGICAL_PEOPLE_GROUP_F40_tree);

                    pushFollow(FOLLOW_getInputExpression_in_getLogicalPeopleGroupExpression1062);
                    getInputExpression41=getInputExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getInputExpression41.getTree());
                    retval.expr = new GetLogicalPeopleGroupFunction((getInputExpression41!=null?getInputExpression41.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getLogicalPeopleGroupExpression"

    public static class getOutcomeExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getOutcomeExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:150:1: getOutcomeExpression returns [Expression expr] : (e1= getLogicalPeopleGroupExpression | ( GET_OUTCOME_F getLogicalPeopleGroupExpression ) );
    public final SBQLParser.getOutcomeExpression_return getOutcomeExpression() throws RecognitionException {
        SBQLParser.getOutcomeExpression_return retval = new SBQLParser.getOutcomeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_OUTCOME_F42=null;
        SBQLParser.getLogicalPeopleGroupExpression_return e1 = null;

        SBQLParser.getLogicalPeopleGroupExpression_return getLogicalPeopleGroupExpression43 = null;


        CommonTree GET_OUTCOME_F42_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:151:7: (e1= getLogicalPeopleGroupExpression | ( GET_OUTCOME_F getLogicalPeopleGroupExpression ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LEFT_BRACKET||(LA19_0>=INTEGERLITERAL && LA19_0<=GET_LOGICAL_PEOPLE_GROUP_F)) ) {
                alt19=1;
            }
            else if ( (LA19_0==GET_OUTCOME_F) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:151:9: e1= getLogicalPeopleGroupExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getLogicalPeopleGroupExpression_in_getOutcomeExpression1095);
                    e1=getLogicalPeopleGroupExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:152:9: ( GET_OUTCOME_F getLogicalPeopleGroupExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:152:9: ( GET_OUTCOME_F getLogicalPeopleGroupExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:152:10: GET_OUTCOME_F getLogicalPeopleGroupExpression
                    {
                    GET_OUTCOME_F42=(Token)match(input,GET_OUTCOME_F,FOLLOW_GET_OUTCOME_F_in_getOutcomeExpression1108); 
                    GET_OUTCOME_F42_tree = (CommonTree)adaptor.create(GET_OUTCOME_F42);
                    adaptor.addChild(root_0, GET_OUTCOME_F42_tree);

                    pushFollow(FOLLOW_getLogicalPeopleGroupExpression_in_getOutcomeExpression1111);
                    getLogicalPeopleGroupExpression43=getLogicalPeopleGroupExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getLogicalPeopleGroupExpression43.getTree());
                    retval.expr = new GetOutcomeFunction((getLogicalPeopleGroupExpression43!=null?getLogicalPeopleGroupExpression43.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getOutcomeExpression"

    public static class getOutputExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getOutputExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:155:1: getOutputExpression returns [Expression expr] : (e1= getOutcomeExpression | ( GET_OUTPUT_F getOutcomeExpression ) );
    public final SBQLParser.getOutputExpression_return getOutputExpression() throws RecognitionException {
        SBQLParser.getOutputExpression_return retval = new SBQLParser.getOutputExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_OUTPUT_F44=null;
        SBQLParser.getOutcomeExpression_return e1 = null;

        SBQLParser.getOutcomeExpression_return getOutcomeExpression45 = null;


        CommonTree GET_OUTPUT_F44_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:156:7: (e1= getOutcomeExpression | ( GET_OUTPUT_F getOutcomeExpression ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==LEFT_BRACKET||(LA20_0>=INTEGERLITERAL && LA20_0<=GET_OUTCOME_F)) ) {
                alt20=1;
            }
            else if ( (LA20_0==GET_OUTPUT_F) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:156:9: e1= getOutcomeExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getOutcomeExpression_in_getOutputExpression1144);
                    e1=getOutcomeExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:157:9: ( GET_OUTPUT_F getOutcomeExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:157:9: ( GET_OUTPUT_F getOutcomeExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:157:10: GET_OUTPUT_F getOutcomeExpression
                    {
                    GET_OUTPUT_F44=(Token)match(input,GET_OUTPUT_F,FOLLOW_GET_OUTPUT_F_in_getOutputExpression1157); 
                    GET_OUTPUT_F44_tree = (CommonTree)adaptor.create(GET_OUTPUT_F44);
                    adaptor.addChild(root_0, GET_OUTPUT_F44_tree);

                    pushFollow(FOLLOW_getOutcomeExpression_in_getOutputExpression1160);
                    getOutcomeExpression45=getOutcomeExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getOutcomeExpression45.getTree());
                    retval.expr = new GetOutputFunction((getOutcomeExpression45!=null?getOutcomeExpression45.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getOutputExpression"

    public static class getPotentialOwnersExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getPotentialOwnersExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:160:1: getPotentialOwnersExpression returns [Expression expr] : (e1= getOutputExpression | ( GET_POTENTIAL_OWNERS_F getOutputExpression ) );
    public final SBQLParser.getPotentialOwnersExpression_return getPotentialOwnersExpression() throws RecognitionException {
        SBQLParser.getPotentialOwnersExpression_return retval = new SBQLParser.getPotentialOwnersExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_POTENTIAL_OWNERS_F46=null;
        SBQLParser.getOutputExpression_return e1 = null;

        SBQLParser.getOutputExpression_return getOutputExpression47 = null;


        CommonTree GET_POTENTIAL_OWNERS_F46_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:161:7: (e1= getOutputExpression | ( GET_POTENTIAL_OWNERS_F getOutputExpression ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LEFT_BRACKET||(LA21_0>=INTEGERLITERAL && LA21_0<=GET_OUTPUT_F)) ) {
                alt21=1;
            }
            else if ( (LA21_0==GET_POTENTIAL_OWNERS_F) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:161:9: e1= getOutputExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getOutputExpression_in_getPotentialOwnersExpression1205);
                    e1=getOutputExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:162:9: ( GET_POTENTIAL_OWNERS_F getOutputExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:162:9: ( GET_POTENTIAL_OWNERS_F getOutputExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:162:10: GET_POTENTIAL_OWNERS_F getOutputExpression
                    {
                    GET_POTENTIAL_OWNERS_F46=(Token)match(input,GET_POTENTIAL_OWNERS_F,FOLLOW_GET_POTENTIAL_OWNERS_F_in_getPotentialOwnersExpression1218); 
                    GET_POTENTIAL_OWNERS_F46_tree = (CommonTree)adaptor.create(GET_POTENTIAL_OWNERS_F46);
                    adaptor.addChild(root_0, GET_POTENTIAL_OWNERS_F46_tree);

                    pushFollow(FOLLOW_getOutputExpression_in_getPotentialOwnersExpression1221);
                    getOutputExpression47=getOutputExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getOutputExpression47.getTree());
                    retval.expr = new GetPotentialOwnersFunction((getOutputExpression47!=null?getOutputExpression47.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getPotentialOwnersExpression"

    public static class getSubtaskOutputExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getSubtaskOutputExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:165:1: getSubtaskOutputExpression returns [Expression expr] : (e1= getPotentialOwnersExpression | ( GET_SUBTASK_OUTPUT_F getPotentialOwnersExpression ) );
    public final SBQLParser.getSubtaskOutputExpression_return getSubtaskOutputExpression() throws RecognitionException {
        SBQLParser.getSubtaskOutputExpression_return retval = new SBQLParser.getSubtaskOutputExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_SUBTASK_OUTPUT_F48=null;
        SBQLParser.getPotentialOwnersExpression_return e1 = null;

        SBQLParser.getPotentialOwnersExpression_return getPotentialOwnersExpression49 = null;


        CommonTree GET_SUBTASK_OUTPUT_F48_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:166:7: (e1= getPotentialOwnersExpression | ( GET_SUBTASK_OUTPUT_F getPotentialOwnersExpression ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LEFT_BRACKET||(LA22_0>=INTEGERLITERAL && LA22_0<=GET_POTENTIAL_OWNERS_F)) ) {
                alt22=1;
            }
            else if ( (LA22_0==GET_SUBTASK_OUTPUT_F) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:166:9: e1= getPotentialOwnersExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getPotentialOwnersExpression_in_getSubtaskOutputExpression1260);
                    e1=getPotentialOwnersExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:167:9: ( GET_SUBTASK_OUTPUT_F getPotentialOwnersExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:167:9: ( GET_SUBTASK_OUTPUT_F getPotentialOwnersExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:167:10: GET_SUBTASK_OUTPUT_F getPotentialOwnersExpression
                    {
                    GET_SUBTASK_OUTPUT_F48=(Token)match(input,GET_SUBTASK_OUTPUT_F,FOLLOW_GET_SUBTASK_OUTPUT_F_in_getSubtaskOutputExpression1273); 
                    GET_SUBTASK_OUTPUT_F48_tree = (CommonTree)adaptor.create(GET_SUBTASK_OUTPUT_F48);
                    adaptor.addChild(root_0, GET_SUBTASK_OUTPUT_F48_tree);

                    pushFollow(FOLLOW_getPotentialOwnersExpression_in_getSubtaskOutputExpression1276);
                    getPotentialOwnersExpression49=getPotentialOwnersExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getPotentialOwnersExpression49.getTree());
                    retval.expr = new GetSubtaskOutputFunction((getPotentialOwnersExpression49!=null?getPotentialOwnersExpression49.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getSubtaskOutputExpression"

    public static class getSubtaskOutputsExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getSubtaskOutputsExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:170:1: getSubtaskOutputsExpression returns [Expression expr] : (e1= getSubtaskOutputExpression | ( GET_SUBTASK_OUTPUTS_F getSubtaskOutputExpression ) );
    public final SBQLParser.getSubtaskOutputsExpression_return getSubtaskOutputsExpression() throws RecognitionException {
        SBQLParser.getSubtaskOutputsExpression_return retval = new SBQLParser.getSubtaskOutputsExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_SUBTASK_OUTPUTS_F50=null;
        SBQLParser.getSubtaskOutputExpression_return e1 = null;

        SBQLParser.getSubtaskOutputExpression_return getSubtaskOutputExpression51 = null;


        CommonTree GET_SUBTASK_OUTPUTS_F50_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:171:7: (e1= getSubtaskOutputExpression | ( GET_SUBTASK_OUTPUTS_F getSubtaskOutputExpression ) )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LEFT_BRACKET||(LA23_0>=INTEGERLITERAL && LA23_0<=GET_SUBTASK_OUTPUT_F)) ) {
                alt23=1;
            }
            else if ( (LA23_0==GET_SUBTASK_OUTPUTS_F) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:171:9: e1= getSubtaskOutputExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getSubtaskOutputExpression_in_getSubtaskOutputsExpression1315);
                    e1=getSubtaskOutputExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:172:9: ( GET_SUBTASK_OUTPUTS_F getSubtaskOutputExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:172:9: ( GET_SUBTASK_OUTPUTS_F getSubtaskOutputExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:172:10: GET_SUBTASK_OUTPUTS_F getSubtaskOutputExpression
                    {
                    GET_SUBTASK_OUTPUTS_F50=(Token)match(input,GET_SUBTASK_OUTPUTS_F,FOLLOW_GET_SUBTASK_OUTPUTS_F_in_getSubtaskOutputsExpression1328); 
                    GET_SUBTASK_OUTPUTS_F50_tree = (CommonTree)adaptor.create(GET_SUBTASK_OUTPUTS_F50);
                    adaptor.addChild(root_0, GET_SUBTASK_OUTPUTS_F50_tree);

                    pushFollow(FOLLOW_getSubtaskOutputExpression_in_getSubtaskOutputsExpression1331);
                    getSubtaskOutputExpression51=getSubtaskOutputExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getSubtaskOutputExpression51.getTree());
                    retval.expr = new GetSubtaskOutputsFunction((getSubtaskOutputExpression51!=null?getSubtaskOutputExpression51.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getSubtaskOutputsExpression"

    public static class getTaskInitiatorExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getTaskInitiatorExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:175:1: getTaskInitiatorExpression returns [Expression expr] : (e1= getSubtaskOutputsExpression | ( GET_TASK_INITIATOR_F getSubtaskOutputsExpression ) );
    public final SBQLParser.getTaskInitiatorExpression_return getTaskInitiatorExpression() throws RecognitionException {
        SBQLParser.getTaskInitiatorExpression_return retval = new SBQLParser.getTaskInitiatorExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_TASK_INITIATOR_F52=null;
        SBQLParser.getSubtaskOutputsExpression_return e1 = null;

        SBQLParser.getSubtaskOutputsExpression_return getSubtaskOutputsExpression53 = null;


        CommonTree GET_TASK_INITIATOR_F52_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:176:7: (e1= getSubtaskOutputsExpression | ( GET_TASK_INITIATOR_F getSubtaskOutputsExpression ) )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==LEFT_BRACKET||(LA24_0>=INTEGERLITERAL && LA24_0<=GET_SUBTASK_OUTPUTS_F)) ) {
                alt24=1;
            }
            else if ( (LA24_0==GET_TASK_INITIATOR_F) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:176:9: e1= getSubtaskOutputsExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getSubtaskOutputsExpression_in_getTaskInitiatorExpression1370);
                    e1=getSubtaskOutputsExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:177:9: ( GET_TASK_INITIATOR_F getSubtaskOutputsExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:177:9: ( GET_TASK_INITIATOR_F getSubtaskOutputsExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:177:10: GET_TASK_INITIATOR_F getSubtaskOutputsExpression
                    {
                    GET_TASK_INITIATOR_F52=(Token)match(input,GET_TASK_INITIATOR_F,FOLLOW_GET_TASK_INITIATOR_F_in_getTaskInitiatorExpression1383); 
                    GET_TASK_INITIATOR_F52_tree = (CommonTree)adaptor.create(GET_TASK_INITIATOR_F52);
                    adaptor.addChild(root_0, GET_TASK_INITIATOR_F52_tree);

                    pushFollow(FOLLOW_getSubtaskOutputsExpression_in_getTaskInitiatorExpression1386);
                    getSubtaskOutputsExpression53=getSubtaskOutputsExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getSubtaskOutputsExpression53.getTree());
                    retval.expr = new GetTaskInitiatorFunction((getSubtaskOutputsExpression53!=null?getSubtaskOutputsExpression53.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getTaskInitiatorExpression"

    public static class getTaskPriorityExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getTaskPriorityExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:180:1: getTaskPriorityExpression returns [Expression expr] : (e1= getTaskInitiatorExpression | ( GET_TASK_PRIORITY_F getTaskInitiatorExpression ) );
    public final SBQLParser.getTaskPriorityExpression_return getTaskPriorityExpression() throws RecognitionException {
        SBQLParser.getTaskPriorityExpression_return retval = new SBQLParser.getTaskPriorityExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_TASK_PRIORITY_F54=null;
        SBQLParser.getTaskInitiatorExpression_return e1 = null;

        SBQLParser.getTaskInitiatorExpression_return getTaskInitiatorExpression55 = null;


        CommonTree GET_TASK_PRIORITY_F54_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:181:7: (e1= getTaskInitiatorExpression | ( GET_TASK_PRIORITY_F getTaskInitiatorExpression ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LEFT_BRACKET||(LA25_0>=INTEGERLITERAL && LA25_0<=GET_TASK_INITIATOR_F)) ) {
                alt25=1;
            }
            else if ( (LA25_0==GET_TASK_PRIORITY_F) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:181:9: e1= getTaskInitiatorExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getTaskInitiatorExpression_in_getTaskPriorityExpression1425);
                    e1=getTaskInitiatorExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:182:9: ( GET_TASK_PRIORITY_F getTaskInitiatorExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:182:9: ( GET_TASK_PRIORITY_F getTaskInitiatorExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:182:10: GET_TASK_PRIORITY_F getTaskInitiatorExpression
                    {
                    GET_TASK_PRIORITY_F54=(Token)match(input,GET_TASK_PRIORITY_F,FOLLOW_GET_TASK_PRIORITY_F_in_getTaskPriorityExpression1438); 
                    GET_TASK_PRIORITY_F54_tree = (CommonTree)adaptor.create(GET_TASK_PRIORITY_F54);
                    adaptor.addChild(root_0, GET_TASK_PRIORITY_F54_tree);

                    pushFollow(FOLLOW_getTaskInitiatorExpression_in_getTaskPriorityExpression1441);
                    getTaskInitiatorExpression55=getTaskInitiatorExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getTaskInitiatorExpression55.getTree());
                    retval.expr = new GetTaskPriorityFunction((getTaskInitiatorExpression55!=null?getTaskInitiatorExpression55.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getTaskPriorityExpression"

    public static class getTaskStakeholdersExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getTaskStakeholdersExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:185:1: getTaskStakeholdersExpression returns [Expression expr] : (e1= getTaskPriorityExpression | ( GET_TASK_STAKEHOLDERS_F getTaskPriorityExpression ) );
    public final SBQLParser.getTaskStakeholdersExpression_return getTaskStakeholdersExpression() throws RecognitionException {
        SBQLParser.getTaskStakeholdersExpression_return retval = new SBQLParser.getTaskStakeholdersExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GET_TASK_STAKEHOLDERS_F56=null;
        SBQLParser.getTaskPriorityExpression_return e1 = null;

        SBQLParser.getTaskPriorityExpression_return getTaskPriorityExpression57 = null;


        CommonTree GET_TASK_STAKEHOLDERS_F56_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:186:7: (e1= getTaskPriorityExpression | ( GET_TASK_STAKEHOLDERS_F getTaskPriorityExpression ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==LEFT_BRACKET||(LA26_0>=INTEGERLITERAL && LA26_0<=GET_TASK_PRIORITY_F)) ) {
                alt26=1;
            }
            else if ( (LA26_0==GET_TASK_STAKEHOLDERS_F) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:186:9: e1= getTaskPriorityExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getTaskPriorityExpression_in_getTaskStakeholdersExpression1480);
                    e1=getTaskPriorityExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:187:9: ( GET_TASK_STAKEHOLDERS_F getTaskPriorityExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:187:9: ( GET_TASK_STAKEHOLDERS_F getTaskPriorityExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:187:10: GET_TASK_STAKEHOLDERS_F getTaskPriorityExpression
                    {
                    GET_TASK_STAKEHOLDERS_F56=(Token)match(input,GET_TASK_STAKEHOLDERS_F,FOLLOW_GET_TASK_STAKEHOLDERS_F_in_getTaskStakeholdersExpression1493); 
                    GET_TASK_STAKEHOLDERS_F56_tree = (CommonTree)adaptor.create(GET_TASK_STAKEHOLDERS_F56);
                    adaptor.addChild(root_0, GET_TASK_STAKEHOLDERS_F56_tree);

                    pushFollow(FOLLOW_getTaskPriorityExpression_in_getTaskStakeholdersExpression1496);
                    getTaskPriorityExpression57=getTaskPriorityExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getTaskPriorityExpression57.getTree());
                    retval.expr = new GetTaskStakeholdersFunction((getTaskPriorityExpression57!=null?getTaskPriorityExpression57.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getTaskStakeholdersExpression"

    public static class waitForExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "waitForExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:190:1: waitForExpression returns [Expression expr] : (e1= getTaskStakeholdersExpression | ( WAIT_FOR_F getTaskStakeholdersExpression ) );
    public final SBQLParser.waitForExpression_return waitForExpression() throws RecognitionException {
        SBQLParser.waitForExpression_return retval = new SBQLParser.waitForExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WAIT_FOR_F58=null;
        SBQLParser.getTaskStakeholdersExpression_return e1 = null;

        SBQLParser.getTaskStakeholdersExpression_return getTaskStakeholdersExpression59 = null;


        CommonTree WAIT_FOR_F58_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:191:7: (e1= getTaskStakeholdersExpression | ( WAIT_FOR_F getTaskStakeholdersExpression ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LEFT_BRACKET||(LA27_0>=INTEGERLITERAL && LA27_0<=GET_TASK_STAKEHOLDERS_F)) ) {
                alt27=1;
            }
            else if ( (LA27_0==WAIT_FOR_F) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:191:9: e1= getTaskStakeholdersExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getTaskStakeholdersExpression_in_waitForExpression1535);
                    e1=getTaskStakeholdersExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:192:9: ( WAIT_FOR_F getTaskStakeholdersExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:192:9: ( WAIT_FOR_F getTaskStakeholdersExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:192:10: WAIT_FOR_F getTaskStakeholdersExpression
                    {
                    WAIT_FOR_F58=(Token)match(input,WAIT_FOR_F,FOLLOW_WAIT_FOR_F_in_waitForExpression1548); 
                    WAIT_FOR_F58_tree = (CommonTree)adaptor.create(WAIT_FOR_F58);
                    adaptor.addChild(root_0, WAIT_FOR_F58_tree);

                    pushFollow(FOLLOW_getTaskStakeholdersExpression_in_waitForExpression1551);
                    getTaskStakeholdersExpression59=getTaskStakeholdersExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, getTaskStakeholdersExpression59.getTree());
                    retval.expr = new WaitForFunction((getTaskStakeholdersExpression59!=null?getTaskStakeholdersExpression59.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "waitForExpression"

    public static class waitUntilExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "waitUntilExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:195:1: waitUntilExpression returns [Expression expr] : (e1= waitForExpression | ( WAIT_UNTIL_F waitForExpression ) );
    public final SBQLParser.waitUntilExpression_return waitUntilExpression() throws RecognitionException {
        SBQLParser.waitUntilExpression_return retval = new SBQLParser.waitUntilExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WAIT_UNTIL_F60=null;
        SBQLParser.waitForExpression_return e1 = null;

        SBQLParser.waitForExpression_return waitForExpression61 = null;


        CommonTree WAIT_UNTIL_F60_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:196:7: (e1= waitForExpression | ( WAIT_UNTIL_F waitForExpression ) )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==LEFT_BRACKET||(LA28_0>=INTEGERLITERAL && LA28_0<=WAIT_FOR_F)) ) {
                alt28=1;
            }
            else if ( (LA28_0==WAIT_UNTIL_F) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:196:9: e1= waitForExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_waitForExpression_in_waitUntilExpression1590);
                    e1=waitForExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:197:9: ( WAIT_UNTIL_F waitForExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:197:9: ( WAIT_UNTIL_F waitForExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:197:10: WAIT_UNTIL_F waitForExpression
                    {
                    WAIT_UNTIL_F60=(Token)match(input,WAIT_UNTIL_F,FOLLOW_WAIT_UNTIL_F_in_waitUntilExpression1603); 
                    WAIT_UNTIL_F60_tree = (CommonTree)adaptor.create(WAIT_UNTIL_F60);
                    adaptor.addChild(root_0, WAIT_UNTIL_F60_tree);

                    pushFollow(FOLLOW_waitForExpression_in_waitUntilExpression1606);
                    waitForExpression61=waitForExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, waitForExpression61.getTree());
                    retval.expr = new WaitUntilFunction((waitForExpression61!=null?waitForExpression61.expr:null));

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "waitUntilExpression"

    public static class sumExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sumExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:201:1: sumExpression returns [Expression expr] : (e1= waitUntilExpression | SUM waitUntilExpression );
    public final SBQLParser.sumExpression_return sumExpression() throws RecognitionException {
        SBQLParser.sumExpression_return retval = new SBQLParser.sumExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SUM62=null;
        SBQLParser.waitUntilExpression_return e1 = null;

        SBQLParser.waitUntilExpression_return waitUntilExpression63 = null;


        CommonTree SUM62_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:202:7: (e1= waitUntilExpression | SUM waitUntilExpression )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LEFT_BRACKET||(LA29_0>=INTEGERLITERAL && LA29_0<=WAIT_UNTIL_F)) ) {
                alt29=1;
            }
            else if ( (LA29_0==SUM) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:202:9: e1= waitUntilExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_waitUntilExpression_in_sumExpression1647);
                    e1=waitUntilExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:203:9: SUM waitUntilExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    SUM62=(Token)match(input,SUM,FOLLOW_SUM_in_sumExpression1659); 
                    SUM62_tree = (CommonTree)adaptor.create(SUM62);
                    adaptor.addChild(root_0, SUM62_tree);

                    pushFollow(FOLLOW_waitUntilExpression_in_sumExpression1662);
                    waitUntilExpression63=waitUntilExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, waitUntilExpression63.getTree());
                    retval.expr = new SumOperator((waitUntilExpression63!=null?waitUntilExpression63.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sumExpression"

    public static class minExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "minExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:206:1: minExpression returns [Expression expr] : (e1= sumExpression | MIN sumExpression );
    public final SBQLParser.minExpression_return minExpression() throws RecognitionException {
        SBQLParser.minExpression_return retval = new SBQLParser.minExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MIN64=null;
        SBQLParser.sumExpression_return e1 = null;

        SBQLParser.sumExpression_return sumExpression65 = null;


        CommonTree MIN64_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:207:7: (e1= sumExpression | MIN sumExpression )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==LEFT_BRACKET||(LA30_0>=INTEGERLITERAL && LA30_0<=SUM)) ) {
                alt30=1;
            }
            else if ( (LA30_0==MIN) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:207:9: e1= sumExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_sumExpression_in_minExpression1704);
                    e1=sumExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:208:9: MIN sumExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MIN64=(Token)match(input,MIN,FOLLOW_MIN_in_minExpression1716); 
                    MIN64_tree = (CommonTree)adaptor.create(MIN64);
                    adaptor.addChild(root_0, MIN64_tree);

                    pushFollow(FOLLOW_sumExpression_in_minExpression1719);
                    sumExpression65=sumExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, sumExpression65.getTree());
                    retval.expr = new MinOperator((sumExpression65!=null?sumExpression65.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "minExpression"

    public static class maxExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "maxExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:211:1: maxExpression returns [Expression expr] : (e1= minExpression | MAX minExpression );
    public final SBQLParser.maxExpression_return maxExpression() throws RecognitionException {
        SBQLParser.maxExpression_return retval = new SBQLParser.maxExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MAX66=null;
        SBQLParser.minExpression_return e1 = null;

        SBQLParser.minExpression_return minExpression67 = null;


        CommonTree MAX66_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:212:7: (e1= minExpression | MAX minExpression )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==LEFT_BRACKET||(LA31_0>=INTEGERLITERAL && LA31_0<=MIN)) ) {
                alt31=1;
            }
            else if ( (LA31_0==MAX) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:212:9: e1= minExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_minExpression_in_maxExpression1759);
                    e1=minExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:213:9: MAX minExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    MAX66=(Token)match(input,MAX,FOLLOW_MAX_in_maxExpression1771); 
                    MAX66_tree = (CommonTree)adaptor.create(MAX66);
                    adaptor.addChild(root_0, MAX66_tree);

                    pushFollow(FOLLOW_minExpression_in_maxExpression1774);
                    minExpression67=minExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, minExpression67.getTree());
                    retval.expr = new MaxOperator((minExpression67!=null?minExpression67.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "maxExpression"

    public static class avgExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "avgExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:216:1: avgExpression returns [Expression expr] : (e1= maxExpression | AVG maxExpression );
    public final SBQLParser.avgExpression_return avgExpression() throws RecognitionException {
        SBQLParser.avgExpression_return retval = new SBQLParser.avgExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AVG68=null;
        SBQLParser.maxExpression_return e1 = null;

        SBQLParser.maxExpression_return maxExpression69 = null;


        CommonTree AVG68_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:217:7: (e1= maxExpression | AVG maxExpression )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==LEFT_BRACKET||(LA32_0>=INTEGERLITERAL && LA32_0<=MAX)) ) {
                alt32=1;
            }
            else if ( (LA32_0==AVG) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:217:9: e1= maxExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_maxExpression_in_avgExpression1807);
                    e1=maxExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:218:9: AVG maxExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    AVG68=(Token)match(input,AVG,FOLLOW_AVG_in_avgExpression1819); 
                    AVG68_tree = (CommonTree)adaptor.create(AVG68);
                    adaptor.addChild(root_0, AVG68_tree);

                    pushFollow(FOLLOW_maxExpression_in_avgExpression1822);
                    maxExpression69=maxExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, maxExpression69.getTree());
                    retval.expr = new AvgOperator((maxExpression69!=null?maxExpression69.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "avgExpression"

    public static class countExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:221:1: countExpression returns [Expression expr] : (e1= avgExpression | COUNT avgExpression );
    public final SBQLParser.countExpression_return countExpression() throws RecognitionException {
        SBQLParser.countExpression_return retval = new SBQLParser.countExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COUNT70=null;
        SBQLParser.avgExpression_return e1 = null;

        SBQLParser.avgExpression_return avgExpression71 = null;


        CommonTree COUNT70_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:222:7: (e1= avgExpression | COUNT avgExpression )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==LEFT_BRACKET||(LA33_0>=INTEGERLITERAL && LA33_0<=AVG)) ) {
                alt33=1;
            }
            else if ( (LA33_0==COUNT) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:222:9: e1= avgExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_avgExpression_in_countExpression1863);
                    e1=avgExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:223:9: COUNT avgExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    COUNT70=(Token)match(input,COUNT,FOLLOW_COUNT_in_countExpression1875); 
                    COUNT70_tree = (CommonTree)adaptor.create(COUNT70);
                    adaptor.addChild(root_0, COUNT70_tree);

                    pushFollow(FOLLOW_avgExpression_in_countExpression1878);
                    avgExpression71=avgExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, avgExpression71.getTree());
                    retval.expr = new CountOperator((avgExpression71!=null?avgExpression71.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countExpression"

    public static class structExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "structExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:228:1: structExpression returns [Expression expr] : (e1= countExpression | ( STRUCT e1= countExpression ) );
    public final SBQLParser.structExpression_return structExpression() throws RecognitionException {
        SBQLParser.structExpression_return retval = new SBQLParser.structExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRUCT72=null;
        SBQLParser.countExpression_return e1 = null;


        CommonTree STRUCT72_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:229:7: (e1= countExpression | ( STRUCT e1= countExpression ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==LEFT_BRACKET||(LA34_0>=INTEGERLITERAL && LA34_0<=COUNT)) ) {
                alt34=1;
            }
            else if ( (LA34_0==STRUCT) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:229:9: e1= countExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_countExpression_in_structExpression1913);
                    e1=countExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:230:9: ( STRUCT e1= countExpression )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:230:9: ( STRUCT e1= countExpression )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:230:10: STRUCT e1= countExpression
                    {
                    STRUCT72=(Token)match(input,STRUCT,FOLLOW_STRUCT_in_structExpression1926); 
                    STRUCT72_tree = (CommonTree)adaptor.create(STRUCT72);
                    adaptor.addChild(root_0, STRUCT72_tree);

                    pushFollow(FOLLOW_countExpression_in_structExpression1933);
                    e1=countExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());

                    }

                    retval.expr = new StructConstructor((e1!=null?e1.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "structExpression"

    public static class bagExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bagExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:234:1: bagExpression returns [Expression expr] : (e1= structExpression | BAG e1= structExpression );
    public final SBQLParser.bagExpression_return bagExpression() throws RecognitionException {
        SBQLParser.bagExpression_return retval = new SBQLParser.bagExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BAG73=null;
        SBQLParser.structExpression_return e1 = null;


        CommonTree BAG73_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:235:7: (e1= structExpression | BAG e1= structExpression )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LEFT_BRACKET||(LA35_0>=INTEGERLITERAL && LA35_0<=STRUCT)) ) {
                alt35=1;
            }
            else if ( (LA35_0==BAG) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:235:9: e1= structExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_structExpression_in_bagExpression1982);
                    e1=structExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:236:9: BAG e1= structExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BAG73=(Token)match(input,BAG,FOLLOW_BAG_in_bagExpression1995); 
                    BAG73_tree = (CommonTree)adaptor.create(BAG73);
                    adaptor.addChild(root_0, BAG73_tree);

                    pushFollow(FOLLOW_structExpression_in_bagExpression2001);
                    e1=structExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = new BagConstructor((e1!=null?e1.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "bagExpression"

    public static class asExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "asExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:241:1: asExpression returns [Expression expr] : e1= bagExpression ( AS IDENTLITERAL )* ;
    public final SBQLParser.asExpression_return asExpression() throws RecognitionException {
        SBQLParser.asExpression_return retval = new SBQLParser.asExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AS74=null;
        Token IDENTLITERAL75=null;
        SBQLParser.bagExpression_return e1 = null;


        CommonTree AS74_tree=null;
        CommonTree IDENTLITERAL75_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:242:7: (e1= bagExpression ( AS IDENTLITERAL )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:242:9: e1= bagExpression ( AS IDENTLITERAL )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_bagExpression_in_asExpression2048);
            e1=bagExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:243:7: ( AS IDENTLITERAL )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==AS) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:243:8: AS IDENTLITERAL
            	    {
            	    AS74=(Token)match(input,AS,FOLLOW_AS_in_asExpression2060); 
            	    AS74_tree = (CommonTree)adaptor.create(AS74);
            	    adaptor.addChild(root_0, AS74_tree);

            	    IDENTLITERAL75=(Token)match(input,IDENTLITERAL,FOLLOW_IDENTLITERAL_in_asExpression2062); 
            	    IDENTLITERAL75_tree = (CommonTree)adaptor.create(IDENTLITERAL75);
            	    adaptor.addChild(root_0, IDENTLITERAL75_tree);

            	    retval.expr = new AsOperator(retval.expr, (IDENTLITERAL75!=null?IDENTLITERAL75.getText():null));

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "asExpression"

    public static class groupasExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "groupasExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:246:1: groupasExpression returns [Expression expr] : e1= asExpression ( GROUPAS IDENTLITERAL )* ;
    public final SBQLParser.groupasExpression_return groupasExpression() throws RecognitionException {
        SBQLParser.groupasExpression_return retval = new SBQLParser.groupasExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token GROUPAS76=null;
        Token IDENTLITERAL77=null;
        SBQLParser.asExpression_return e1 = null;


        CommonTree GROUPAS76_tree=null;
        CommonTree IDENTLITERAL77_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:247:7: (e1= asExpression ( GROUPAS IDENTLITERAL )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:247:9: e1= asExpression ( GROUPAS IDENTLITERAL )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_asExpression_in_groupasExpression2104);
            e1=asExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:248:7: ( GROUPAS IDENTLITERAL )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==GROUPAS) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:248:8: GROUPAS IDENTLITERAL
            	    {
            	    GROUPAS76=(Token)match(input,GROUPAS,FOLLOW_GROUPAS_in_groupasExpression2116); 
            	    GROUPAS76_tree = (CommonTree)adaptor.create(GROUPAS76);
            	    adaptor.addChild(root_0, GROUPAS76_tree);

            	    IDENTLITERAL77=(Token)match(input,IDENTLITERAL,FOLLOW_IDENTLITERAL_in_groupasExpression2118); 
            	    IDENTLITERAL77_tree = (CommonTree)adaptor.create(IDENTLITERAL77);
            	    adaptor.addChild(root_0, IDENTLITERAL77_tree);

            	    retval.expr = new GroupAsOperator(retval.expr, (IDENTLITERAL77!=null?IDENTLITERAL77.getText():null));

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "groupasExpression"

    public static class multExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:252:1: multExpression returns [Expression expr] : e1= groupasExpression ( MULT e2= groupasExpression | DIV e2= groupasExpression | MOD e2= groupasExpression )* ;
    public final SBQLParser.multExpression_return multExpression() throws RecognitionException {
        SBQLParser.multExpression_return retval = new SBQLParser.multExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MULT78=null;
        Token DIV79=null;
        Token MOD80=null;
        SBQLParser.groupasExpression_return e1 = null;

        SBQLParser.groupasExpression_return e2 = null;


        CommonTree MULT78_tree=null;
        CommonTree DIV79_tree=null;
        CommonTree MOD80_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:253:7: (e1= groupasExpression ( MULT e2= groupasExpression | DIV e2= groupasExpression | MOD e2= groupasExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:253:9: e1= groupasExpression ( MULT e2= groupasExpression | DIV e2= groupasExpression | MOD e2= groupasExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_groupasExpression_in_multExpression2165);
            e1=groupasExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:254:7: ( MULT e2= groupasExpression | DIV e2= groupasExpression | MOD e2= groupasExpression )*
            loop38:
            do {
                int alt38=4;
                switch ( input.LA(1) ) {
                case MULT:
                    {
                    alt38=1;
                    }
                    break;
                case DIV:
                    {
                    alt38=2;
                    }
                    break;
                case MOD:
                    {
                    alt38=3;
                    }
                    break;

                }

                switch (alt38) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:254:9: MULT e2= groupasExpression
            	    {
            	    MULT78=(Token)match(input,MULT,FOLLOW_MULT_in_multExpression2177); 
            	    MULT78_tree = (CommonTree)adaptor.create(MULT78);
            	    adaptor.addChild(root_0, MULT78_tree);

            	    pushFollow(FOLLOW_groupasExpression_in_multExpression2183);
            	    e2=groupasExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new MultiplyBinaryOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:255:9: DIV e2= groupasExpression
            	    {
            	    DIV79=(Token)match(input,DIV,FOLLOW_DIV_in_multExpression2195); 
            	    DIV79_tree = (CommonTree)adaptor.create(DIV79);
            	    adaptor.addChild(root_0, DIV79_tree);

            	    pushFollow(FOLLOW_groupasExpression_in_multExpression2201);
            	    e2=groupasExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new DivideBinaryOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 3 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:256:9: MOD e2= groupasExpression
            	    {
            	    MOD80=(Token)match(input,MOD,FOLLOW_MOD_in_multExpression2213); 
            	    MOD80_tree = (CommonTree)adaptor.create(MOD80);
            	    adaptor.addChild(root_0, MOD80_tree);

            	    pushFollow(FOLLOW_groupasExpression_in_multExpression2219);
            	    e2=groupasExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new ModBinaryOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multExpression"

    public static class additiveExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:260:1: additiveExpression returns [Expression expr] : e1= multExpression ( PLUS e2= multExpression | MINUS e2= multExpression )* ;
    public final SBQLParser.additiveExpression_return additiveExpression() throws RecognitionException {
        SBQLParser.additiveExpression_return retval = new SBQLParser.additiveExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token PLUS81=null;
        Token MINUS82=null;
        SBQLParser.multExpression_return e1 = null;

        SBQLParser.multExpression_return e2 = null;


        CommonTree PLUS81_tree=null;
        CommonTree MINUS82_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:261:7: (e1= multExpression ( PLUS e2= multExpression | MINUS e2= multExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:261:9: e1= multExpression ( PLUS e2= multExpression | MINUS e2= multExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_multExpression_in_additiveExpression2259);
            e1=multExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:262:7: ( PLUS e2= multExpression | MINUS e2= multExpression )*
            loop39:
            do {
                int alt39=3;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==PLUS) ) {
                    alt39=1;
                }
                else if ( (LA39_0==MINUS) ) {
                    alt39=2;
                }


                switch (alt39) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:262:9: PLUS e2= multExpression
            	    {
            	    PLUS81=(Token)match(input,PLUS,FOLLOW_PLUS_in_additiveExpression2271); 
            	    PLUS81_tree = (CommonTree)adaptor.create(PLUS81);
            	    adaptor.addChild(root_0, PLUS81_tree);

            	    pushFollow(FOLLOW_multExpression_in_additiveExpression2277);
            	    e2=multExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new PlusBinaryOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:263:9: MINUS e2= multExpression
            	    {
            	    MINUS82=(Token)match(input,MINUS,FOLLOW_MINUS_in_additiveExpression2289); 
            	    MINUS82_tree = (CommonTree)adaptor.create(MINUS82);
            	    adaptor.addChild(root_0, MINUS82_tree);

            	    pushFollow(FOLLOW_multExpression_in_additiveExpression2295);
            	    e2=multExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new MinusBinaryOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "additiveExpression"

    public static class booleanOrExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanOrExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:267:1: booleanOrExpression returns [Expression expr] : e1= additiveExpression ( OR e2= additiveExpression )* ;
    public final SBQLParser.booleanOrExpression_return booleanOrExpression() throws RecognitionException {
        SBQLParser.booleanOrExpression_return retval = new SBQLParser.booleanOrExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OR83=null;
        SBQLParser.additiveExpression_return e1 = null;

        SBQLParser.additiveExpression_return e2 = null;


        CommonTree OR83_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:268:7: (e1= additiveExpression ( OR e2= additiveExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:268:10: e1= additiveExpression ( OR e2= additiveExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_booleanOrExpression2342);
            e1=additiveExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:269:7: ( OR e2= additiveExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==OR) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:269:9: OR e2= additiveExpression
            	    {
            	    OR83=(Token)match(input,OR,FOLLOW_OR_in_booleanOrExpression2354); 
            	    OR83_tree = (CommonTree)adaptor.create(OR83);
            	    adaptor.addChild(root_0, OR83_tree);

            	    pushFollow(FOLLOW_additiveExpression_in_booleanOrExpression2360);
            	    e2=additiveExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new OrOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanOrExpression"

    public static class booleanAndExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "booleanAndExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:273:1: booleanAndExpression returns [Expression expr] : e1= booleanOrExpression ( AND e2= booleanOrExpression )* ;
    public final SBQLParser.booleanAndExpression_return booleanAndExpression() throws RecognitionException {
        SBQLParser.booleanAndExpression_return retval = new SBQLParser.booleanAndExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND84=null;
        SBQLParser.booleanOrExpression_return e1 = null;

        SBQLParser.booleanOrExpression_return e2 = null;


        CommonTree AND84_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:274:7: (e1= booleanOrExpression ( AND e2= booleanOrExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:274:10: e1= booleanOrExpression ( AND e2= booleanOrExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_booleanOrExpression_in_booleanAndExpression2407);
            e1=booleanOrExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:275:7: ( AND e2= booleanOrExpression )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==AND) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:275:9: AND e2= booleanOrExpression
            	    {
            	    AND84=(Token)match(input,AND,FOLLOW_AND_in_booleanAndExpression2419); 
            	    AND84_tree = (CommonTree)adaptor.create(AND84);
            	    adaptor.addChild(root_0, AND84_tree);

            	    pushFollow(FOLLOW_booleanOrExpression_in_booleanAndExpression2425);
            	    e2=booleanOrExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new AndOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "booleanAndExpression"

    public static class equityExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equityExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:279:1: equityExpression returns [Expression expr] : e1= booleanAndExpression ( EQUALS e2= booleanAndExpression | NOTEQUALS e2= booleanAndExpression | GT e2= booleanAndExpression | LT e2= booleanAndExpression | GE e2= booleanAndExpression | LE e2= booleanAndExpression )* ;
    public final SBQLParser.equityExpression_return equityExpression() throws RecognitionException {
        SBQLParser.equityExpression_return retval = new SBQLParser.equityExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EQUALS85=null;
        Token NOTEQUALS86=null;
        Token GT87=null;
        Token LT88=null;
        Token GE89=null;
        Token LE90=null;
        SBQLParser.booleanAndExpression_return e1 = null;

        SBQLParser.booleanAndExpression_return e2 = null;


        CommonTree EQUALS85_tree=null;
        CommonTree NOTEQUALS86_tree=null;
        CommonTree GT87_tree=null;
        CommonTree LT88_tree=null;
        CommonTree GE89_tree=null;
        CommonTree LE90_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:280:7: (e1= booleanAndExpression ( EQUALS e2= booleanAndExpression | NOTEQUALS e2= booleanAndExpression | GT e2= booleanAndExpression | LT e2= booleanAndExpression | GE e2= booleanAndExpression | LE e2= booleanAndExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:280:9: e1= booleanAndExpression ( EQUALS e2= booleanAndExpression | NOTEQUALS e2= booleanAndExpression | GT e2= booleanAndExpression | LT e2= booleanAndExpression | GE e2= booleanAndExpression | LE e2= booleanAndExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2471);
            e1=booleanAndExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:281:7: ( EQUALS e2= booleanAndExpression | NOTEQUALS e2= booleanAndExpression | GT e2= booleanAndExpression | LT e2= booleanAndExpression | GE e2= booleanAndExpression | LE e2= booleanAndExpression )*
            loop42:
            do {
                int alt42=7;
                switch ( input.LA(1) ) {
                case EQUALS:
                    {
                    alt42=1;
                    }
                    break;
                case NOTEQUALS:
                    {
                    alt42=2;
                    }
                    break;
                case GT:
                    {
                    alt42=3;
                    }
                    break;
                case LT:
                    {
                    alt42=4;
                    }
                    break;
                case GE:
                    {
                    alt42=5;
                    }
                    break;
                case LE:
                    {
                    alt42=6;
                    }
                    break;

                }

                switch (alt42) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:281:9: EQUALS e2= booleanAndExpression
            	    {
            	    EQUALS85=(Token)match(input,EQUALS,FOLLOW_EQUALS_in_equityExpression2483); 
            	    EQUALS85_tree = (CommonTree)adaptor.create(EQUALS85);
            	    adaptor.addChild(root_0, EQUALS85_tree);

            	    pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2489);
            	    e2=booleanAndExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new EqualsOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 2 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:282:9: NOTEQUALS e2= booleanAndExpression
            	    {
            	    NOTEQUALS86=(Token)match(input,NOTEQUALS,FOLLOW_NOTEQUALS_in_equityExpression2501); 
            	    NOTEQUALS86_tree = (CommonTree)adaptor.create(NOTEQUALS86);
            	    adaptor.addChild(root_0, NOTEQUALS86_tree);

            	    pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2507);
            	    e2=booleanAndExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new NotEqualsOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 3 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:283:9: GT e2= booleanAndExpression
            	    {
            	    GT87=(Token)match(input,GT,FOLLOW_GT_in_equityExpression2519); 
            	    GT87_tree = (CommonTree)adaptor.create(GT87);
            	    adaptor.addChild(root_0, GT87_tree);

            	    pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2525);
            	    e2=booleanAndExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new GreaterOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 4 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:284:9: LT e2= booleanAndExpression
            	    {
            	    LT88=(Token)match(input,LT,FOLLOW_LT_in_equityExpression2537); 
            	    LT88_tree = (CommonTree)adaptor.create(LT88);
            	    adaptor.addChild(root_0, LT88_tree);

            	    pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2543);
            	    e2=booleanAndExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new LessOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 5 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:285:9: GE e2= booleanAndExpression
            	    {
            	    GE89=(Token)match(input,GE,FOLLOW_GE_in_equityExpression2555); 
            	    GE89_tree = (CommonTree)adaptor.create(GE89);
            	    adaptor.addChild(root_0, GE89_tree);

            	    pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2561);
            	    e2=booleanAndExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new GreaterEqualsOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;
            	case 6 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:286:9: LE e2= booleanAndExpression
            	    {
            	    LE90=(Token)match(input,LE,FOLLOW_LE_in_equityExpression2573); 
            	    LE90_tree = (CommonTree)adaptor.create(LE90);
            	    adaptor.addChild(root_0, LE90_tree);

            	    pushFollow(FOLLOW_booleanAndExpression_in_equityExpression2579);
            	    e2=booleanAndExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new LessEqualsOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "equityExpression"

    public static class dotExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dotExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:290:1: dotExpression returns [Expression expr] : e1= equityExpression ( DOT e2= equityExpression )* ;
    public final SBQLParser.dotExpression_return dotExpression() throws RecognitionException {
        SBQLParser.dotExpression_return retval = new SBQLParser.dotExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DOT91=null;
        SBQLParser.equityExpression_return e1 = null;

        SBQLParser.equityExpression_return e2 = null;


        CommonTree DOT91_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:291:7: (e1= equityExpression ( DOT e2= equityExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:291:9: e1= equityExpression ( DOT e2= equityExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_equityExpression_in_dotExpression2619);
            e1=equityExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:292:7: ( DOT e2= equityExpression )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==DOT) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:292:9: DOT e2= equityExpression
            	    {
            	    DOT91=(Token)match(input,DOT,FOLLOW_DOT_in_dotExpression2631); 
            	    DOT91_tree = (CommonTree)adaptor.create(DOT91);
            	    adaptor.addChild(root_0, DOT91_tree);

            	    pushFollow(FOLLOW_equityExpression_in_dotExpression2637);
            	    e2=equityExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new DotExpression(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dotExpression"

    public static class whereExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "whereExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:295:1: whereExpression returns [Expression expr] : e1= dotExpression ( WHERE e2= dotExpression )* ;
    public final SBQLParser.whereExpression_return whereExpression() throws RecognitionException {
        SBQLParser.whereExpression_return retval = new SBQLParser.whereExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WHERE92=null;
        SBQLParser.dotExpression_return e1 = null;

        SBQLParser.dotExpression_return e2 = null;


        CommonTree WHERE92_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:296:7: (e1= dotExpression ( WHERE e2= dotExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:296:9: e1= dotExpression ( WHERE e2= dotExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_dotExpression_in_whereExpression2677);
            e1=dotExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:297:7: ( WHERE e2= dotExpression )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==WHERE) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:297:9: WHERE e2= dotExpression
            	    {
            	    WHERE92=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereExpression2689); 
            	    WHERE92_tree = (CommonTree)adaptor.create(WHERE92);
            	    adaptor.addChild(root_0, WHERE92_tree);

            	    pushFollow(FOLLOW_dotExpression_in_whereExpression2695);
            	    e2=dotExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new WhereExpression(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "whereExpression"

    public static class commaExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "commaExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:301:1: commaExpression returns [Expression expr] : e1= whereExpression ( COMA e2= whereExpression )* ;
    public final SBQLParser.commaExpression_return commaExpression() throws RecognitionException {
        SBQLParser.commaExpression_return retval = new SBQLParser.commaExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMA93=null;
        SBQLParser.whereExpression_return e1 = null;

        SBQLParser.whereExpression_return e2 = null;


        CommonTree COMA93_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:302:7: (e1= whereExpression ( COMA e2= whereExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:302:9: e1= whereExpression ( COMA e2= whereExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_whereExpression_in_commaExpression2730);
            e1=whereExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:303:7: ( COMA e2= whereExpression )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==COMA) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:303:9: COMA e2= whereExpression
            	    {
            	    COMA93=(Token)match(input,COMA,FOLLOW_COMA_in_commaExpression2742); 
            	    COMA93_tree = (CommonTree)adaptor.create(COMA93);
            	    adaptor.addChild(root_0, COMA93_tree);

            	    pushFollow(FOLLOW_whereExpression_in_commaExpression2748);
            	    e2=whereExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new CommaOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "commaExpression"

    public static class allExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "allExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:306:1: allExpression returns [Expression expr] : (e1= commaExpression | ( ALL LEFT_BRACKET e1= commaExpression RIGHT_BRACKET ) ( LEFT_BRACKET e2= commaExpression RIGHT_BRACKET ) );
    public final SBQLParser.allExpression_return allExpression() throws RecognitionException {
        SBQLParser.allExpression_return retval = new SBQLParser.allExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ALL94=null;
        Token LEFT_BRACKET95=null;
        Token RIGHT_BRACKET96=null;
        Token LEFT_BRACKET97=null;
        Token RIGHT_BRACKET98=null;
        SBQLParser.commaExpression_return e1 = null;

        SBQLParser.commaExpression_return e2 = null;


        CommonTree ALL94_tree=null;
        CommonTree LEFT_BRACKET95_tree=null;
        CommonTree RIGHT_BRACKET96_tree=null;
        CommonTree LEFT_BRACKET97_tree=null;
        CommonTree RIGHT_BRACKET98_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:307:7: (e1= commaExpression | ( ALL LEFT_BRACKET e1= commaExpression RIGHT_BRACKET ) ( LEFT_BRACKET e2= commaExpression RIGHT_BRACKET ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==LEFT_BRACKET||(LA46_0>=INTEGERLITERAL && LA46_0<=BAG)) ) {
                alt46=1;
            }
            else if ( (LA46_0==ALL) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:307:9: e1= commaExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_commaExpression_in_allExpression2787);
                    e1=commaExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:308:9: ( ALL LEFT_BRACKET e1= commaExpression RIGHT_BRACKET ) ( LEFT_BRACKET e2= commaExpression RIGHT_BRACKET )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:308:9: ( ALL LEFT_BRACKET e1= commaExpression RIGHT_BRACKET )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:308:10: ALL LEFT_BRACKET e1= commaExpression RIGHT_BRACKET
                    {
                    ALL94=(Token)match(input,ALL,FOLLOW_ALL_in_allExpression2800); 
                    ALL94_tree = (CommonTree)adaptor.create(ALL94);
                    adaptor.addChild(root_0, ALL94_tree);

                    LEFT_BRACKET95=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_allExpression2802); 
                    LEFT_BRACKET95_tree = (CommonTree)adaptor.create(LEFT_BRACKET95);
                    adaptor.addChild(root_0, LEFT_BRACKET95_tree);

                    pushFollow(FOLLOW_commaExpression_in_allExpression2806);
                    e1=commaExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    RIGHT_BRACKET96=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_allExpression2808); 
                    RIGHT_BRACKET96_tree = (CommonTree)adaptor.create(RIGHT_BRACKET96);
                    adaptor.addChild(root_0, RIGHT_BRACKET96_tree);


                    }

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:309:9: ( LEFT_BRACKET e2= commaExpression RIGHT_BRACKET )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:309:10: LEFT_BRACKET e2= commaExpression RIGHT_BRACKET
                    {
                    LEFT_BRACKET97=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_allExpression2821); 
                    LEFT_BRACKET97_tree = (CommonTree)adaptor.create(LEFT_BRACKET97);
                    adaptor.addChild(root_0, LEFT_BRACKET97_tree);

                    pushFollow(FOLLOW_commaExpression_in_allExpression2825);
                    e2=commaExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e2.getTree());
                    RIGHT_BRACKET98=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_allExpression2827); 
                    RIGHT_BRACKET98_tree = (CommonTree)adaptor.create(RIGHT_BRACKET98);
                    adaptor.addChild(root_0, RIGHT_BRACKET98_tree);


                    }

                    retval.expr = new AllOperator((e1!=null?e1.expr:null), (e2!=null?e2.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "allExpression"

    public static class anyExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "anyExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:313:1: anyExpression returns [Expression expr] : (e1= allExpression | ( ANY LEFT_BRACKET e1= allExpression RIGHT_BRACKET ) ( LEFT_BRACKET e2= allExpression RIGHT_BRACKET ) );
    public final SBQLParser.anyExpression_return anyExpression() throws RecognitionException {
        SBQLParser.anyExpression_return retval = new SBQLParser.anyExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ANY99=null;
        Token LEFT_BRACKET100=null;
        Token RIGHT_BRACKET101=null;
        Token LEFT_BRACKET102=null;
        Token RIGHT_BRACKET103=null;
        SBQLParser.allExpression_return e1 = null;

        SBQLParser.allExpression_return e2 = null;


        CommonTree ANY99_tree=null;
        CommonTree LEFT_BRACKET100_tree=null;
        CommonTree RIGHT_BRACKET101_tree=null;
        CommonTree LEFT_BRACKET102_tree=null;
        CommonTree RIGHT_BRACKET103_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:314:7: (e1= allExpression | ( ANY LEFT_BRACKET e1= allExpression RIGHT_BRACKET ) ( LEFT_BRACKET e2= allExpression RIGHT_BRACKET ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==LEFT_BRACKET||(LA47_0>=INTEGERLITERAL && LA47_0<=BAG)||LA47_0==ALL) ) {
                alt47=1;
            }
            else if ( (LA47_0==ANY) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:314:9: e1= allExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_allExpression_in_anyExpression2868);
                    e1=allExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    retval.expr = (e1!=null?e1.expr:null);

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:315:9: ( ANY LEFT_BRACKET e1= allExpression RIGHT_BRACKET ) ( LEFT_BRACKET e2= allExpression RIGHT_BRACKET )
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:315:9: ( ANY LEFT_BRACKET e1= allExpression RIGHT_BRACKET )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:315:10: ANY LEFT_BRACKET e1= allExpression RIGHT_BRACKET
                    {
                    ANY99=(Token)match(input,ANY,FOLLOW_ANY_in_anyExpression2882); 
                    ANY99_tree = (CommonTree)adaptor.create(ANY99);
                    adaptor.addChild(root_0, ANY99_tree);

                    LEFT_BRACKET100=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_anyExpression2884); 
                    LEFT_BRACKET100_tree = (CommonTree)adaptor.create(LEFT_BRACKET100);
                    adaptor.addChild(root_0, LEFT_BRACKET100_tree);

                    pushFollow(FOLLOW_allExpression_in_anyExpression2888);
                    e1=allExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e1.getTree());
                    RIGHT_BRACKET101=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_anyExpression2890); 
                    RIGHT_BRACKET101_tree = (CommonTree)adaptor.create(RIGHT_BRACKET101);
                    adaptor.addChild(root_0, RIGHT_BRACKET101_tree);


                    }

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:316:9: ( LEFT_BRACKET e2= allExpression RIGHT_BRACKET )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:316:10: LEFT_BRACKET e2= allExpression RIGHT_BRACKET
                    {
                    LEFT_BRACKET102=(Token)match(input,LEFT_BRACKET,FOLLOW_LEFT_BRACKET_in_anyExpression2903); 
                    LEFT_BRACKET102_tree = (CommonTree)adaptor.create(LEFT_BRACKET102);
                    adaptor.addChild(root_0, LEFT_BRACKET102_tree);

                    pushFollow(FOLLOW_allExpression_in_anyExpression2907);
                    e2=allExpression();

                    state._fsp--;

                    adaptor.addChild(root_0, e2.getTree());
                    RIGHT_BRACKET103=(Token)match(input,RIGHT_BRACKET,FOLLOW_RIGHT_BRACKET_in_anyExpression2909); 
                    RIGHT_BRACKET103_tree = (CommonTree)adaptor.create(RIGHT_BRACKET103);
                    adaptor.addChild(root_0, RIGHT_BRACKET103_tree);


                    }

                    retval.expr = new AnyOperator((e1!=null?e1.expr:null), (e2!=null?e2.expr:null));

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "anyExpression"

    public static class minusExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "minusExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:321:1: minusExpression returns [Expression expr] : e1= anyExpression ( MINUS_F e2= anyExpression )* ;
    public final SBQLParser.minusExpression_return minusExpression() throws RecognitionException {
        SBQLParser.minusExpression_return retval = new SBQLParser.minusExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token MINUS_F104=null;
        SBQLParser.anyExpression_return e1 = null;

        SBQLParser.anyExpression_return e2 = null;


        CommonTree MINUS_F104_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:322:7: (e1= anyExpression ( MINUS_F e2= anyExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:322:9: e1= anyExpression ( MINUS_F e2= anyExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_anyExpression_in_minusExpression2964);
            e1=anyExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:323:7: ( MINUS_F e2= anyExpression )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==MINUS_F) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:323:8: MINUS_F e2= anyExpression
            	    {
            	    MINUS_F104=(Token)match(input,MINUS_F,FOLLOW_MINUS_F_in_minusExpression2975); 
            	    MINUS_F104_tree = (CommonTree)adaptor.create(MINUS_F104);
            	    adaptor.addChild(root_0, MINUS_F104_tree);

            	    pushFollow(FOLLOW_anyExpression_in_minusExpression2981);
            	    e2=anyExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new MinusOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "minusExpression"

    public static class unionExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unionExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:326:1: unionExpression returns [Expression expr] : e1= minusExpression ( UNION_F e2= minusExpression )* ;
    public final SBQLParser.unionExpression_return unionExpression() throws RecognitionException {
        SBQLParser.unionExpression_return retval = new SBQLParser.unionExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UNION_F105=null;
        SBQLParser.minusExpression_return e1 = null;

        SBQLParser.minusExpression_return e2 = null;


        CommonTree UNION_F105_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:327:7: (e1= minusExpression ( UNION_F e2= minusExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:327:9: e1= minusExpression ( UNION_F e2= minusExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_minusExpression_in_unionExpression3021);
            e1=minusExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:328:7: ( UNION_F e2= minusExpression )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==UNION_F) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:328:8: UNION_F e2= minusExpression
            	    {
            	    UNION_F105=(Token)match(input,UNION_F,FOLLOW_UNION_F_in_unionExpression3032); 
            	    UNION_F105_tree = (CommonTree)adaptor.create(UNION_F105);
            	    adaptor.addChild(root_0, UNION_F105_tree);

            	    pushFollow(FOLLOW_minusExpression_in_unionExpression3038);
            	    e2=minusExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new UnionOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unionExpression"

    public static class exceptExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exceptExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:331:1: exceptExpression returns [Expression expr] : e1= unionExpression ( EXCEPT_F e2= unionExpression )* ;
    public final SBQLParser.exceptExpression_return exceptExpression() throws RecognitionException {
        SBQLParser.exceptExpression_return retval = new SBQLParser.exceptExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EXCEPT_F106=null;
        SBQLParser.unionExpression_return e1 = null;

        SBQLParser.unionExpression_return e2 = null;


        CommonTree EXCEPT_F106_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:332:7: (e1= unionExpression ( EXCEPT_F e2= unionExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:332:9: e1= unionExpression ( EXCEPT_F e2= unionExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unionExpression_in_exceptExpression3077);
            e1=unionExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:333:7: ( EXCEPT_F e2= unionExpression )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==EXCEPT_F) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:333:8: EXCEPT_F e2= unionExpression
            	    {
            	    EXCEPT_F106=(Token)match(input,EXCEPT_F,FOLLOW_EXCEPT_F_in_exceptExpression3088); 
            	    EXCEPT_F106_tree = (CommonTree)adaptor.create(EXCEPT_F106);
            	    adaptor.addChild(root_0, EXCEPT_F106_tree);

            	    pushFollow(FOLLOW_unionExpression_in_exceptExpression3094);
            	    e2=unionExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new ExceptFunction(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exceptExpression"

    public static class intersectExpression_return extends ParserRuleReturnScope {
        public Expression expr;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "intersectExpression"
    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:336:1: intersectExpression returns [Expression expr] : e1= exceptExpression ( INTERSECT_F e2= exceptExpression )* ;
    public final SBQLParser.intersectExpression_return intersectExpression() throws RecognitionException {
        SBQLParser.intersectExpression_return retval = new SBQLParser.intersectExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INTERSECT_F107=null;
        SBQLParser.exceptExpression_return e1 = null;

        SBQLParser.exceptExpression_return e2 = null;


        CommonTree INTERSECT_F107_tree=null;

        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:337:7: (e1= exceptExpression ( INTERSECT_F e2= exceptExpression )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:337:9: e1= exceptExpression ( INTERSECT_F e2= exceptExpression )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_exceptExpression_in_intersectExpression3134);
            e1=exceptExpression();

            state._fsp--;

            adaptor.addChild(root_0, e1.getTree());
            retval.expr = (e1!=null?e1.expr:null);
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:338:7: ( INTERSECT_F e2= exceptExpression )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==INTERSECT_F) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:338:8: INTERSECT_F e2= exceptExpression
            	    {
            	    INTERSECT_F107=(Token)match(input,INTERSECT_F,FOLLOW_INTERSECT_F_in_intersectExpression3145); 
            	    INTERSECT_F107_tree = (CommonTree)adaptor.create(INTERSECT_F107);
            	    adaptor.addChild(root_0, INTERSECT_F107_tree);

            	    pushFollow(FOLLOW_exceptExpression_in_intersectExpression3151);
            	    e2=exceptExpression();

            	    state._fsp--;

            	    adaptor.addChild(root_0, e2.getTree());
            	    retval.expr = new IntersectOperator(retval.expr, (e2!=null?e2.expr:null));

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "intersectExpression"

    // Delegated rules


 

    public static final BitSet FOLLOW_intersectExpression_in_evaluator81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_evaluator83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEFT_BRACKET_in_terminalExpression110 = new BitSet(new long[]{0x60001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_intersectExpression_in_terminalExpression116 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RIGHT_BRACKET_in_terminalExpression118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGERLITERAL_in_terminalExpression130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOUBLELITERAL_in_terminalExpression142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEANLITERAL_in_terminalExpression154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGLITERAL_in_terminalExpression166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTLITERAL_in_nameExpression201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminalExpression_in_nameExpression218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpression260 = new BitSet(new long[]{0x0000000000001FD0L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpression264 = new BitSet(new long[]{0x0000000000001FD0L});
    public static final BitSet FOLLOW_nameExpression_in_unaryExpression271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpression_in_concatExpression323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONCAT_F_in_concatExpression337 = new BitSet(new long[]{0x0000000000001FD0L});
    public static final BitSet FOLLOW_unaryExpression_in_concatExpression340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatExpression_in_concatWithDelimiterExpression379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONCAT_WITH_DELIMITER_F_in_concatWithDelimiterExpression393 = new BitSet(new long[]{0x0000000000003FD0L});
    public static final BitSet FOLLOW_concatExpression_in_concatWithDelimiterExpression396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatWithDelimiterExpression_in_voteExpression429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOTE_F_in_voteExpression442 = new BitSet(new long[]{0x0000000000007FD0L});
    public static final BitSet FOLLOW_concatWithDelimiterExpression_in_voteExpression444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voteExpression_in_voteOnStringExpression475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VOTE_ON_STRING_F_in_voteOnStringExpression488 = new BitSet(new long[]{0x000000000000FFD0L});
    public static final BitSet FOLLOW_voteExpression_in_voteOnStringExpression490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_voteOnStringExpression_in_leastFrequentOccurenceExpression528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEAST_FREQUENT_OCCURENCE_F_in_leastFrequentOccurenceExpression541 = new BitSet(new long[]{0x000000000001FFD0L});
    public static final BitSet FOLLOW_voteOnStringExpression_in_leastFrequentOccurenceExpression544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_leastFrequentOccurenceExpression_in_mostFrequentOccurenceExpression576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MOST_FREQUENT_OCCURENCE_F_in_mostFrequentOccurenceExpression589 = new BitSet(new long[]{0x000000000003FFD0L});
    public static final BitSet FOLLOW_leastFrequentOccurenceExpression_in_mostFrequentOccurenceExpression592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mostFrequentOccurenceExpression_in_getActualOwnerExpression625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_ACTUAL_OWNER_F_in_getActualOwnerExpression638 = new BitSet(new long[]{0x000000000007FFD0L});
    public static final BitSet FOLLOW_mostFrequentOccurenceExpression_in_getActualOwnerExpression641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getActualOwnerExpression_in_getBusinessAdministratorsExpression674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_BUSINESS_ADMINISTRATORS_F_in_getBusinessAdministratorsExpression687 = new BitSet(new long[]{0x00000000000FFFD0L});
    public static final BitSet FOLLOW_getActualOwnerExpression_in_getBusinessAdministratorsExpression690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getBusinessAdministratorsExpression_in_getCountOfFinishedSubTasksExpression729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_COUNT_OF_FINISHED_SUBTASKS_F_in_getCountOfFinishedSubTasksExpression742 = new BitSet(new long[]{0x00000000001FFFD0L});
    public static final BitSet FOLLOW_getBusinessAdministratorsExpression_in_getCountOfFinishedSubTasksExpression745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getCountOfFinishedSubTasksExpression_in_getCountOfSubTasksExpression784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_COUNT_OF_SUBTASKS_F_in_getCountOfSubTasksExpression797 = new BitSet(new long[]{0x00000000003FFFD0L});
    public static final BitSet FOLLOW_getCountOfFinishedSubTasksExpression_in_getCountOfSubTasksExpression800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getCountOfSubTasksExpression_in_getCountOfSubTasksInStateExpression839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_COUNT_OF_SUBTASKS_IN_STATE_F_in_getCountOfSubTasksInStateExpression852 = new BitSet(new long[]{0x00000000007FFFD0L});
    public static final BitSet FOLLOW_getCountOfSubTasksExpression_in_getCountOfSubTasksInStateExpression855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getCountOfSubTasksInStateExpression_in_getCountOfSubTasksWithOutcomeExpression894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F_in_getCountOfSubTasksWithOutcomeExpression907 = new BitSet(new long[]{0x0000000000FFFFD0L});
    public static final BitSet FOLLOW_getCountOfSubTasksInStateExpression_in_getCountOfSubTasksWithOutcomeExpression910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getCountOfSubTasksWithOutcomeExpression_in_getExcludedOwnersExpression943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_EXCLUDED_OWNERS_F_in_getExcludedOwnersExpression956 = new BitSet(new long[]{0x0000000001FFFFD0L});
    public static final BitSet FOLLOW_getCountOfSubTasksWithOutcomeExpression_in_getExcludedOwnersExpression959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getExcludedOwnersExpression_in_getInputExpression991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_INPUT_F_in_getInputExpression1004 = new BitSet(new long[]{0x0000000003FFFFD0L});
    public static final BitSet FOLLOW_getExcludedOwnersExpression_in_getInputExpression1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getInputExpression_in_getLogicalPeopleGroupExpression1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_LOGICAL_PEOPLE_GROUP_F_in_getLogicalPeopleGroupExpression1059 = new BitSet(new long[]{0x0000000007FFFFD0L});
    public static final BitSet FOLLOW_getInputExpression_in_getLogicalPeopleGroupExpression1062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getLogicalPeopleGroupExpression_in_getOutcomeExpression1095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_OUTCOME_F_in_getOutcomeExpression1108 = new BitSet(new long[]{0x000000000FFFFFD0L});
    public static final BitSet FOLLOW_getLogicalPeopleGroupExpression_in_getOutcomeExpression1111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getOutcomeExpression_in_getOutputExpression1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_OUTPUT_F_in_getOutputExpression1157 = new BitSet(new long[]{0x000000001FFFFFD0L});
    public static final BitSet FOLLOW_getOutcomeExpression_in_getOutputExpression1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getOutputExpression_in_getPotentialOwnersExpression1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_POTENTIAL_OWNERS_F_in_getPotentialOwnersExpression1218 = new BitSet(new long[]{0x000000003FFFFFD0L});
    public static final BitSet FOLLOW_getOutputExpression_in_getPotentialOwnersExpression1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getPotentialOwnersExpression_in_getSubtaskOutputExpression1260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_SUBTASK_OUTPUT_F_in_getSubtaskOutputExpression1273 = new BitSet(new long[]{0x000000007FFFFFD0L});
    public static final BitSet FOLLOW_getPotentialOwnersExpression_in_getSubtaskOutputExpression1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getSubtaskOutputExpression_in_getSubtaskOutputsExpression1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_SUBTASK_OUTPUTS_F_in_getSubtaskOutputsExpression1328 = new BitSet(new long[]{0x00000000FFFFFFD0L});
    public static final BitSet FOLLOW_getSubtaskOutputExpression_in_getSubtaskOutputsExpression1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getSubtaskOutputsExpression_in_getTaskInitiatorExpression1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_TASK_INITIATOR_F_in_getTaskInitiatorExpression1383 = new BitSet(new long[]{0x00000001FFFFFFD0L});
    public static final BitSet FOLLOW_getSubtaskOutputsExpression_in_getTaskInitiatorExpression1386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getTaskInitiatorExpression_in_getTaskPriorityExpression1425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_TASK_PRIORITY_F_in_getTaskPriorityExpression1438 = new BitSet(new long[]{0x00000003FFFFFFD0L});
    public static final BitSet FOLLOW_getTaskInitiatorExpression_in_getTaskPriorityExpression1441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getTaskPriorityExpression_in_getTaskStakeholdersExpression1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_TASK_STAKEHOLDERS_F_in_getTaskStakeholdersExpression1493 = new BitSet(new long[]{0x00000007FFFFFFD0L});
    public static final BitSet FOLLOW_getTaskPriorityExpression_in_getTaskStakeholdersExpression1496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getTaskStakeholdersExpression_in_waitForExpression1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WAIT_FOR_F_in_waitForExpression1548 = new BitSet(new long[]{0x0000000FFFFFFFD0L});
    public static final BitSet FOLLOW_getTaskStakeholdersExpression_in_waitForExpression1551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_waitForExpression_in_waitUntilExpression1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WAIT_UNTIL_F_in_waitUntilExpression1603 = new BitSet(new long[]{0x0000001FFFFFFFD0L});
    public static final BitSet FOLLOW_waitForExpression_in_waitUntilExpression1606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_waitUntilExpression_in_sumExpression1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_in_sumExpression1659 = new BitSet(new long[]{0x0000003FFFFFFFD0L});
    public static final BitSet FOLLOW_waitUntilExpression_in_sumExpression1662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sumExpression_in_minExpression1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_minExpression1716 = new BitSet(new long[]{0x0000007FFFFFFFD0L});
    public static final BitSet FOLLOW_sumExpression_in_minExpression1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_minExpression_in_maxExpression1759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_maxExpression1771 = new BitSet(new long[]{0x000000FFFFFFFFD0L});
    public static final BitSet FOLLOW_minExpression_in_maxExpression1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_maxExpression_in_avgExpression1807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AVG_in_avgExpression1819 = new BitSet(new long[]{0x000001FFFFFFFFD0L});
    public static final BitSet FOLLOW_maxExpression_in_avgExpression1822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_avgExpression_in_countExpression1863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_countExpression1875 = new BitSet(new long[]{0x000003FFFFFFFFD0L});
    public static final BitSet FOLLOW_avgExpression_in_countExpression1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countExpression_in_structExpression1913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRUCT_in_structExpression1926 = new BitSet(new long[]{0x000007FFFFFFFFD0L});
    public static final BitSet FOLLOW_countExpression_in_structExpression1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_structExpression_in_bagExpression1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BAG_in_bagExpression1995 = new BitSet(new long[]{0x00000FFFFFFFFFD0L});
    public static final BitSet FOLLOW_structExpression_in_bagExpression2001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bagExpression_in_asExpression2048 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_AS_in_asExpression2060 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDENTLITERAL_in_asExpression2062 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_asExpression_in_groupasExpression2104 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_GROUPAS_in_groupasExpression2116 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_IDENTLITERAL_in_groupasExpression2118 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_groupasExpression_in_multExpression2165 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_MULT_in_multExpression2177 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_groupasExpression_in_multExpression2183 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_DIV_in_multExpression2195 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_groupasExpression_in_multExpression2201 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_MOD_in_multExpression2213 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_groupasExpression_in_multExpression2219 = new BitSet(new long[]{0x0003800000000002L});
    public static final BitSet FOLLOW_multExpression_in_additiveExpression2259 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression2271 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_multExpression_in_additiveExpression2277 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpression2289 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_multExpression_in_additiveExpression2295 = new BitSet(new long[]{0x0000000000001802L});
    public static final BitSet FOLLOW_additiveExpression_in_booleanOrExpression2342 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_OR_in_booleanOrExpression2354 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_additiveExpression_in_booleanOrExpression2360 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_booleanOrExpression_in_booleanAndExpression2407 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_AND_in_booleanAndExpression2419 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanOrExpression_in_booleanAndExpression2425 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2471 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_EQUALS_in_equityExpression2483 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2489 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_NOTEQUALS_in_equityExpression2501 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2507 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_GT_in_equityExpression2519 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2525 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_LT_in_equityExpression2537 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2543 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_GE_in_equityExpression2555 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2561 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_LE_in_equityExpression2573 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_booleanAndExpression_in_equityExpression2579 = new BitSet(new long[]{0x03F0000000000002L});
    public static final BitSet FOLLOW_equityExpression_in_dotExpression2619 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_DOT_in_dotExpression2631 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_equityExpression_in_dotExpression2637 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_dotExpression_in_whereExpression2677 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_WHERE_in_whereExpression2689 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_dotExpression_in_whereExpression2695 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_whereExpression_in_commaExpression2730 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_COMA_in_commaExpression2742 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_whereExpression_in_commaExpression2748 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_commaExpression_in_allExpression2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALL_in_allExpression2800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LEFT_BRACKET_in_allExpression2802 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_commaExpression_in_allExpression2806 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RIGHT_BRACKET_in_allExpression2808 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LEFT_BRACKET_in_allExpression2821 = new BitSet(new long[]{0x00001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_commaExpression_in_allExpression2825 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RIGHT_BRACKET_in_allExpression2827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allExpression_in_anyExpression2868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ANY_in_anyExpression2882 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LEFT_BRACKET_in_anyExpression2884 = new BitSet(new long[]{0x20001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_allExpression_in_anyExpression2888 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RIGHT_BRACKET_in_anyExpression2890 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_LEFT_BRACKET_in_anyExpression2903 = new BitSet(new long[]{0x20001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_allExpression_in_anyExpression2907 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RIGHT_BRACKET_in_anyExpression2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_anyExpression_in_minusExpression2964 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_MINUS_F_in_minusExpression2975 = new BitSet(new long[]{0x60001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_anyExpression_in_minusExpression2981 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_minusExpression_in_unionExpression3021 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_UNION_F_in_unionExpression3032 = new BitSet(new long[]{0x60001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_minusExpression_in_unionExpression3038 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_unionExpression_in_exceptExpression3077 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_EXCEPT_F_in_exceptExpression3088 = new BitSet(new long[]{0x60001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_unionExpression_in_exceptExpression3094 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_exceptExpression_in_intersectExpression3134 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_INTERSECT_F_in_intersectExpression3145 = new BitSet(new long[]{0x60001FFFFFFFFFD0L});
    public static final BitSet FOLLOW_exceptExpression_in_intersectExpression3151 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});

}