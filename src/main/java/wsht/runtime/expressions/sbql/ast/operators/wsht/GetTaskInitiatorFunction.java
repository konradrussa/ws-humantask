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
 * Returns the initiator of the task. It MUST evaluate to an empty htt:user in case there is no initiator.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 the task initiator (user id as htt:user)
 */
public class GetTaskInitiatorFunction extends WSHTOperator implements IOperator {
	
	private String taskName;
	
	public GetTaskInitiatorFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("GetTaskInitiatorFunction.eval - element nie jest wartoscia struct 2 elementowa");
		} else {
			throw new SBQLEvalException("GetTaskInitiatorFunction.eval - parametr procent niewlasciwy");
		}


	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetTaskInitiator(this);		
	}

}