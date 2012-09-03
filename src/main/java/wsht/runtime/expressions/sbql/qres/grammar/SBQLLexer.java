// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g 2012-06-24 20:31:04

package wsht.runtime.expressions.sbql.qres.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SBQLLexer extends Lexer {
    public static final int GET_EXCLUDED_OWNERS_F=25;
    public static final int WHERE=59;
    public static final int LEAST_FREQUENT_OCCURENCE_F=17;
    public static final int LT=55;
    public static final int EXPONENT=75;
    public static final int INTEGERLITERAL=6;
    public static final int VOTE_ON_STRING_F=16;
    public static final int MOD=49;
    public static final int LEFT_BRACKET=4;
    public static final int OCTAL_ESC=73;
    public static final int BOOLEANLITERAL=8;
    public static final int MAX=40;
    public static final int COUNT=42;
    public static final int EQUALS=52;
    public static final int NOT=67;
    public static final int AND=51;
    public static final int SUM=38;
    public static final int EOF=-1;
    public static final int GROUPAS=46;
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
    public static final int GE=56;
    public static final int UNIQUE=68;
    public static final int MINUS_F=63;
    public static final int GET_POTENTIAL_OWNERS_F=30;
    public static final int GET_TASK_STAKEHOLDERS_F=35;
    public static final int GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F=24;
    public static final int UNICODE_ESC=72;
    public static final int GET_BUSINESS_ADMINISTRATORS_F=20;
    public static final int DOUBLELITERAL=7;
    public static final int NOTEQUALS=53;
    public static final int EXCEPT_F=65;
    public static final int HEX_DIGIT=71;
    public static final int STRUCT=43;
    public static final int WAIT_UNTIL_F=37;
    public static final int MIN=39;
    public static final int MINUS=12;
    public static final int MULT=47;
    public static final int COMA=60;
    public static final int GET_OUTPUT_F=29;
    public static final int GET_INPUT_F=26;
    public static final int MOST_FREQUENT_OCCURENCE_F=18;
    public static final int ANY=62;
    public static final int WS=77;
    public static final int BAG=44;
    public static final int STRINGLITERAL=9;
    public static final int OR=50;
    public static final int GET_TASK_PRIORITY_F=34;
    public static final int GET_COUNT_OF_SUBTASKS_F=22;
    public static final int GT=54;
    public static final int DIV=48;
    public static final int INTERSECT_F=66;
    public static final int GET_TASK_INITIATOR_F=33;
    public static final int LE=57;
    public static final int GET_COUNT_OF_FINISHED_SUBTASKS_F=21;

    // delegates
    // delegators

    public SBQLLexer() {;} 
    public SBQLLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SBQLLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g"; }

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:343:7: ( 'where' | 'WHERE' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='w') ) {
                alt1=1;
            }
            else if ( (LA1_0=='W') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:343:9: 'where'
                    {
                    match("where"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:343:19: 'WHERE'
                    {
                    match("WHERE"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "ALL"
    public final void mALL() throws RecognitionException {
        try {
            int _type = ALL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:344:5: ( 'all' | 'ALL' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='a') ) {
                alt2=1;
            }
            else if ( (LA2_0=='A') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:344:7: 'all'
                    {
                    match("all"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:344:15: 'ALL'
                    {
                    match("ALL"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALL"

    // $ANTLR start "ANY"
    public final void mANY() throws RecognitionException {
        try {
            int _type = ANY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:345:5: ( 'any' | 'ANY' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='a') ) {
                alt3=1;
            }
            else if ( (LA3_0=='A') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:345:7: 'any'
                    {
                    match("any"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:345:15: 'ANY'
                    {
                    match("ANY"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANY"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:346:5: ( '!' | 'not' | 'NOT' )
            int alt4=3;
            switch ( input.LA(1) ) {
            case '!':
                {
                alt4=1;
                }
                break;
            case 'n':
                {
                alt4=2;
                }
                break;
            case 'N':
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:346:7: '!'
                    {
                    match('!'); 

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:346:13: 'not'
                    {
                    match("not"); 


                    }
                    break;
                case 3 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:346:21: 'NOT'
                    {
                    match("NOT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "COMA"
    public final void mCOMA() throws RecognitionException {
        try {
            int _type = COMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:347:6: ( ',' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:347:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMA"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:349:4: ( '||' | 'or' | 'OR' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case '|':
                {
                alt5=1;
                }
                break;
            case 'o':
                {
                alt5=2;
                }
                break;
            case 'O':
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:349:6: '||'
                    {
                    match("||"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:349:13: 'or'
                    {
                    match("or"); 


                    }
                    break;
                case 3 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:349:20: 'OR'
                    {
                    match("OR"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:350:5: ( '&&' | 'and' | 'AND' )
            int alt6=3;
            switch ( input.LA(1) ) {
            case '&':
                {
                alt6=1;
                }
                break;
            case 'a':
                {
                alt6=2;
                }
                break;
            case 'A':
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:350:7: '&&'
                    {
                    match("&&"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:350:14: 'and'
                    {
                    match("and"); 


                    }
                    break;
                case 3 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:350:22: 'AND'
                    {
                    match("AND"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "EQUALS"
    public final void mEQUALS() throws RecognitionException {
        try {
            int _type = EQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:353:8: ( '=' | '==' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='=') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='=') ) {
                    alt7=2;
                }
                else {
                    alt7=1;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:353:10: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:353:16: '=='
                    {
                    match("=="); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQUALS"

    // $ANTLR start "NOTEQUALS"
    public final void mNOTEQUALS() throws RecognitionException {
        try {
            int _type = NOTEQUALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:354:11: ( '!=' | '<>' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='!') ) {
                alt8=1;
            }
            else if ( (LA8_0=='<') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:354:13: '!='
                    {
                    match("!="); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:354:20: '<>'
                    {
                    match("<>"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOTEQUALS"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:355:4: ( '>' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:355:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:356:4: ( '<' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:356:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:357:4: ( '>=' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:357:6: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:358:4: ( '<=' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:358:6: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:359:5: ( '+' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:359:7: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:360:6: ( '-' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:360:8: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MULT"
    public final void mMULT() throws RecognitionException {
        try {
            int _type = MULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:361:7: ( '*' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:361:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULT"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:362:5: ( '/' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:362:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:363:5: ( '%' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:363:7: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:364:4: ( 'as' | 'AS' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='a') ) {
                alt9=1;
            }
            else if ( (LA9_0=='A') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:364:6: 'as'
                    {
                    match("as"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:364:13: 'AS'
                    {
                    match("AS"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "GROUPAS"
    public final void mGROUPAS() throws RecognitionException {
        try {
            int _type = GROUPAS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:365:9: ( 'groupas' | 'GROUPAS' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='g') ) {
                alt10=1;
            }
            else if ( (LA10_0=='G') ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:365:11: 'groupas'
                    {
                    match("groupas"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:365:23: 'GROUPAS'
                    {
                    match("GROUPAS"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUPAS"

    // $ANTLR start "LEFT_BRACKET"
    public final void mLEFT_BRACKET() throws RecognitionException {
        try {
            int _type = LEFT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:367:14: ( '(' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:367:16: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEFT_BRACKET"

    // $ANTLR start "RIGHT_BRACKET"
    public final void mRIGHT_BRACKET() throws RecognitionException {
        try {
            int _type = RIGHT_BRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:368:15: ( ')' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:368:17: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RIGHT_BRACKET"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:369:4: ( ( '.' | DIV ) )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:369:6: ( '.' | DIV )
            {
            if ( (input.LA(1)>='.' && input.LA(1)<='/') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "BAG"
    public final void mBAG() throws RecognitionException {
        try {
            int _type = BAG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:370:5: ( 'bag' | 'BAG' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='b') ) {
                alt11=1;
            }
            else if ( (LA11_0=='B') ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:370:7: 'bag'
                    {
                    match("bag"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:370:15: 'BAG'
                    {
                    match("BAG"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BAG"

    // $ANTLR start "STRUCT"
    public final void mSTRUCT() throws RecognitionException {
        try {
            int _type = STRUCT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:371:8: ( 'struct' | 'STRUCT' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='s') ) {
                alt12=1;
            }
            else if ( (LA12_0=='S') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:371:10: 'struct'
                    {
                    match("struct"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:371:21: 'STRUCT'
                    {
                    match("STRUCT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRUCT"

    // $ANTLR start "COUNT"
    public final void mCOUNT() throws RecognitionException {
        try {
            int _type = COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:373:7: ( 'count' | 'COUNT' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='c') ) {
                alt13=1;
            }
            else if ( (LA13_0=='C') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:373:9: 'count'
                    {
                    match("count"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:373:19: 'COUNT'
                    {
                    match("COUNT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COUNT"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:375:5: ( 'sum' | 'SUM' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='s') ) {
                alt14=1;
            }
            else if ( (LA14_0=='S') ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:375:7: 'sum'
                    {
                    match("sum"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:375:15: 'SUM'
                    {
                    match("SUM"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "AVG"
    public final void mAVG() throws RecognitionException {
        try {
            int _type = AVG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:376:5: ( 'avg' | 'AVG' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='a') ) {
                alt15=1;
            }
            else if ( (LA15_0=='A') ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:376:7: 'avg'
                    {
                    match("avg"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:376:15: 'AVG'
                    {
                    match("AVG"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AVG"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:377:5: ( 'min' | 'MIN' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='m') ) {
                alt16=1;
            }
            else if ( (LA16_0=='M') ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:377:7: 'min'
                    {
                    match("min"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:377:15: 'MIN'
                    {
                    match("MIN"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIN"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:378:5: ( 'max' | 'MAX' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='m') ) {
                alt17=1;
            }
            else if ( (LA17_0=='M') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:378:7: 'max'
                    {
                    match("max"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:378:15: 'MAX'
                    {
                    match("MAX"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAX"

    // $ANTLR start "UNIQUE"
    public final void mUNIQUE() throws RecognitionException {
        try {
            int _type = UNIQUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:380:8: ( 'unique' | 'UNIQUE' )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='u') ) {
                alt18=1;
            }
            else if ( (LA18_0=='U') ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:380:10: 'unique'
                    {
                    match("unique"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:380:21: 'UNIQUE'
                    {
                    match("UNIQUE"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNIQUE"

    // $ANTLR start "EXISTS"
    public final void mEXISTS() throws RecognitionException {
        try {
            int _type = EXISTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:381:8: ( 'exists' | 'EXISTS' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='e') ) {
                alt19=1;
            }
            else if ( (LA19_0=='E') ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:381:10: 'exists'
                    {
                    match("exists"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:381:21: 'EXISTS'
                    {
                    match("EXISTS"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXISTS"

    // $ANTLR start "MINUS_F"
    public final void mMINUS_F() throws RecognitionException {
        try {
            int _type = MINUS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:382:9: ( 'minus' | 'MINUS' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='m') ) {
                alt20=1;
            }
            else if ( (LA20_0=='M') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:382:11: 'minus'
                    {
                    match("minus"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:382:21: 'MINUS'
                    {
                    match("MINUS"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS_F"

    // $ANTLR start "UNION_F"
    public final void mUNION_F() throws RecognitionException {
        try {
            int _type = UNION_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:384:9: ( 'union' | 'UNION' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0=='u') ) {
                alt21=1;
            }
            else if ( (LA21_0=='U') ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:384:11: 'union'
                    {
                    match("union"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:384:21: 'UNION'
                    {
                    match("UNION"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNION_F"

    // $ANTLR start "INTERSECT_F"
    public final void mINTERSECT_F() throws RecognitionException {
        try {
            int _type = INTERSECT_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:385:13: ( 'intersect' | 'INTERSECT' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0=='i') ) {
                alt22=1;
            }
            else if ( (LA22_0=='I') ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:385:15: 'intersect'
                    {
                    match("intersect"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:385:29: 'INTERSECT'
                    {
                    match("INTERSECT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTERSECT_F"

    // $ANTLR start "EXCEPT_F"
    public final void mEXCEPT_F() throws RecognitionException {
        try {
            int _type = EXCEPT_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:387:10: ( 'except' | 'EXCEPT' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0=='e') ) {
                alt23=1;
            }
            else if ( (LA23_0=='E') ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:387:12: 'except'
                    {
                    match("except"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:387:23: 'EXCEPT'
                    {
                    match("EXCEPT"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCEPT_F"

    // $ANTLR start "VOTE_F"
    public final void mVOTE_F() throws RecognitionException {
        try {
            int _type = VOTE_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:389:7: ( 'vote' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:389:9: 'vote'
            {
            match("vote"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VOTE_F"

    // $ANTLR start "CONCAT_F"
    public final void mCONCAT_F() throws RecognitionException {
        try {
            int _type = CONCAT_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:391:10: ( 'concat' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:391:12: 'concat'
            {
            match("concat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONCAT_F"

    // $ANTLR start "CONCAT_WITH_DELIMITER_F"
    public final void mCONCAT_WITH_DELIMITER_F() throws RecognitionException {
        try {
            int _type = CONCAT_WITH_DELIMITER_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:392:25: ( 'concatWithDelimiter' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:392:27: 'concatWithDelimiter'
            {
            match("concatWithDelimiter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONCAT_WITH_DELIMITER_F"

    // $ANTLR start "LEAST_FREQUENT_OCCURENCE_F"
    public final void mLEAST_FREQUENT_OCCURENCE_F() throws RecognitionException {
        try {
            int _type = LEAST_FREQUENT_OCCURENCE_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:393:28: ( 'leastFrequentOccurence' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:393:30: 'leastFrequentOccurence'
            {
            match("leastFrequentOccurence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LEAST_FREQUENT_OCCURENCE_F"

    // $ANTLR start "MOST_FREQUENT_OCCURENCE_F"
    public final void mMOST_FREQUENT_OCCURENCE_F() throws RecognitionException {
        try {
            int _type = MOST_FREQUENT_OCCURENCE_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:394:27: ( 'mostFrequentOccurence' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:394:29: 'mostFrequentOccurence'
            {
            match("mostFrequentOccurence"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOST_FREQUENT_OCCURENCE_F"

    // $ANTLR start "VOTE_ON_STRING_F"
    public final void mVOTE_ON_STRING_F() throws RecognitionException {
        try {
            int _type = VOTE_ON_STRING_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:395:18: ( 'voteOnString' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:395:20: 'voteOnString'
            {
            match("voteOnString"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VOTE_ON_STRING_F"

    // $ANTLR start "GET_ACTUAL_OWNER_F"
    public final void mGET_ACTUAL_OWNER_F() throws RecognitionException {
        try {
            int _type = GET_ACTUAL_OWNER_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:397:20: ( 'getActualOwner' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:397:22: 'getActualOwner'
            {
            match("getActualOwner"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_ACTUAL_OWNER_F"

    // $ANTLR start "GET_BUSINESS_ADMINISTRATORS_F"
    public final void mGET_BUSINESS_ADMINISTRATORS_F() throws RecognitionException {
        try {
            int _type = GET_BUSINESS_ADMINISTRATORS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:398:31: ( 'getBusinessAdministrators' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:398:33: 'getBusinessAdministrators'
            {
            match("getBusinessAdministrators"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_BUSINESS_ADMINISTRATORS_F"

    // $ANTLR start "GET_COUNT_OF_FINISHED_SUBTASKS_F"
    public final void mGET_COUNT_OF_FINISHED_SUBTASKS_F() throws RecognitionException {
        try {
            int _type = GET_COUNT_OF_FINISHED_SUBTASKS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:399:34: ( 'getCountOfFinishedSubTasks' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:399:36: 'getCountOfFinishedSubTasks'
            {
            match("getCountOfFinishedSubTasks"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_COUNT_OF_FINISHED_SUBTASKS_F"

    // $ANTLR start "GET_COUNT_OF_SUBTASKS_F"
    public final void mGET_COUNT_OF_SUBTASKS_F() throws RecognitionException {
        try {
            int _type = GET_COUNT_OF_SUBTASKS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:400:25: ( 'getCountOfSubTasks' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:400:27: 'getCountOfSubTasks'
            {
            match("getCountOfSubTasks"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_COUNT_OF_SUBTASKS_F"

    // $ANTLR start "GET_COUNT_OF_SUBTASKS_IN_STATE_F"
    public final void mGET_COUNT_OF_SUBTASKS_IN_STATE_F() throws RecognitionException {
        try {
            int _type = GET_COUNT_OF_SUBTASKS_IN_STATE_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:401:34: ( 'getCountOfSubTasksInState' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:401:36: 'getCountOfSubTasksInState'
            {
            match("getCountOfSubTasksInState"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_COUNT_OF_SUBTASKS_IN_STATE_F"

    // $ANTLR start "GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F"
    public final void mGET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F() throws RecognitionException {
        try {
            int _type = GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:402:38: ( 'getCountOfSubTasksWithOutcome' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:402:40: 'getCountOfSubTasksWithOutcome'
            {
            match("getCountOfSubTasksWithOutcome"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F"

    // $ANTLR start "GET_EXCLUDED_OWNERS_F"
    public final void mGET_EXCLUDED_OWNERS_F() throws RecognitionException {
        try {
            int _type = GET_EXCLUDED_OWNERS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:403:23: ( 'getExcludedOwners' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:403:25: 'getExcludedOwners'
            {
            match("getExcludedOwners"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_EXCLUDED_OWNERS_F"

    // $ANTLR start "GET_INPUT_F"
    public final void mGET_INPUT_F() throws RecognitionException {
        try {
            int _type = GET_INPUT_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:404:13: ( 'getInput' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:404:15: 'getInput'
            {
            match("getInput"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_INPUT_F"

    // $ANTLR start "GET_LOGICAL_PEOPLE_GROUP_F"
    public final void mGET_LOGICAL_PEOPLE_GROUP_F() throws RecognitionException {
        try {
            int _type = GET_LOGICAL_PEOPLE_GROUP_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:405:28: ( 'getLogicalPeopleGroup' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:405:30: 'getLogicalPeopleGroup'
            {
            match("getLogicalPeopleGroup"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_LOGICAL_PEOPLE_GROUP_F"

    // $ANTLR start "GET_OUTCOME_F"
    public final void mGET_OUTCOME_F() throws RecognitionException {
        try {
            int _type = GET_OUTCOME_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:406:15: ( 'getOutcome' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:406:17: 'getOutcome'
            {
            match("getOutcome"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_OUTCOME_F"

    // $ANTLR start "GET_OUTPUT_F"
    public final void mGET_OUTPUT_F() throws RecognitionException {
        try {
            int _type = GET_OUTPUT_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:407:14: ( 'getOutput' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:407:16: 'getOutput'
            {
            match("getOutput"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_OUTPUT_F"

    // $ANTLR start "GET_POTENTIAL_OWNERS_F"
    public final void mGET_POTENTIAL_OWNERS_F() throws RecognitionException {
        try {
            int _type = GET_POTENTIAL_OWNERS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:408:24: ( 'getPotentialOwners' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:408:26: 'getPotentialOwners'
            {
            match("getPotentialOwners"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_POTENTIAL_OWNERS_F"

    // $ANTLR start "GET_SUBTASK_OUTPUT_F"
    public final void mGET_SUBTASK_OUTPUT_F() throws RecognitionException {
        try {
            int _type = GET_SUBTASK_OUTPUT_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:409:22: ( 'getSubtaskOutput' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:409:24: 'getSubtaskOutput'
            {
            match("getSubtaskOutput"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_SUBTASK_OUTPUT_F"

    // $ANTLR start "GET_SUBTASK_OUTPUTS_F"
    public final void mGET_SUBTASK_OUTPUTS_F() throws RecognitionException {
        try {
            int _type = GET_SUBTASK_OUTPUTS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:410:23: ( 'getSubtaskOutputs' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:410:25: 'getSubtaskOutputs'
            {
            match("getSubtaskOutputs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_SUBTASK_OUTPUTS_F"

    // $ANTLR start "GET_TASK_INITIATOR_F"
    public final void mGET_TASK_INITIATOR_F() throws RecognitionException {
        try {
            int _type = GET_TASK_INITIATOR_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:411:22: ( 'getTaskInitiator' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:411:24: 'getTaskInitiator'
            {
            match("getTaskInitiator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_TASK_INITIATOR_F"

    // $ANTLR start "GET_TASK_PRIORITY_F"
    public final void mGET_TASK_PRIORITY_F() throws RecognitionException {
        try {
            int _type = GET_TASK_PRIORITY_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:412:21: ( 'getTaskPriority' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:412:23: 'getTaskPriority'
            {
            match("getTaskPriority"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_TASK_PRIORITY_F"

    // $ANTLR start "GET_TASK_STAKEHOLDERS_F"
    public final void mGET_TASK_STAKEHOLDERS_F() throws RecognitionException {
        try {
            int _type = GET_TASK_STAKEHOLDERS_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:413:25: ( 'getTaskStakeholders' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:413:27: 'getTaskStakeholders'
            {
            match("getTaskStakeholders"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GET_TASK_STAKEHOLDERS_F"

    // $ANTLR start "WAIT_FOR_F"
    public final void mWAIT_FOR_F() throws RecognitionException {
        try {
            int _type = WAIT_FOR_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:415:12: ( 'waitFor' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:415:14: 'waitFor'
            {
            match("waitFor"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WAIT_FOR_F"

    // $ANTLR start "WAIT_UNTIL_F"
    public final void mWAIT_UNTIL_F() throws RecognitionException {
        try {
            int _type = WAIT_UNTIL_F;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:416:14: ( 'waitUntil' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:416:16: 'waitUntil'
            {
            match("waitUntil"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WAIT_UNTIL_F"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:421:7: ( '0' .. '9' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:421:9: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:424:11: ( ( DIGIT | 'a' .. 'f' | 'A' .. 'F' ) )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:424:13: ( DIGIT | 'a' .. 'f' | 'A' .. 'F' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:429:7: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
            int alt24=3;
            int LA24_0 = input.LA(1);

            if ( (LA24_0=='\\') ) {
                switch ( input.LA(2) ) {
                case '\"':
                case '\'':
                case '\\':
                case 'b':
                case 'f':
                case 'n':
                case 'r':
                case 't':
                    {
                    alt24=1;
                    }
                    break;
                case 'u':
                    {
                    alt24=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                    {
                    alt24=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:429:11: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
                    {
                    match('\\'); 
                    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:430:11: UNICODE_ESC
                    {
                    mUNICODE_ESC(); 

                    }
                    break;
                case 3 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:431:11: OCTAL_ESC
                    {
                    mOCTAL_ESC(); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "OCTAL_ESC"
    public final void mOCTAL_ESC() throws RecognitionException {
        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:7: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0=='\\') ) {
                int LA25_1 = input.LA(2);

                if ( ((LA25_1>='0' && LA25_1<='3')) ) {
                    int LA25_2 = input.LA(3);

                    if ( ((LA25_2>='0' && LA25_2<='7')) ) {
                        int LA25_5 = input.LA(4);

                        if ( ((LA25_5>='0' && LA25_5<='7')) ) {
                            alt25=1;
                        }
                        else {
                            alt25=2;}
                    }
                    else {
                        alt25=3;}
                }
                else if ( ((LA25_1>='4' && LA25_1<='7')) ) {
                    int LA25_3 = input.LA(3);

                    if ( ((LA25_3>='0' && LA25_3<='7')) ) {
                        alt25=2;
                    }
                    else {
                        alt25=3;}
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:11: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:16: ( '0' .. '3' )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:17: '0' .. '3'
                    {
                    matchRange('0','3'); 

                    }

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:27: ( '0' .. '7' )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:28: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:38: ( '0' .. '7' )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:436:39: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:437:11: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
                    {
                    match('\\'); 
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:437:16: ( '0' .. '7' )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:437:17: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }

                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:437:27: ( '0' .. '7' )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:437:28: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:438:11: '\\\\' ( '0' .. '7' )
                    {
                    match('\\'); 
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:438:16: ( '0' .. '7' )
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:438:17: '0' .. '7'
                    {
                    matchRange('0','7'); 

                    }


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end "OCTAL_ESC"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:443:7: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:443:11: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
            {
            match('\\'); 
            match('u'); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 
            mHEX_DIGIT(); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "EXPONENT"
    public final void mEXPONENT() throws RecognitionException {
        try {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:449:7: ( ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+ )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:449:11: ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:449:25: ( '+' | '-' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='+'||LA26_0=='-') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:449:40: ( DIGIT )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>='0' && LA27_0<='9')) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:449:42: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "EXPONENT"

    // $ANTLR start "DELIMLITERAL"
    public final void mDELIMLITERAL() throws RecognitionException {
        try {
            int _type = DELIMLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:453:7: ( '\\\"' ( ',' | ';' | ':' | '.' ) '\\\"' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:453:9: '\\\"' ( ',' | ';' | ':' | '.' ) '\\\"'
            {
            match('\"'); 
            if ( input.LA(1)==','||input.LA(1)=='.'||(input.LA(1)>=':' && input.LA(1)<=';') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DELIMLITERAL"

    // $ANTLR start "INTEGERLITERAL"
    public final void mINTEGERLITERAL() throws RecognitionException {
        try {
            int _type = INTEGERLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:457:7: ( ( DIGIT )+ )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:457:9: ( DIGIT )+
            {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:457:9: ( DIGIT )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>='0' && LA28_0<='9')) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:457:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGERLITERAL"

    // $ANTLR start "DOUBLELITERAL"
    public final void mDOUBLELITERAL() throws RecognitionException {
        try {
            int _type = DOUBLELITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:7: ( ( DIGIT )+ DOT ( DIGIT )+ ( EXPONENT )? )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:9: ( DIGIT )+ DOT ( DIGIT )+ ( EXPONENT )?
            {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:9: ( DIGIT )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>='0' && LA29_0<='9')) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:9: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            mDOT(); 
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:20: ( DIGIT )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>='0' && LA30_0<='9')) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:20: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:27: ( EXPONENT )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0=='E'||LA31_0=='e') ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:461:27: EXPONENT
                    {
                    mEXPONENT(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOUBLELITERAL"

    // $ANTLR start "BOOLEANLITERAL"
    public final void mBOOLEANLITERAL() throws RecognitionException {
        try {
            int _type = BOOLEANLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:465:7: ( 'true' | 'false' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0=='t') ) {
                alt32=1;
            }
            else if ( (LA32_0=='f') ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:465:8: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:466:8: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BOOLEANLITERAL"

    // $ANTLR start "IDENTLITERAL"
    public final void mIDENTLITERAL() throws RecognitionException {
        try {
            int _type = IDENTLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:470:7: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | DIGIT )* )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:470:10: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | DIGIT )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:470:32: ( 'a' .. 'z' | 'A' .. 'Z' | DIGIT )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>='0' && LA33_0<='9')||(LA33_0>='A' && LA33_0<='Z')||(LA33_0>='a' && LA33_0<='z')) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTLITERAL"

    // $ANTLR start "STRINGLITERAL"
    public final void mSTRINGLITERAL() throws RecognitionException {
        try {
            int _type = STRINGLITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:475:7: ( '\\\"' (~ '\\\"' )* '\\\"' )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:475:9: '\\\"' (~ '\\\"' )* '\\\"'
            {
            match('\"'); 
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:475:14: (~ '\\\"' )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>='\u0000' && LA34_0<='!')||(LA34_0>='#' && LA34_0<='\uFFFF')) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:475:15: ~ '\\\"'
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRINGLITERAL"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:479:7: ( ( ' ' | '\\t' | '\\r' | '\\f' )+ )
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:479:9: ( ' ' | '\\t' | '\\r' | '\\f' )+
            {
            // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:479:9: ( ' ' | '\\t' | '\\r' | '\\f' )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0=='\t'||(LA35_0>='\f' && LA35_0<='\r')||LA35_0==' ') ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:
            	    {
            	    if ( input.LA(1)=='\t'||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:8: ( WHERE | ALL | ANY | NOT | COMA | OR | AND | EQUALS | NOTEQUALS | GT | LT | GE | LE | PLUS | MINUS | MULT | DIV | MOD | AS | GROUPAS | LEFT_BRACKET | RIGHT_BRACKET | DOT | BAG | STRUCT | COUNT | SUM | AVG | MIN | MAX | UNIQUE | EXISTS | MINUS_F | UNION_F | INTERSECT_F | EXCEPT_F | VOTE_F | CONCAT_F | CONCAT_WITH_DELIMITER_F | LEAST_FREQUENT_OCCURENCE_F | MOST_FREQUENT_OCCURENCE_F | VOTE_ON_STRING_F | GET_ACTUAL_OWNER_F | GET_BUSINESS_ADMINISTRATORS_F | GET_COUNT_OF_FINISHED_SUBTASKS_F | GET_COUNT_OF_SUBTASKS_F | GET_COUNT_OF_SUBTASKS_IN_STATE_F | GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F | GET_EXCLUDED_OWNERS_F | GET_INPUT_F | GET_LOGICAL_PEOPLE_GROUP_F | GET_OUTCOME_F | GET_OUTPUT_F | GET_POTENTIAL_OWNERS_F | GET_SUBTASK_OUTPUT_F | GET_SUBTASK_OUTPUTS_F | GET_TASK_INITIATOR_F | GET_TASK_PRIORITY_F | GET_TASK_STAKEHOLDERS_F | WAIT_FOR_F | WAIT_UNTIL_F | DELIMLITERAL | INTEGERLITERAL | DOUBLELITERAL | BOOLEANLITERAL | IDENTLITERAL | STRINGLITERAL | WS )
        int alt36=68;
        alt36 = dfa36.predict(input);
        switch (alt36) {
            case 1 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:10: WHERE
                {
                mWHERE(); 

                }
                break;
            case 2 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:16: ALL
                {
                mALL(); 

                }
                break;
            case 3 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:20: ANY
                {
                mANY(); 

                }
                break;
            case 4 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:24: NOT
                {
                mNOT(); 

                }
                break;
            case 5 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:28: COMA
                {
                mCOMA(); 

                }
                break;
            case 6 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:33: OR
                {
                mOR(); 

                }
                break;
            case 7 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:36: AND
                {
                mAND(); 

                }
                break;
            case 8 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:40: EQUALS
                {
                mEQUALS(); 

                }
                break;
            case 9 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:47: NOTEQUALS
                {
                mNOTEQUALS(); 

                }
                break;
            case 10 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:57: GT
                {
                mGT(); 

                }
                break;
            case 11 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:60: LT
                {
                mLT(); 

                }
                break;
            case 12 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:63: GE
                {
                mGE(); 

                }
                break;
            case 13 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:66: LE
                {
                mLE(); 

                }
                break;
            case 14 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:69: PLUS
                {
                mPLUS(); 

                }
                break;
            case 15 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:74: MINUS
                {
                mMINUS(); 

                }
                break;
            case 16 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:80: MULT
                {
                mMULT(); 

                }
                break;
            case 17 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:85: DIV
                {
                mDIV(); 

                }
                break;
            case 18 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:89: MOD
                {
                mMOD(); 

                }
                break;
            case 19 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:93: AS
                {
                mAS(); 

                }
                break;
            case 20 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:96: GROUPAS
                {
                mGROUPAS(); 

                }
                break;
            case 21 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:104: LEFT_BRACKET
                {
                mLEFT_BRACKET(); 

                }
                break;
            case 22 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:117: RIGHT_BRACKET
                {
                mRIGHT_BRACKET(); 

                }
                break;
            case 23 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:131: DOT
                {
                mDOT(); 

                }
                break;
            case 24 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:135: BAG
                {
                mBAG(); 

                }
                break;
            case 25 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:139: STRUCT
                {
                mSTRUCT(); 

                }
                break;
            case 26 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:146: COUNT
                {
                mCOUNT(); 

                }
                break;
            case 27 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:152: SUM
                {
                mSUM(); 

                }
                break;
            case 28 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:156: AVG
                {
                mAVG(); 

                }
                break;
            case 29 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:160: MIN
                {
                mMIN(); 

                }
                break;
            case 30 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:164: MAX
                {
                mMAX(); 

                }
                break;
            case 31 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:168: UNIQUE
                {
                mUNIQUE(); 

                }
                break;
            case 32 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:175: EXISTS
                {
                mEXISTS(); 

                }
                break;
            case 33 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:182: MINUS_F
                {
                mMINUS_F(); 

                }
                break;
            case 34 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:190: UNION_F
                {
                mUNION_F(); 

                }
                break;
            case 35 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:198: INTERSECT_F
                {
                mINTERSECT_F(); 

                }
                break;
            case 36 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:210: EXCEPT_F
                {
                mEXCEPT_F(); 

                }
                break;
            case 37 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:219: VOTE_F
                {
                mVOTE_F(); 

                }
                break;
            case 38 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:226: CONCAT_F
                {
                mCONCAT_F(); 

                }
                break;
            case 39 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:235: CONCAT_WITH_DELIMITER_F
                {
                mCONCAT_WITH_DELIMITER_F(); 

                }
                break;
            case 40 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:259: LEAST_FREQUENT_OCCURENCE_F
                {
                mLEAST_FREQUENT_OCCURENCE_F(); 

                }
                break;
            case 41 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:286: MOST_FREQUENT_OCCURENCE_F
                {
                mMOST_FREQUENT_OCCURENCE_F(); 

                }
                break;
            case 42 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:312: VOTE_ON_STRING_F
                {
                mVOTE_ON_STRING_F(); 

                }
                break;
            case 43 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:329: GET_ACTUAL_OWNER_F
                {
                mGET_ACTUAL_OWNER_F(); 

                }
                break;
            case 44 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:348: GET_BUSINESS_ADMINISTRATORS_F
                {
                mGET_BUSINESS_ADMINISTRATORS_F(); 

                }
                break;
            case 45 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:378: GET_COUNT_OF_FINISHED_SUBTASKS_F
                {
                mGET_COUNT_OF_FINISHED_SUBTASKS_F(); 

                }
                break;
            case 46 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:411: GET_COUNT_OF_SUBTASKS_F
                {
                mGET_COUNT_OF_SUBTASKS_F(); 

                }
                break;
            case 47 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:435: GET_COUNT_OF_SUBTASKS_IN_STATE_F
                {
                mGET_COUNT_OF_SUBTASKS_IN_STATE_F(); 

                }
                break;
            case 48 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:468: GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F
                {
                mGET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F(); 

                }
                break;
            case 49 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:505: GET_EXCLUDED_OWNERS_F
                {
                mGET_EXCLUDED_OWNERS_F(); 

                }
                break;
            case 50 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:527: GET_INPUT_F
                {
                mGET_INPUT_F(); 

                }
                break;
            case 51 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:539: GET_LOGICAL_PEOPLE_GROUP_F
                {
                mGET_LOGICAL_PEOPLE_GROUP_F(); 

                }
                break;
            case 52 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:566: GET_OUTCOME_F
                {
                mGET_OUTCOME_F(); 

                }
                break;
            case 53 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:580: GET_OUTPUT_F
                {
                mGET_OUTPUT_F(); 

                }
                break;
            case 54 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:593: GET_POTENTIAL_OWNERS_F
                {
                mGET_POTENTIAL_OWNERS_F(); 

                }
                break;
            case 55 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:616: GET_SUBTASK_OUTPUT_F
                {
                mGET_SUBTASK_OUTPUT_F(); 

                }
                break;
            case 56 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:637: GET_SUBTASK_OUTPUTS_F
                {
                mGET_SUBTASK_OUTPUTS_F(); 

                }
                break;
            case 57 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:659: GET_TASK_INITIATOR_F
                {
                mGET_TASK_INITIATOR_F(); 

                }
                break;
            case 58 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:680: GET_TASK_PRIORITY_F
                {
                mGET_TASK_PRIORITY_F(); 

                }
                break;
            case 59 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:700: GET_TASK_STAKEHOLDERS_F
                {
                mGET_TASK_STAKEHOLDERS_F(); 

                }
                break;
            case 60 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:724: WAIT_FOR_F
                {
                mWAIT_FOR_F(); 

                }
                break;
            case 61 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:735: WAIT_UNTIL_F
                {
                mWAIT_UNTIL_F(); 

                }
                break;
            case 62 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:748: DELIMLITERAL
                {
                mDELIMLITERAL(); 

                }
                break;
            case 63 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:761: INTEGERLITERAL
                {
                mINTEGERLITERAL(); 

                }
                break;
            case 64 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:776: DOUBLELITERAL
                {
                mDOUBLELITERAL(); 

                }
                break;
            case 65 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:790: BOOLEANLITERAL
                {
                mBOOLEANLITERAL(); 

                }
                break;
            case 66 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:805: IDENTLITERAL
                {
                mIDENTLITERAL(); 

                }
                break;
            case 67 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:818: STRINGLITERAL
                {
                mSTRINGLITERAL(); 

                }
                break;
            case 68 :
                // C:\\WORK\\workspace\\WS-HT\\SBQL\\SBQL.g:1:832: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA36 dfa36 = new DFA36(this);
    static final String DFA36_eotS =
        "\1\uffff\4\56\1\74\2\56\2\uffff\2\56\2\uffff\1\102\1\104\5\uffff"+
        "\2\56\3\uffff\20\56\1\uffff\1\140\2\56\2\uffff\5\56\1\152\3\56\1"+
        "\152\1\56\2\uffff\2\56\2\11\5\uffff\30\56\4\uffff\5\56\1\u0093\1"+
        "\u0094\1\14\1\uffff\1\u0095\1\u0093\1\u0094\1\14\1\u0095\2\74\3"+
        "\56\2\u00a2\1\56\1\u00a4\1\56\1\u00a4\3\56\1\u00aa\1\u00ab\1\56"+
        "\1\u00aa\1\u00ab\12\56\1\uffff\5\56\3\uffff\14\56\1\uffff\1\56\1"+
        "\uffff\5\56\2\uffff\14\56\1\u00e0\1\56\1\uffff\1\u00e2\1\56\1\u00e4"+
        "\2\56\1\u00e4\16\56\1\u00f5\1\56\1\u00f5\1\u00f7\1\56\1\u00f7\1"+
        "\56\1\u00fa\1\56\1\u00fa\7\56\1\uffff\1\56\1\uffff\1\u00e2\1\uffff"+
        "\16\56\2\u0113\1\uffff\1\u0115\1\uffff\1\56\1\u0117\1\uffff\1\u0117"+
        "\1\u0118\1\u0119\1\u0118\1\u0119\4\56\1\u011e\1\56\1\u0120\13\56"+
        "\1\u0120\1\uffff\1\56\1\uffff\1\56\3\uffff\4\56\1\uffff\1\56\1\uffff"+
        "\4\56\1\u0139\16\56\1\u0148\4\56\1\uffff\2\56\1\u014f\7\56\2\u0157"+
        "\2\56\1\uffff\5\56\1\u0160\1\uffff\7\56\1\uffff\10\56\1\uffff\26"+
        "\56\1\u0186\16\56\1\uffff\1\56\1\u0196\15\56\1\uffff\10\56\1\u01ac"+
        "\12\56\1\u01b8\1\u01b9\1\uffff\7\56\1\u01c1\2\56\1\u01c4\2\uffff"+
        "\6\56\1\u01cd\1\uffff\1\56\1\u01cf\1\uffff\10\56\1\uffff\1\56\1"+
        "\uffff\1\u01d9\1\u01da\7\56\2\uffff\6\56\1\u01e8\1\u01e9\5\56\2"+
        "\uffff\1\u01ef\4\56\1\uffff\4\56\1\u01f8\1\56\1\u01fa\1\56\1\uffff"+
        "\1\u01fc\1\uffff\1\56\1\uffff\2\56\1\u0200\1\uffff";
    static final String DFA36_eofS =
        "\u0201\uffff";
    static final String DFA36_minS =
        "\1\11\1\141\1\110\1\154\1\114\1\75\1\157\1\117\2\uffff\1\162\1"+
        "\122\2\uffff\2\75\5\uffff\1\145\1\122\3\uffff\1\141\1\101\1\164"+
        "\1\124\1\157\1\117\1\141\1\101\1\156\1\116\1\170\1\130\1\156\1\116"+
        "\1\157\1\145\1\0\1\56\1\162\1\141\2\uffff\1\145\1\151\1\105\1\154"+
        "\1\144\1\60\1\147\1\114\1\104\1\60\1\107\2\uffff\1\164\1\124\2\60"+
        "\5\uffff\1\157\1\164\1\117\1\147\1\107\1\162\1\155\1\122\1\115\1"+
        "\156\1\125\1\156\1\170\1\163\1\116\1\130\1\151\1\111\1\143\1\103"+
        "\1\164\1\124\1\164\1\141\1\0\3\uffff\1\165\1\154\1\162\1\164\1\122"+
        "\3\60\1\uffff\7\60\1\165\1\101\1\125\2\60\1\165\1\60\1\125\1\60"+
        "\1\156\1\143\1\116\2\60\1\164\2\60\1\157\1\117\1\163\1\145\1\123"+
        "\1\105\1\145\1\105\1\145\1\163\1\uffff\1\145\1\163\1\145\1\106\1"+
        "\105\3\uffff\1\160\1\143\1\165\1\157\1\170\1\156\1\157\1\165\1\157"+
        "\1\165\1\141\1\120\1\uffff\1\143\1\uffff\1\103\1\164\1\141\1\124"+
        "\1\163\2\uffff\1\106\1\123\1\165\1\156\1\125\1\116\1\164\1\160\1"+
        "\124\1\120\1\162\1\122\1\60\1\164\1\uffff\1\60\1\145\1\60\1\157"+
        "\1\156\1\60\1\141\1\164\1\163\1\165\1\143\1\160\1\147\2\164\1\142"+
        "\1\163\1\101\1\164\1\124\1\60\1\164\2\60\1\162\1\60\1\145\1\60\1"+
        "\105\1\60\1\163\1\164\1\123\1\124\1\163\1\123\1\156\1\uffff\1\106"+
        "\1\uffff\1\60\1\uffff\1\162\1\164\1\163\1\165\1\151\1\156\1\154"+
        "\1\165\1\151\1\143\1\145\1\164\1\153\1\123\2\60\1\uffff\1\60\1\uffff"+
        "\1\145\1\60\1\uffff\5\60\1\145\1\105\1\123\1\162\1\60\1\151\1\60"+
        "\1\141\1\156\1\164\1\165\1\164\1\143\1\157\1\165\1\156\1\141\1\111"+
        "\1\60\1\uffff\1\151\1\uffff\1\161\3\uffff\1\143\1\103\1\164\1\145"+
        "\1\uffff\1\154\1\uffff\1\154\1\145\1\117\1\144\1\60\1\141\1\155"+
        "\2\164\1\163\1\156\1\162\2\164\1\165\1\164\1\124\1\162\1\161\1\60"+
        "\1\117\1\163\1\146\1\145\1\uffff\1\154\1\145\1\60\1\151\1\153\2"+
        "\151\1\141\1\150\1\145\2\60\1\151\1\165\1\uffff\1\167\1\163\1\106"+
        "\1\144\1\120\1\60\1\uffff\1\141\1\117\1\164\1\157\1\153\1\104\1"+
        "\156\1\uffff\1\156\1\145\1\156\1\101\1\151\1\165\1\117\1\145\1\uffff"+
        "\1\154\1\165\1\151\1\162\2\145\1\164\1\147\1\156\1\145\1\144\1\156"+
        "\1\142\1\167\1\157\1\117\1\164\1\141\1\151\1\150\1\154\1\117\1\60"+
        "\1\164\1\162\1\155\1\151\1\124\1\156\1\160\1\167\1\160\2\164\1\157"+
        "\1\151\1\143\1\uffff\1\117\1\60\1\151\1\163\1\141\1\145\1\154\1"+
        "\156\1\165\1\157\1\171\1\154\1\155\2\143\1\uffff\1\156\1\150\1\163"+
        "\1\162\2\145\1\164\1\162\1\60\1\144\1\151\1\165\1\143\1\151\1\145"+
        "\1\153\1\163\1\107\1\162\2\60\1\uffff\1\145\1\164\1\162\1\165\1"+
        "\163\1\144\1\163\1\60\1\162\1\163\1\60\2\uffff\1\162\2\145\1\162"+
        "\1\164\1\123\1\60\1\uffff\1\157\1\60\1\uffff\1\163\1\162\1\156\1"+
        "\145\1\162\1\165\1\156\1\151\1\uffff\1\165\1\uffff\2\60\1\143\1"+
        "\156\1\141\1\142\1\123\1\164\1\160\2\uffff\1\145\1\143\1\164\1\124"+
        "\1\164\1\150\2\60\1\145\1\157\2\141\1\117\2\uffff\1\60\1\162\1\163"+
        "\1\164\1\165\1\uffff\1\163\1\153\1\145\1\164\1\60\1\163\1\60\1\143"+
        "\1\uffff\1\60\1\uffff\1\157\1\uffff\1\155\1\145\1\60\1\uffff";
    static final String DFA36_maxS =
        "\1\174\1\150\1\110\1\166\1\126\1\75\1\157\1\117\2\uffff\1\162\1"+
        "\122\2\uffff\1\76\1\75\5\uffff\1\162\1\122\3\uffff\1\141\1\101\1"+
        "\165\1\125\1\157\1\117\1\157\1\111\1\156\1\116\1\170\1\130\1\156"+
        "\1\116\1\157\1\145\1\uffff\1\71\1\162\1\141\2\uffff\1\145\1\151"+
        "\1\105\1\154\1\171\1\172\1\147\1\114\1\131\1\172\1\107\2\uffff\1"+
        "\164\1\124\2\172\5\uffff\1\157\1\164\1\117\1\147\1\107\1\162\1\155"+
        "\1\122\1\115\1\165\1\125\1\156\1\170\1\163\1\116\1\130\1\151\1\111"+
        "\1\151\1\111\1\164\1\124\1\164\1\141\1\uffff\3\uffff\1\165\1\154"+
        "\1\162\1\164\1\122\3\172\1\uffff\7\172\1\165\1\124\1\125\2\172\1"+
        "\165\1\172\1\125\1\172\1\156\1\143\1\116\2\172\1\164\2\172\1\161"+
        "\1\121\1\163\1\145\1\123\1\105\1\145\1\105\1\145\1\163\1\uffff\1"+
        "\145\1\163\1\145\1\125\1\105\3\uffff\1\160\1\143\1\165\1\157\1\170"+
        "\1\156\1\157\1\165\1\157\1\165\1\141\1\120\1\uffff\1\143\1\uffff"+
        "\1\103\1\164\1\141\1\124\1\163\2\uffff\1\106\1\123\1\165\1\156\1"+
        "\125\1\116\1\164\1\160\1\124\1\120\1\162\1\122\1\172\1\164\1\uffff"+
        "\1\172\1\145\1\172\1\157\1\156\1\172\1\141\1\164\1\163\1\165\1\143"+
        "\1\160\1\147\2\164\1\142\1\163\1\101\1\164\1\124\1\172\1\164\2\172"+
        "\1\162\1\172\1\145\1\172\1\105\1\172\1\163\1\164\1\123\1\124\1\163"+
        "\1\123\1\156\1\uffff\1\106\1\uffff\1\172\1\uffff\1\162\1\164\1\163"+
        "\1\165\1\151\1\156\1\154\1\165\1\151\1\160\1\145\1\164\1\153\1\123"+
        "\2\172\1\uffff\1\172\1\uffff\1\145\1\172\1\uffff\5\172\1\145\1\105"+
        "\1\123\1\162\1\172\1\151\1\172\1\141\1\156\1\164\1\165\1\164\1\143"+
        "\1\157\1\165\1\156\1\141\1\123\1\172\1\uffff\1\151\1\uffff\1\161"+
        "\3\uffff\1\143\1\103\1\164\1\145\1\uffff\1\154\1\uffff\1\154\1\145"+
        "\1\117\1\144\1\172\1\141\1\155\2\164\1\163\1\156\1\162\2\164\1\165"+
        "\1\164\1\124\1\162\1\161\1\172\1\117\1\163\1\146\1\145\1\uffff\1"+
        "\154\1\145\1\172\1\151\1\153\2\151\1\141\1\150\1\145\2\172\1\151"+
        "\1\165\1\uffff\1\167\1\163\1\123\1\144\1\120\1\172\1\uffff\1\141"+
        "\1\117\1\164\1\157\1\153\1\104\1\156\1\uffff\1\156\1\145\1\156\1"+
        "\101\1\151\1\165\1\117\1\145\1\uffff\1\154\1\165\1\151\1\162\2\145"+
        "\1\164\1\147\1\156\1\145\1\144\1\156\1\142\1\167\1\157\1\117\1\164"+
        "\1\141\1\151\1\150\1\154\1\117\1\172\1\164\1\162\1\155\1\151\1\124"+
        "\1\156\1\160\1\167\1\160\2\164\1\157\1\151\1\143\1\uffff\1\117\1"+
        "\172\1\151\1\163\1\141\1\145\1\154\1\156\1\165\1\157\1\171\1\154"+
        "\1\155\2\143\1\uffff\1\156\1\150\1\163\1\162\2\145\1\164\1\162\1"+
        "\172\1\144\1\151\1\165\1\143\1\151\1\145\1\153\1\163\1\107\1\162"+
        "\2\172\1\uffff\1\145\1\164\1\162\1\165\1\163\1\144\1\163\1\172\1"+
        "\162\1\163\1\172\2\uffff\1\162\2\145\1\162\1\164\1\123\1\172\1\uffff"+
        "\1\157\1\172\1\uffff\1\163\1\162\1\156\1\145\1\162\1\165\1\156\1"+
        "\151\1\uffff\1\165\1\uffff\2\172\1\143\1\156\1\141\1\142\1\123\1"+
        "\164\1\160\2\uffff\1\145\1\143\1\164\1\124\1\164\1\150\2\172\1\145"+
        "\1\157\2\141\1\117\2\uffff\1\172\1\162\1\163\1\164\1\165\1\uffff"+
        "\1\163\1\153\1\145\1\164\1\172\1\163\1\172\1\143\1\uffff\1\172\1"+
        "\uffff\1\157\1\uffff\1\155\1\145\1\172\1\uffff";
    static final String DFA36_acceptS =
        "\10\uffff\1\5\1\6\2\uffff\1\7\1\10\2\uffff\1\16\1\17\1\20\1\21"+
        "\1\22\2\uffff\1\25\1\26\1\27\24\uffff\1\102\1\104\13\uffff\1\11"+
        "\1\4\4\uffff\1\15\1\13\1\14\1\12\1\21\31\uffff\1\103\1\77\1\100"+
        "\10\uffff\1\23\42\uffff\1\76\5\uffff\1\2\1\3\1\34\14\uffff\1\30"+
        "\1\uffff\1\33\5\uffff\1\35\1\36\16\uffff\1\76\45\uffff\1\45\1\uffff"+
        "\1\101\1\uffff\1\1\20\uffff\1\32\1\uffff\1\41\2\uffff\1\42\30\uffff"+
        "\1\31\1\uffff\1\46\1\uffff\1\37\1\40\1\44\4\uffff\1\74\1\uffff\1"+
        "\24\30\uffff\1\62\16\uffff\1\75\6\uffff\1\65\7\uffff\1\43\10\uffff"+
        "\1\64\45\uffff\1\52\17\uffff\1\53\25\uffff\1\72\13\uffff\1\67\1"+
        "\71\7\uffff\1\61\2\uffff\1\70\10\uffff\1\56\1\uffff\1\66\11\uffff"+
        "\1\73\1\47\15\uffff\1\63\1\51\5\uffff\1\50\10\uffff\1\54\1\uffff"+
        "\1\57\1\uffff\1\55\3\uffff\1\60";
    static final String DFA36_specialS =
        "\52\uffff\1\0\63\uffff\1\1\u01a2\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\57\2\uffff\2\57\22\uffff\1\57\1\5\1\52\2\uffff\1\24\1\14"+
            "\1\uffff\1\27\1\30\1\22\1\20\1\10\1\21\1\31\1\23\12\53\2\uffff"+
            "\1\16\1\15\1\17\2\uffff\1\4\1\33\1\37\1\56\1\45\1\56\1\26\1"+
            "\56\1\47\3\56\1\41\1\7\1\13\3\56\1\35\1\56\1\43\1\56\1\2\3\56"+
            "\6\uffff\1\3\1\32\1\36\1\56\1\44\1\55\1\25\1\56\1\46\2\56\1"+
            "\51\1\40\1\6\1\12\3\56\1\34\1\54\1\42\1\50\1\1\3\56\1\uffff"+
            "\1\11",
            "\1\61\6\uffff\1\60",
            "\1\62",
            "\1\63\1\uffff\1\64\4\uffff\1\65\2\uffff\1\66",
            "\1\67\1\uffff\1\70\4\uffff\1\71\2\uffff\1\72",
            "\1\73",
            "\1\75",
            "\1\76",
            "",
            "",
            "\1\77",
            "\1\100",
            "",
            "",
            "\1\101\1\73",
            "\1\103",
            "",
            "",
            "",
            "",
            "",
            "\1\107\14\uffff\1\106",
            "\1\110",
            "",
            "",
            "",
            "\1\111",
            "\1\112",
            "\1\113\1\114",
            "\1\115\1\116",
            "\1\117",
            "\1\120",
            "\1\122\7\uffff\1\121\5\uffff\1\123",
            "\1\125\7\uffff\1\124",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\54\137\1\136\1\137\1\136\13\137\2\136\uffc4\137",
            "\2\141\12\53",
            "\1\142",
            "\1\143",
            "",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\151\24\uffff\1\150",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\153",
            "\1\154",
            "\1\156\24\uffff\1\155",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\157",
            "",
            "",
            "\1\160",
            "\1\161",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "",
            "",
            "",
            "",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\174\6\uffff\1\173",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0086\5\uffff\1\u0085",
            "\1\u0088\5\uffff\1\u0087",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\42\137\1\u008d\uffdd\137",
            "",
            "",
            "",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0096",
            "\1\u0097\1\u0098\1\u0099\1\uffff\1\u009a\3\uffff\1\u009b\2"+
            "\uffff\1\u009c\2\uffff\1\u009d\1\u009e\2\uffff\1\u009f\1\u00a0",
            "\1\u00a1",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00a3",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00a5",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\12\56\7\uffff\32\56\6\uffff\24\56\1\u00a9\5\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00ac",
            "\12\56\7\uffff\24\56\1\u00ad\5\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00af\1\uffff\1\u00ae",
            "\1\u00b1\1\uffff\1\u00b0",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be\16\uffff\1\u00bf",
            "\1\u00c0",
            "",
            "",
            "",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "",
            "",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\12\56\7\uffff\16\56\1\u00df\13\56\6\uffff\32\56",
            "\1\u00e1",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00e3",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00e5",
            "\1\u00e6",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00f6",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00f8",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00f9",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00fb",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\u0103",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d\14\uffff\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\12\56\7\uffff\26\56\1\u0114\3\56\6\uffff\32\56",
            "",
            "\1\u0116",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u011a",
            "\1\u011b",
            "\1\u011c",
            "\1\u011d",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u011f",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b\6\uffff\1\u012c\2\uffff\1\u012d",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\u012e",
            "",
            "\1\u012f",
            "",
            "",
            "",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "",
            "\1\u0134",
            "",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\1\u0147",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "\1\u014c",
            "",
            "\1\u014d",
            "\1\u014e",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0158",
            "\1\u0159",
            "",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c\14\uffff\1\u015d",
            "\1\u015e",
            "\1\u015f",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\u0161",
            "\1\u0162",
            "\1\u0163",
            "\1\u0164",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "",
            "\1\u0168",
            "\1\u0169",
            "\1\u016a",
            "\1\u016b",
            "\1\u016c",
            "\1\u016d",
            "\1\u016e",
            "\1\u016f",
            "",
            "\1\u0170",
            "\1\u0171",
            "\1\u0172",
            "\1\u0173",
            "\1\u0174",
            "\1\u0175",
            "\1\u0176",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\1\u017c",
            "\1\u017d",
            "\1\u017e",
            "\1\u017f",
            "\1\u0180",
            "\1\u0181",
            "\1\u0182",
            "\1\u0183",
            "\1\u0184",
            "\1\u0185",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0187",
            "\1\u0188",
            "\1\u0189",
            "\1\u018a",
            "\1\u018b",
            "\1\u018c",
            "\1\u018d",
            "\1\u018e",
            "\1\u018f",
            "\1\u0190",
            "\1\u0191",
            "\1\u0192",
            "\1\u0193",
            "\1\u0194",
            "",
            "\1\u0195",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u0197",
            "\1\u0198",
            "\1\u0199",
            "\1\u019a",
            "\1\u019b",
            "\1\u019c",
            "\1\u019d",
            "\1\u019e",
            "\1\u019f",
            "\1\u01a0",
            "\1\u01a1",
            "\1\u01a2",
            "\1\u01a3",
            "",
            "\1\u01a4",
            "\1\u01a5",
            "\1\u01a6",
            "\1\u01a7",
            "\1\u01a8",
            "\1\u01a9",
            "\1\u01aa",
            "\1\u01ab",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01ad",
            "\1\u01ae",
            "\1\u01af",
            "\1\u01b0",
            "\1\u01b1",
            "\1\u01b2",
            "\1\u01b3",
            "\1\u01b4",
            "\1\u01b5",
            "\1\u01b6",
            "\12\56\7\uffff\32\56\6\uffff\22\56\1\u01b7\7\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\u01ba",
            "\1\u01bb",
            "\1\u01bc",
            "\1\u01bd",
            "\1\u01be",
            "\1\u01bf",
            "\1\u01c0",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01c2",
            "\1\u01c3",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "",
            "\1\u01c5",
            "\1\u01c6",
            "\1\u01c7",
            "\1\u01c8",
            "\1\u01c9",
            "\1\u01ca",
            "\12\56\7\uffff\10\56\1\u01cb\15\56\1\u01cc\3\56\6\uffff\32"+
            "\56",
            "",
            "\1\u01ce",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\u01d0",
            "\1\u01d1",
            "\1\u01d2",
            "\1\u01d3",
            "\1\u01d4",
            "\1\u01d5",
            "\1\u01d6",
            "\1\u01d7",
            "",
            "\1\u01d8",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01db",
            "\1\u01dc",
            "\1\u01dd",
            "\1\u01de",
            "\1\u01df",
            "\1\u01e0",
            "\1\u01e1",
            "",
            "",
            "\1\u01e2",
            "\1\u01e3",
            "\1\u01e4",
            "\1\u01e5",
            "\1\u01e6",
            "\1\u01e7",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01ea",
            "\1\u01eb",
            "\1\u01ec",
            "\1\u01ed",
            "\1\u01ee",
            "",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01f0",
            "\1\u01f1",
            "\1\u01f2",
            "\1\u01f3",
            "",
            "\1\u01f4",
            "\1\u01f5",
            "\1\u01f6",
            "\1\u01f7",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01f9",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "\1\u01fb",
            "",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            "",
            "\1\u01fd",
            "",
            "\1\u01fe",
            "\1\u01ff",
            "\12\56\7\uffff\32\56\6\uffff\32\56",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( WHERE | ALL | ANY | NOT | COMA | OR | AND | EQUALS | NOTEQUALS | GT | LT | GE | LE | PLUS | MINUS | MULT | DIV | MOD | AS | GROUPAS | LEFT_BRACKET | RIGHT_BRACKET | DOT | BAG | STRUCT | COUNT | SUM | AVG | MIN | MAX | UNIQUE | EXISTS | MINUS_F | UNION_F | INTERSECT_F | EXCEPT_F | VOTE_F | CONCAT_F | CONCAT_WITH_DELIMITER_F | LEAST_FREQUENT_OCCURENCE_F | MOST_FREQUENT_OCCURENCE_F | VOTE_ON_STRING_F | GET_ACTUAL_OWNER_F | GET_BUSINESS_ADMINISTRATORS_F | GET_COUNT_OF_FINISHED_SUBTASKS_F | GET_COUNT_OF_SUBTASKS_F | GET_COUNT_OF_SUBTASKS_IN_STATE_F | GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F | GET_EXCLUDED_OWNERS_F | GET_INPUT_F | GET_LOGICAL_PEOPLE_GROUP_F | GET_OUTCOME_F | GET_OUTPUT_F | GET_POTENTIAL_OWNERS_F | GET_SUBTASK_OUTPUT_F | GET_SUBTASK_OUTPUTS_F | GET_TASK_INITIATOR_F | GET_TASK_PRIORITY_F | GET_TASK_STAKEHOLDERS_F | WAIT_FOR_F | WAIT_UNTIL_F | DELIMLITERAL | INTEGERLITERAL | DOUBLELITERAL | BOOLEANLITERAL | IDENTLITERAL | STRINGLITERAL | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_42 = input.LA(1);

                        s = -1;
                        if ( (LA36_42==','||LA36_42=='.'||(LA36_42>=':' && LA36_42<=';')) ) {s = 94;}

                        else if ( ((LA36_42>='\u0000' && LA36_42<='+')||LA36_42=='-'||(LA36_42>='/' && LA36_42<='9')||(LA36_42>='<' && LA36_42<='\uFFFF')) ) {s = 95;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_94 = input.LA(1);

                        s = -1;
                        if ( (LA36_94=='\"') ) {s = 141;}

                        else if ( ((LA36_94>='\u0000' && LA36_94<='!')||(LA36_94>='#' && LA36_94<='\uFFFF')) ) {s = 95;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}