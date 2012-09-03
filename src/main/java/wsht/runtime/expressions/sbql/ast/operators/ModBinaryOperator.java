package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.util.Util;
import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class ModBinaryOperator extends BinaryExpression implements IOperator {

	public ModBinaryOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		AbstractQueryResult right = QRES.getInstance().pop(false);
		AbstractQueryResult left = QRES.getInstance().pop(false);
		right = Util.deref(right);
		left = Util.deref(left);
		AbstractQueryResult result = null;
		
		if (right instanceof IntegerResult && left instanceof IntegerResult) {
			IntegerResult r = (IntegerResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new RealResult(l.getValue().doubleValue() % r.getValue().doubleValue());
		} else if (right instanceof RealResult && left instanceof RealResult) {
			RealResult r = (RealResult) right;
			RealResult l = (RealResult) left;
			result = new RealResult(l.getValue() % r.getValue());
		} else if (right instanceof RealResult && left instanceof IntegerResult) {
			RealResult r = (RealResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new RealResult(l.getValue() % r.getValue());
		} else if (right instanceof IntegerResult && left instanceof RealResult) {
			IntegerResult r = (IntegerResult) right;
			RealResult l = (RealResult) left;
			result = new RealResult(l.getValue() % r.getValue());
		} else {
			throw new SBQLEvalException("ModBinaryOperator.eval: blad typu");
		}
		QRES.getInstance().push(result);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitModBinaryExpression(this);
	}
}