package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.utils.ApplicationContextProvider;

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
	
	@Override
	public void eval() {
		
		//TODO: implement GetOutcomeFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StringResult) {
			StringResult term = (StringResult) res;
			String taskName = term.getValue();
		}
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetOutcome(this);		
	}

}