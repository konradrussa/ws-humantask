package wsht.runtime.expressions.sbql.ast.expressions;


public abstract class BinaryExpression implements Expression {

	private Expression leftExpression;
	private Expression rightExpression;
	
	public BinaryExpression(Expression leftExpression, Expression rightExpression) {
		this.leftExpression = leftExpression;
		this.rightExpression = rightExpression;
	}

	//S/G
	public Expression getLeftExpression() {
		return leftExpression;
	}

	public Expression getRightExpression() {
		return rightExpression;
	}
	
}
