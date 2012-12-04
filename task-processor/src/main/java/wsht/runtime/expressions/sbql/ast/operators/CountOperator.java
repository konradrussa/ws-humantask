package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class CountOperator extends UnaryExpression implements IOperator {

	public CountOperator(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		IntegerResult eres = new IntegerResult(0);
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			eres.setValue(bagRes.getElements().size());
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			eres.setValue(structRes.getAtoms().size());
		} else {
			eres.setValue(1);
			//throw new SBQLEvalException("CountOperator.eval - elementy nie sa kolekcja");
		}
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitCountExpression(this);
	}

}
