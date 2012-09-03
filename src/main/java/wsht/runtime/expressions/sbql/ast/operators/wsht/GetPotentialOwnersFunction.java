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
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.utils.ApplicationContextProvider;

/*
 * Returns the potential owners of the task. It MUST evaluate 
 * to an empty htt:organizationalEntity in case of an error.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 potential owners (htt:organizationalEntity)
 */
public class GetPotentialOwnersFunction extends WSHTOperator implements IOperator {
	
	private String taskName;
	
	public GetPotentialOwnersFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		//TODO: implement GetPotentialOwnersFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 4) 
				throw new SBQLEvalException("GetPotentialOwnersFunction.eval - element nie jest wartoscia struct 3 elementowa");
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetPotentialOwners(this);		
	}

}