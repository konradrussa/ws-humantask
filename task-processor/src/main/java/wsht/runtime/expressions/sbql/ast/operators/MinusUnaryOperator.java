package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.Util;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class MinusUnaryOperator extends UnaryExpression implements IOperator {

	public MinusUnaryOperator(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult || res instanceof StructResult) 
			throw new SBQLEvalException("MinusUnaryOperator.eval - nie jest pojedynczym elementem");
		
		res = Util.deref(res);
		
		if(res instanceof IntegerResult) {
			Integer value = ((IntegerResult)res).getValue();
			((IntegerResult)res).setValue(-value);
		} else if (res instanceof RealResult) {
			Double value = ((RealResult)res).getValue();
			((RealResult)res).setValue(-value);
		} else {
			throw new SBQLEvalException("MinusUnaryOperator.eval - operator nie moze byc zastosowany");
		}
		QRES.getInstance().push(res);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitMinusUnaryOperator(this);
	}

}
