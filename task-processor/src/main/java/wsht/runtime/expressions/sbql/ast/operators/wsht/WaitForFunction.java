package wsht.runtime.expressions.sbql.ast.operators.wsht;

import java.util.Calendar;
import java.util.Date;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.exceptions.WSHTExpressionException;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.utils.OperatorUtils;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.DateResult;
import wsht.runtime.expressions.sbql.qres.result.LongResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;
import wsht.runtime.expressions.sbql.util.SBQLUtil;
import wsht.runtime.utils.ApplicationContextProvider;

/*
The parameter is an XPath expression evaluating to a string conforming to the definition 
 of the XML Schema type duration
o The return value is true after the specified duration has elapsed, otherwise false

boolean htd:waitFor(string)
 */

public class WaitForFunction extends WSHTOperator implements IOperator {
	
	public WaitForFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StringResult) {
			StringResult strRes = (StringResult) res;
			BagResult resOut = ENVS.getInstance().bind(TaskInstance._F_createdField);
			if(resOut.getElements().isEmpty() || resOut.getElements().size() > 1) {
				throw new SBQLEvalException("WaitForFunction.eval - ewaluacja zakonczona bledem, brak daty utworzenia zadania");
			}
			
			try {
				
				AbstractQueryResult createdDate =  SBQLUtil.deref(resOut.getElements().get(0));
				if(!(createdDate instanceof DateResult)) {
					throw new SBQLEvalException("WaitForFunction.eval - ewaluacja zakonczona bledem, brak elementu DateResult");
				}
				Date created = ((DateResult)createdDate).getValue();
				long millis = OperatorUtils.calculateDuration(strRes.getValue());
				
				Date computedDate = OperatorUtils.returnDateDuration(created, millis);
				boolean elapsed = OperatorUtils.checkComputedDateElapsed(computedDate);
				
				StructResult eres = new StructResult();
				BooleanResult eres1 = new BooleanResult(elapsed);
				eres.add(eres1);
				DateResult eres2 = new DateResult(computedDate);
				eres.add(eres2);
				QRES.getInstance().push(eres);
			} catch(WSHTExpressionException e) {
				throw new SBQLEvalException("WaitForFunction.eval - " + e.getMessage());
			}
		} else {
			throw new SBQLEvalException("WaitUntilFunction.eval - ewaluacja na stingu w formacie XML Schema type duration, np PT15H");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitWaitFor(this);		
	}

}