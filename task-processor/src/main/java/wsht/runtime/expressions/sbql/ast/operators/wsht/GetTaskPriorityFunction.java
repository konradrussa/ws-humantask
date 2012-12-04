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
 * Returns the priority of the task.
It MUST evaluate to “5” in case the priority is not explicitly set.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 priority (htt:tPriority)
 */
public class GetTaskPriorityFunction extends WSHTOperator implements IOperator {

	private String taskName;
	
	public GetTaskPriorityFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		
		//TODO: implement GetTaskPriorityFunction eval
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("GetTaskPriorityFunction.eval - element nie jest wartoscia struct 2 elementowa");
		} else {
			throw new SBQLEvalException("GetTaskPriorityFunction.eval - parametr procent niewlasciwy");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetTaskPriority(this);		
	}

}