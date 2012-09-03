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
 * Returns the stakeholders of the task.
It MUST evaluate to an empty htt:organizationalEntity in case of an error.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 task stakeholders (htt:organizationalEntity)
 */
public class GetTaskStakeholdersFunction extends WSHTOperator implements IOperator {

	private String taskName;
	
	public GetTaskStakeholdersFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("GetTaskStakeholdersFunction.eval - element nie jest wartoscia struct 2 elementowa");
		} else {
			throw new SBQLEvalException("GetTaskStakeholdersFunction.eval - parametr procent niewlasciwy");
		}
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetTaskStakeholders(this);		
	}

}