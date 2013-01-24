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
import wsht.runtime.expressions.sbql.qres.result.StructResult;

/*
 * Returns the outcome of the task. It MUST evaluate to an empty string 
 * in case there is no outcome specified for the task.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 the task outcome (xsd:string)
 */
public class GetOutcomeFunction extends WSHTOperator implements IOperator {

	
	public GetOutcomeFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	
	public void eval() {
		
		AbstractQueryResult res = QRES.getInstance().pop(false);
		
		if(res instanceof StringResult) {
			BagResult resOut = ENVS.getInstance().bind(((StringResult) res).getValue());
			QRES.getInstance().push(resOut);
		} else if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("GetOutcomeFunction.eval - element nie jest wartoscia struct 2 elementowa");
			
			BagResult resOut = ENVS.getInstance().bind(((StringResult) term.getElements().get(0)).getValue());
			QRES.getInstance().push(resOut);
		}
		
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetOutcome(this);		
	}

}