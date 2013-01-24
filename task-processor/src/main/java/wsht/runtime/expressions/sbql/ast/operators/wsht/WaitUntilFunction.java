package wsht.runtime.expressions.sbql.ast.operators.wsht;

import java.util.Date;

import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.utils.OperatorUtils;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.DateResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;

/*
The parameter is an XPath expression evaluating to a string conforming to the definition
 of the XML Schema type dateTime
o The return value is true after the specified absolute time has passed, otherwise false.

boolean htd:waitUntil(string)
 */

public class WaitUntilFunction  extends WSHTOperator implements IOperator {
	
	public WaitUntilFunction(Expression expression) {
		super.setInnerExpression(expression);
		
	}
	
	public void eval() {
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StringResult) {
			StringResult strRes = (StringResult) res;
			
			Date computedDate = OperatorUtils.returnDateDeadline(strRes.getValue());
			boolean elapsed = OperatorUtils.checkComputedDateElapsed(computedDate);
				
			StructResult eres = new StructResult();
			BooleanResult eres1 = new BooleanResult(elapsed);
			eres.add(eres1);
			DateResult eres2 = new DateResult(computedDate);
			eres.add(eres2);
			QRES.getInstance().push(eres);
		} else {
			throw new SBQLEvalException("WaitForFunction.eval - ewaluacja na stingu w formacie XML Schema type dateTime, np 2002-05-30T09:00:00");
		}
		
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitWaitUntil(this);		
	}


}