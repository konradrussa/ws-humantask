package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.utils.ApplicationContextProvider;

/*
 * Returns the number of a task sub tasks that match the given outcome
If the task name is not present the current task MUST be considered
In
 outcome
 task name (optional)
Out
 Number of the task sub tasks that match the specified outcome. 
If the task doesn't have sub tasks then 0 is returned
 */
public class GetCountOfSubTasksWithOutcomeFunction extends WSHTOperator implements IOperator {

	private String taskName;
	
	public GetCountOfSubTasksWithOutcomeFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		//TODO: implement GetCountOfSubTasksWithOutcomeFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 1 || term.getElements().size() != 2) 
				throw new SBQLEvalException("GetCountOfSubTasksWithOutcomeFunction.eval - element nie jest wartoscia struct 1 lub 2 elementowa");
		}
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetCountOfSubTasksWithOutcome(this);		
	}

}