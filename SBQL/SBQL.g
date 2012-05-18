grammar SBQL;

options {
  language = Java;
  output = AST; 
  ASTLabelType = CommonTree; 
  //backtrack=true; 
}


@header {
package wsht.runtime.expressions.sbql.qres.grammar;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.*;
import wsht.runtime.expressions.sbql.ast.expressions.*;
import wsht.runtime.expressions.sbql.ast.terminals.*;
import wsht.runtime.expressions.sbql.ast.operators.*;
import wsht.runtime.expressions.sbql.ast.operators.wsht.*;
}

@lexer::header {
package wsht.runtime.expressions.sbql.qres.grammar;
}

@members {
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
  public String getTokenErrorDisplay(Token t) {
    return t.toString();
  }
}


evaluator 
      : e = waitUntilExpression EOF {System.out.println($e.tree.toStringTree().replaceAll("null","")); $e.expr.accept(interpreter);}
      ;

terminalExpression returns [Expression expr]
      : LEFT_BRACKET e1 = intersectExpression RIGHT_BRACKET {$expr = $e1.expr;}
      | INTEGERLITERAL {$expr = new IntegerTerminal(Integer.parseInt($INTEGERLITERAL.text));}
      | DOUBLELITERAL {$expr = new DoubleTerminal(Double.parseDouble($DOUBLELITERAL.text));}
      | BOOLEANLITERAL {$expr = new BooleanTerminal(Boolean.parseBoolean($BOOLEANLITERAL.text));}
      | STRINGLITERAL {
          String s = new String($STRINGLITERAL.text).replaceAll("\"", "");
          $expr = new StringTerminal(s);}
      ; 
      
nameExpression returns [Expression expr]
      :  IDENTLITERAL {$expr = new NameExpression(new IdentTerminal($IDENTLITERAL.text));}
      |  e1 = terminalExpression {$expr = $e1.expr;}
      ;
      
unaryExpression returns [Expression expr]
      : { boolean positive = true; }
      (PLUS | MINUS { positive = !positive; })*  nameExpression 
      { $expr = $nameExpression.expr;
        if (!positive)
          $expr = new MinusUnaryOperator($expr);
      } 
      ;
      
multExpression returns [Expression expr]
      : e1 = unaryExpression {$expr = $e1.expr;}
      ( MULT e2 = unaryExpression {$expr = new MultiplyBinaryOperator($expr, $e2.expr);}
      | DIV e2 = unaryExpression {$expr = new DivideBinaryOperator($expr, $e2.expr);}
      | MOD e2 = unaryExpression {$expr = new ModBinaryOperator($expr, $e2.expr);}
      )*
      ;

additiveExpression returns [Expression expr]
      : e1 = multExpression {$expr = $e1.expr;}
      ( PLUS e2 = multExpression {$expr = new PlusBinaryOperator($expr, $e2.expr);}
      | MINUS e2 = multExpression {$expr = new MinusBinaryOperator($expr, $e2.expr);}
      )*
      ;
      
booleanOrExpression returns [Expression expr]
      :  e1 = additiveExpression {$expr = $e1.expr;}
      ( OR e2 = additiveExpression {$expr = new OrOperator($expr, $e2.expr);}
      )*
      ;
      
booleanAndExpression returns [Expression expr]
      :  e1 = booleanOrExpression {$expr = $e1.expr;}
      ( AND e2 = booleanOrExpression {$expr = new AndOperator($expr, $e2.expr);}
      )*
      ;
      
equityExpression returns [Expression expr]
      : e1 = booleanAndExpression {$expr = $e1.expr;}
      ( EQUALS e2 = booleanAndExpression {$expr = new EqualsOperator($expr, $e2.expr);}
      | NOTEQUALS e2 = booleanAndExpression {$expr = new NotEqualsOperator($expr, $e2.expr);}
      | GT e2 = booleanAndExpression {$expr = new GreaterOperator($expr, $e2.expr);}
      | LT e2 = booleanAndExpression {$expr = new LessOperator($expr, $e2.expr);}
      | GE e2 = booleanAndExpression {$expr = new GreaterEqualsOperator($expr, $e2.expr);}
      | LE e2 = booleanAndExpression {$expr = new LessEqualsOperator($expr, $e2.expr);}
      )*
      ;

dotExpression returns [Expression expr]
      : e1 = equityExpression {$expr = $e1.expr;}
      ( DOT e2 = equityExpression {$expr = new DotExpression($expr, $e2.expr);})*
      ;  
    
whereExpression returns [Expression expr] 
      : e1 = dotExpression {$expr = $e1.expr;}
      ( WHERE e2 = dotExpression {$expr = new WhereExpression($expr, $e2.expr);})*
      ; 

structExpression returns [Expression expr]
      : e1 = whereExpression {$expr = $e1.expr;}
      | (STRUCT e1 = whereExpression )
        {$expr = new StructConstructor($e1.expr);} 
      ;

bagExpression returns [Expression expr]
      : e1 = structExpression {$expr = $e1.expr;} 
      | BAG e1 = structExpression
        {$expr = new BagConstructor($e1.expr);}     
      ;

commaExpression returns [Expression expr]
      : e1 = bagExpression {$expr = $e1.expr;}
      ( COMA e2 = bagExpression {$expr = new CommaOperator($expr, $e2.expr);})*
      ;
      
allExpression returns [Expression expr]
      : e1 = commaExpression {$expr = $e1.expr;}
      | (ALL LEFT_BRACKET e1=commaExpression RIGHT_BRACKET) 
        (LEFT_BRACKET e2=commaExpression RIGHT_BRACKET) 
        {$expr = new AllOperator($e1.expr, $e2.expr);}
      ;

anyExpression returns [Expression expr]
      : e1 = allExpression {$expr = $e1.expr;} 
      | (ANY LEFT_BRACKET e1=allExpression RIGHT_BRACKET) 
        (LEFT_BRACKET e2=allExpression RIGHT_BRACKET) 
        {$expr = new AnyOperator($e1.expr, $e2.expr);}
      ;
      
sumExpression returns [Expression expr] 
      : e1 = anyExpression {$expr = $e1.expr;}
      | SUM LEFT_BRACKET anyExpression RIGHT_BRACKET {$expr = new SumOperator($anyExpression.expr);}
      ;   
      
minExpression returns [Expression expr] 
      : e1 = sumExpression {$expr = $e1.expr;}
      | MIN LEFT_BRACKET sumExpression RIGHT_BRACKET {$expr = new MinOperator($sumExpression.expr);}
      ; 
      
maxExpression returns [Expression expr] 
      : e1 = minExpression {$expr = $e1.expr;}
      | MAX LEFT_BRACKET minExpression RIGHT_BRACKET {$expr = new MaxOperator($minExpression.expr);}
      ;

avgExpression returns [Expression expr] 
      : e1 = maxExpression {$expr = $e1.expr;}
      | AVG LEFT_BRACKET maxExpression RIGHT_BRACKET {$expr = new AvgOperator($maxExpression.expr);}
      ;  
      
countExpression returns [Expression expr] 
      : e1 = avgExpression {$expr = $e1.expr;}
      | COUNT LEFT_BRACKET avgExpression RIGHT_BRACKET {$expr = new CountOperator($avgExpression.expr);}
      ; 

asExpression returns [Expression expr] 
      : e1 = countExpression {$expr = $e1.expr;} 
      (AS IDENTLITERAL  {$expr = new AsOperator($expr, $IDENTLITERAL.text);})*
      ; 
      
groupasExpression returns [Expression expr] 
      : e1 = asExpression {$expr = $e1.expr;} 
      (GROUPAS IDENTLITERAL  {$expr = new GroupAsOperator($expr, $IDENTLITERAL.text);})*
      ; 
      
minusExpression returns [Expression expr] 
      : e1 = groupasExpression {$expr = $e1.expr;}
      (MINUS_F e2 = groupasExpression {$expr = new MinusOperator($expr, $e2.expr);})*
      ;
      
unionExpression returns [Expression expr] 
      : e1 = minusExpression {$expr = $e1.expr;}
      (UNION_F e2 = minusExpression {$expr = new UnionOperator($expr, $e2.expr);})*
      ;
      
intersectExpression returns [Expression expr] 
      : e1 = unionExpression {$expr = $e1.expr;}
      (INTERSECT_F e2 = unionExpression {$expr = new IntersectOperator($expr, $e2.expr);})*
      ;

//wsht

exceptExpression returns [Expression expr]
      : e1 = intersectExpression {$expr = $e1.expr;}
      (EXCEPT_F e2 = intersectExpression {$expr = new ExceptFunction($expr, $e2.expr);})*
      ;
      
concatExpression returns [Expression expr]
      : e1 = exceptExpression {$expr = $e1.expr;} 
      | (CONCAT_F LEFT_BRACKET exceptExpression RIGHT_BRACKET {$expr = new ConcatFunction($exceptExpression.expr);})
      ;
      
concatWithDelimiterExpression returns [Expression expr]
      : e1 = concatExpression {$expr = $e1.expr;} 
      | (CONCAT_WITH_DELIMITER_F LEFT_BRACKET concatExpression RIGHT_BRACKET {$expr = new ConcatWithDelimiterFunction($concatExpression.expr);})
      ;

voteExpression returns [Expression expr]
      : e1 = concatWithDelimiterExpression {$expr = $e1.expr;}
      | (VOTE_F LEFT_BRACKET concatWithDelimiterExpression RIGHT_BRACKET {$expr = new VoteFunction($concatWithDelimiterExpression.expr);})
      ;
voteOnStringExpression returns [Expression expr]
      : e1 = voteExpression {$expr = $e1.expr;}
      | (VOTE_ON_STRING_F LEFT_BRACKET voteExpression RIGHT_BRACKET {$expr = new VoteOnStringFunction($voteExpression.expr);})
      ;
      
leastFrequentOccurenceExpression returns [Expression expr]
      : e1 = voteOnStringExpression {$expr = $e1.expr;}
      | (LEAST_FREQUENT_OCCURENCE_F LEFT_BRACKET voteOnStringExpression RIGHT_BRACKET {$expr = new LeastFrequentOccurenceFunction($voteOnStringExpression.expr);})
      ;
mostFrequentOccurenceExpression returns [Expression expr]
      : e1 = leastFrequentOccurenceExpression {$expr = $e1.expr;}
      | (MOST_FREQUENT_OCCURENCE_F LEFT_BRACKET leastFrequentOccurenceExpression RIGHT_BRACKET {$expr = new MostFrequentOccurenceFunction($leastFrequentOccurenceExpression.expr);})
      ;

getActualOwnerExpression returns [Expression expr]
      : e1 = mostFrequentOccurenceExpression {$expr = $e1.expr;}
      | (GET_ACTUAL_OWNER_F LEFT_BRACKET mostFrequentOccurenceExpression RIGHT_BRACKET {$expr = new GetActualOwnerFunction($mostFrequentOccurenceExpression.expr);})
      ;

getBusinessAdministratorsExpression returns [Expression expr]
      : e1 = getActualOwnerExpression {$expr = $e1.expr;}
      | (GET_BUSINESS_ADMINISTRATORS_F LEFT_BRACKET getActualOwnerExpression RIGHT_BRACKET {$expr = new GetBusinessAdministratorsFunction($getActualOwnerExpression.expr);})
      ;
      
getCountOfFinishedSubTasksExpression returns [Expression expr]
      : e1 = getBusinessAdministratorsExpression {$expr = $e1.expr;}
      | (GET_COUNT_OF_FINISHED_SUBTASKS_F LEFT_BRACKET getBusinessAdministratorsExpression RIGHT_BRACKET {$expr = new GetCountOfFinishedSubTasksFunction($getBusinessAdministratorsExpression.expr);})
      ;
      
getCountOfSubTasksExpression returns [Expression expr]
      : e1 = getCountOfFinishedSubTasksExpression {$expr = $e1.expr;}
      | (GET_COUNT_OF_SUBTASKS_F LEFT_BRACKET getCountOfFinishedSubTasksExpression RIGHT_BRACKET {$expr = new GetCountOfSubTasksFunction($getCountOfFinishedSubTasksExpression.expr);})
      ;
      
getCountOfSubTasksInStateExpression returns [Expression expr]
      : e1 = getCountOfSubTasksExpression {$expr = $e1.expr;}
      | (GET_COUNT_OF_SUBTASKS_IN_STATE_F LEFT_BRACKET getCountOfSubTasksExpression RIGHT_BRACKET {$expr = new GetCountOfSubTasksInStateFunction($getCountOfSubTasksExpression.expr);})
      ;
      
getCountOfSubTasksWithOutcomeExpression returns [Expression expr]
      : e1 = getCountOfSubTasksInStateExpression {$expr = $e1.expr;}
      | (GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F LEFT_BRACKET getCountOfSubTasksInStateExpression RIGHT_BRACKET {$expr = new GetCountOfSubTasksWithOutcomeFunction($getCountOfSubTasksInStateExpression.expr);})
      ;

getExcludedOwnersExpression returns [Expression expr]
      : e1 = getCountOfSubTasksWithOutcomeExpression {$expr = $e1.expr;}
      | (GET_EXCLUDED_OWNERS_F LEFT_BRACKET getCountOfSubTasksWithOutcomeExpression RIGHT_BRACKET {$expr = new GetExcludedOwnersFunction($getCountOfSubTasksWithOutcomeExpression.expr);})
      ;
getInputExpression returns [Expression expr]
      : e1 = getExcludedOwnersExpression {$expr = $e1.expr;}
      | (GET_INPUT_F LEFT_BRACKET getExcludedOwnersExpression RIGHT_BRACKET {$expr = new GetInputFunction($getExcludedOwnersExpression.expr);})
      ;
      
getLogicalPeopleGroupExpression returns [Expression expr]
      : e1 = getInputExpression {$expr = $e1.expr;}
      | (GET_LOGICAL_PEOPLE_GROUP_F LEFT_BRACKET getInputExpression RIGHT_BRACKET {$expr = new GetLogicalPeopleGroupFunction($getInputExpression.expr);})
      ;

getOutcomeExpression returns [Expression expr]
      : e1 = getLogicalPeopleGroupExpression {$expr = $e1.expr;}
      | (GET_OUTCOME_F LEFT_BRACKET getLogicalPeopleGroupExpression RIGHT_BRACKET {$expr = new GetOutcomeFunction($getLogicalPeopleGroupExpression.expr);})
      ;

getOutputExpression returns [Expression expr]
      : e1 = getOutcomeExpression {$expr = $e1.expr;}
      | (GET_OUTPUT_F LEFT_BRACKET getOutcomeExpression RIGHT_BRACKET {$expr = new GetOutputFunction($getOutcomeExpression.expr);})
      ;
            
getPotentialOwnersExpression returns [Expression expr]
      : e1 = getOutputExpression {$expr = $e1.expr;}
      | (GET_POTENTIAL_OWNERS_F LEFT_BRACKET getOutputExpression RIGHT_BRACKET {$expr = new GetPotentialOwnersFunction($getOutputExpression.expr);})
      ;
      
getSubtaskOutputExpression returns [Expression expr]
      : e1 = getPotentialOwnersExpression {$expr = $e1.expr;}
      | (GET_SUBTASK_OUTPUT_F LEFT_BRACKET getPotentialOwnersExpression RIGHT_BRACKET {$expr = new GetSubtaskOutputFunction($getPotentialOwnersExpression.expr);})
      ;
      
getSubtaskOutputsExpression returns [Expression expr]
      : e1 = getSubtaskOutputExpression {$expr = $e1.expr;}
      | (GET_SUBTASK_OUTPUTS_F LEFT_BRACKET getSubtaskOutputExpression RIGHT_BRACKET {$expr = new GetSubtaskOutputsFunction($getSubtaskOutputExpression.expr);})
      ;
      
getTaskInitiatorExpression returns [Expression expr]
      : e1 = getSubtaskOutputsExpression {$expr = $e1.expr;}
      | (GET_TASK_INITIATOR_F LEFT_BRACKET getSubtaskOutputsExpression RIGHT_BRACKET {$expr = new GetTaskInitiatorFunction($getSubtaskOutputsExpression.expr);})
      ;
      
getTaskPriorityExpression returns [Expression expr]
      : e1 = getTaskInitiatorExpression {$expr = $e1.expr;}
      | (GET_TASK_PRIORITY_F LEFT_BRACKET getTaskInitiatorExpression RIGHT_BRACKET {$expr = new GetTaskPriorityFunction($getTaskInitiatorExpression.expr);})
      ;
      
getTaskStakeholdersExpression returns [Expression expr]
      : e1 = getTaskPriorityExpression {$expr = $e1.expr;}
      | (GET_TASK_STAKEHOLDERS_F LEFT_BRACKET getTaskPriorityExpression RIGHT_BRACKET {$expr = new GetTaskStakeholdersFunction($getTaskPriorityExpression.expr);})
      ;
      
waitForExpression returns [Expression expr]
      : e1 = getTaskStakeholdersExpression {$expr = $e1.expr;}
      | (WAIT_FOR_F LEFT_BRACKET getTaskStakeholdersExpression RIGHT_BRACKET {$expr = new WaitForFunction($getTaskStakeholdersExpression.expr);})
      ;
      
waitUntilExpression returns [Expression expr]
      : e1 = waitForExpression {$expr = $e1.expr;}
      | (WAIT_UNTIL_F LEFT_BRACKET waitForExpression RIGHT_BRACKET {$expr = new WaitUntilFunction($waitForExpression.expr);})
      ;


WHERE : 'where' | 'WHERE';
ALL : 'all' | 'ALL';
ANY : 'any' | 'ANY';
NOT : '!' | 'not' | 'NOT';
COMA : ',';

OR : '||' | 'or' | 'OR';
AND : '&&' | 'and' | 'AND';  


EQUALS : '=' | '==';
NOTEQUALS : '!=' | '<>';
GT : '>';
LT : '<';
GE : '>=';
LE : '<=';
PLUS: '+';
MINUS: '-';
MULT  : '*';
DIV : '/';
MOD : '%';
AS : 'as' | 'AS';
GROUPAS : 'groupas' | 'GROUPAS';

LEFT_BRACKET : '(';
RIGHT_BRACKET : ')';
DOT: ('.' | DIV);
BAG : 'bag' | 'BAG';
STRUCT : 'struct' | 'STRUCT';

COUNT : 'count' | 'COUNT';

SUM : 'sum' | 'SUM';
AVG : 'avg' | 'AVG';
MIN : 'min' | 'MIN';
MAX : 'max' | 'MAX';

UNIQUE : 'unique' | 'UNIQUE';
EXISTS : 'exists' | 'EXISTS';
MINUS_F : 'minus' | 'MINUS';

UNION_F : 'union' | 'UNION';
INTERSECT_F : 'intersect' | 'INTERSECT';

EXCEPT_F : 'except' | 'EXCEPT';

VOTE_F: 'vote';

CONCAT_F : 'concat';
CONCAT_WITH_DELIMITER_F : 'concatWithDelimiter';
LEAST_FREQUENT_OCCURENCE_F : 'leastFrequentOccurence';
MOST_FREQUENT_OCCURENCE_F : 'mostFrequentOccurence';
VOTE_ON_STRING_F : 'voteOnString';

GET_ACTUAL_OWNER_F : 'getActualOwner';
GET_BUSINESS_ADMINISTRATORS_F : 'getBusinessAdministrators';
GET_COUNT_OF_FINISHED_SUBTASKS_F : 'getCountOfFinishedSubTasks';
GET_COUNT_OF_SUBTASKS_F : 'getCountOfSubTasks';
GET_COUNT_OF_SUBTASKS_IN_STATE_F : 'getCountOfSubTasksInState';
GET_COUNT_OF_SUBTASKS_WITH_OUTCOME_F : 'getCountOfSubTasksWithOutcome';
GET_EXCLUDED_OWNERS_F : 'getExcludedOwners';
GET_INPUT_F : 'getInput';
GET_LOGICAL_PEOPLE_GROUP_F : 'getLogicalPeopleGroup';
GET_OUTCOME_F : 'getOutcome';
GET_OUTPUT_F : 'getOutput';
GET_POTENTIAL_OWNERS_F : 'getPotentialOwners';
GET_SUBTASK_OUTPUT_F : 'getSubtaskOutput';
GET_SUBTASK_OUTPUTS_F : 'getSubtaskOutputs';
GET_TASK_INITIATOR_F : 'getTaskInitiator';
GET_TASK_PRIORITY_F : 'getTaskPriority';
GET_TASK_STAKEHOLDERS_F : 'getTaskStakeholders';

WAIT_FOR_F : 'waitFor';
WAIT_UNTIL_F : 'waitUntil';



fragment
DIGIT : '0'..'9';

fragment 
HEX_DIGIT : (DIGIT | 'a'..'f' | 'A'..'F') 
      ;

fragment
ESC_SEQ
      :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
      |   UNICODE_ESC
      |   OCTAL_ESC
      ;

fragment
OCTAL_ESC
      :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
      |   '\\' ('0'..'7') ('0'..'7')
      |   '\\' ('0'..'7')
      ;

fragment
UNICODE_ESC
      :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
      ;

    
fragment 
EXPONENT    
      :   ( 'e' | 'E' ) ( '+' | '-' )? ( DIGIT )+
      ;

DELIMLITERAL
      : '\"' (','|';'|':'|'.') '\"'
      ;
      
INTEGERLITERAL
      : DIGIT+ 
      ;
      
DOUBLELITERAL
      : DIGIT+ DOT DIGIT+ EXPONENT?
      ;
  
BOOLEANLITERAL
      :'true'
      |'false'
      ;

IDENTLITERAL
      :  ('a'..'z' | 'A'..'Z' )('a'..'z' | 'A'..'Z' | DIGIT)*
      ;
      

STRINGLITERAL
      : '\"' (~'\"')* '\"'
      ;

WS
      : (' ' | '\t' | '\r' | '\f')+ {$channel=HIDDEN;};