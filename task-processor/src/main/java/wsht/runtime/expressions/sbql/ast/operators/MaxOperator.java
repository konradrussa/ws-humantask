package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.SBQLUtil;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
� min, max, unique, exists, count � tradycyjne operatory agregujace.
	Ewaluacja: podobnie jak sum. Ostatnie dwa operatory nie dokonuja dereferencji
	rezultatow.
 */

/*
Returns the maximum value of all number nodes - returns NaN for an empty node-set
In
 node-set of number nodes
 */

public class MaxOperator extends UnaryExpression implements IOperator {

	public MaxOperator(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		RealResult eres = new RealResult();
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			for(AbstractQueryResult r : bagRes.getElements()) {
				r = SBQLUtil.deref(r);
				if(r instanceof IntegerResult) {
					double value = ((IntegerResult)r).getValue().doubleValue();
					if(eres.getValue() == null) eres.setValue(value);
					if(value > eres.getValue()) eres.setValue(value);
				} else if(r instanceof RealResult) {
					if(eres.getValue() == null) eres.setValue(((RealResult)r).getValue());
					if(((RealResult)r).getValue() > eres.getValue()) eres.setValue(((RealResult)r).getValue());
				} else {
					throw new SBQLEvalException("MaxOperator.eval - element nie jest wartoscia liczbowa");
				}
			}
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			for(AbstractQueryResult r : structRes.getAtoms()) {
				r = SBQLUtil.deref(r);
				if(r instanceof IntegerResult) {
					double value = ((IntegerResult)r).getValue().doubleValue();
					if(eres.getValue() == null) eres.setValue(value);
					if(value > eres.getValue()) eres.setValue(value);
				} else if(r instanceof RealResult) {
					if(eres.getValue() == null) eres.setValue(((RealResult)r).getValue());
					if(((RealResult)r).getValue() > eres.getValue()) eres.setValue(((RealResult)r).getValue());
				} else {
					throw new SBQLEvalException("MaxOperator.eval - element nie jest wartoscia liczbowa");
				}
			}
		}  else {
			if(res instanceof IntegerResult) {
				double value = ((IntegerResult)res).getValue().doubleValue();
				if(eres.getValue() == null) eres.setValue(value);
			} else if(res instanceof RealResult) {
				if(eres.getValue() == null) eres.setValue(((RealResult)res).getValue());
			}
			//throw new SBQLEvalException("MaxOperator.eval - elementy nie sa kolekcja");
		}
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitMaxExpression(this);
	}

}

