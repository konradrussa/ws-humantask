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
	
	@Override
	public void eval() {
		
		//TODO: implement GetExcludedOwnersFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StringResult) {
			StringResult term = (StringResult) res;
			String taskName = term.getValue();
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetExcludedOwners(this);		
	}

}