package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.SBQLUtil;

/*
Returns the concatenation of all string nodes - returns an empty string for an empty node-set
In
 node-set of string nodes
 */

public class ConcatFunction extends UnaryExpression implements IOperator {

	public ConcatFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	
	public void eval() {
		StringResult eres = new StringResult();
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			for(AbstractQueryResult r : bagRes.getElements()) {
				r = SBQLUtil.deref(r);
				if(r instanceof StringResult) {
					eres.setValue(((eres.getValue() == null)? "" : eres.getValue()) + ((StringResult) res).getValue());
				} else {
					throw new SBQLEvalException("ConcateFunction.eval - element nie jest wartoscia liczbowa");
				}
			}
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			for(AbstractQueryResult r : structRes.getAtoms()) {
				r = SBQLUtil.deref(r);
				if(r instanceof StringResult) {
					eres.setValue(((eres.getValue() == null)? "" : eres.getValue()) + ((StringResult) res).getValue());
				} else {
					throw new SBQLEvalException("ConcateFunction.eval - element nie jest wartoscia liczbowa");
				}
			}
		}  else {
			if(res instanceof StringResult) {
				eres.setValue(((StringResult) res).getValue());
			} 
			//throw new SBQLEvalException("ConcateFunction.eval - elementy nie sa kolekcja");
		}
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitConcat(this);
	}

}