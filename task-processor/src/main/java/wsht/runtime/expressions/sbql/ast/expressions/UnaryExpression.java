package wsht.runtime.expressions.sbql.ast.expressions;


public abstract class UnaryExpression implements Expression {

	private Expression innerExpression;
	
	//S/G
	public Expression getInnerExpression() {
		return innerExpression;
	}

	protected void setInnerExpression(Expression innerExpression) {
		this.innerExpression = innerExpression;
	}
	

}
