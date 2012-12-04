package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.enums.TaskStatesEnum;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.StructConstructor;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.ast.terminals.StringTerminal;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.utils.ApplicationContextProvider;

/*
 * Returns the number of a task suubtasks that are in the specified state
If the task name is not present the current task MUST be considered
In
 state
 task name (optional)
Out
 Number of the task sub tasks in the specified state. If the task doesn't have sub tasks then 0 is returned
 */
public class GetCountOfSubTasksInStateFunction extends WSHTOperator implements IOperator {
	
	public GetCountOfSubTasksInStateFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	
	public void eval() {
		
		//TODO: implement GetCountOfSubTasksInStateFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 1 || term.getElements().size() != 2) 
				throw new SBQLEvalException("GetCountOfSubTasksInStateFunction.eval - element nie jest wartoscia struct 1 lub 2 elementowa");
		}
		
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetCountOfSubTasksInState(this);		
	}

}