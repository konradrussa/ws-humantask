package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;

/*
 * Returns the excluded owners. It MUST evaluate to an empty htt:organizationalEntity in case of an error.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 excluded owners (htt:organizationalEntity)
 */
public class GetExcludedOwnersFunction extends WSHTOperator implements IOperator {

	
	public GetExcludedOwnersFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	
	public void eval() {
		
		AbstractQueryResult res = QRES.getInstance().pop(true);
		if(res == null) {
			BagResult resOut = ENVS.getInstance().bind(TaskInstance._F_excludedOwnersField);
			QRES.getInstance().push(resOut);
		} else if(res instanceof StringResult) {
			//BagResult resOut = ENVS.getInstance().bind(((StringResult) res).getValue());
			BagResult resOut = ENVS.getInstance().bind(TaskInstance._F_excludedOwnersField);
			QRES.getInstance().push(resOut);
		} else {
			throw new SBQLEvalException("GetExcludedOwnersFunction.eval - nieobslugiwana ilosc agrumentow");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetExcludedOwners(this);		
	}

}