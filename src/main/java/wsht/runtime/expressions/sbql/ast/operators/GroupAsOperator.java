package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BinderResult;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class GroupAsOperator extends UnaryExpression implements IOperator {

	private String name;
	
	public GroupAsOperator(Expression exp, String name) {
		super.setInnerExpression(exp);
		this.name = name;
	}

	public void eval() {
		AbstractQueryResult value = QRES.getInstance().pop(false);
		BinderResult result = new BinderResult(value, name);
		QRES.getInstance().push(result);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGroupAsExpression(this);
	}

}

