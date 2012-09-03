package wsht.runtime.expressions.sbql.ast.operators.wsht;

import java.io.StringReader;

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
 * Returns the actual owner of the task. 
 * It MUST evaluate to an empty htt:user in case there is no actual owner.
If the task name is not present the current task MUST be considered.
In
 task name (optional)
Out
 the actual owner (user id as htt:user)
 */
public class GetActualOwnerFunction extends WSHTOperator implements IOperator {
	
	public GetActualOwnerFunction(Expression expression) {
		super.setInnerExpression(expression);
	}

	@Override
	public void eval() {
		
		//TODO: implement GetActualOwnerFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StringResult) {
			StringResult term = (StringResult) res;
			String taskName = term.getValue();
		}
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetActualOwner(this);
		
	}

}
