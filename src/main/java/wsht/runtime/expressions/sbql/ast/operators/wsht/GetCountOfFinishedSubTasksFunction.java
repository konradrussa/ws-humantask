package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.ast.terminals.StringTerminal;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.utils.ApplicationContextProvider;

/*
 * Returns the number of finished sub tasks of a task
If the task name is not present the current task MUST be considered
In
 task name (optional)
Out
 Number of the finished task sub-tasks. If the task doesn't have sub tasks then 0 is returned
 */
public class GetCountOfFinishedSubTasksFunction extends WSHTOperator implements IOperator {

	
	public GetCountOfFinishedSubTasksFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		//TODO: implement GetCountOfFinishedSubTasksFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StringResult) {
			StringResult term = (StringResult) res;
			String taskName = term.getValue();
		}
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetCountOfFinishedSubTasks(this);		
	}

}