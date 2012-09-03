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

/*
� sum � suma elementow kolekcji.
	Ewaluacja: 
	1. Zainicjalizuj wartosc, ktora bedzie sluzyc do przechowywania
		sumy (bedziemy odnosic sie do niej jako eres). 
	2. Wykonaj podzapytanie.
	3. Podnies jeden element z QRES. 
	4. Dla kazdego elementu e wykonaj: 
		4.1 Jesli rezultat jest referencja, wykonaj dereferencje. 
		4.2 Jesli rezultat (po ewentualnej dereferencji) nie jest liczba, 
			podnies blad czasu wykonania. 
		4.3 Dodaj liczbe do eres. 
	5. Umiesc eres na QRES.
 */

/*
Returns the sum value of all number nodes - returns NaN for an empty node-set
In
 node-set of number nodes
 */

public class SumOperator extends UnaryExpression implements IOperator {

	public SumOperator(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		RealResult eres = new RealResult(0.0);
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			for(AbstractQueryResult r : bagRes.getElements()) {
				r = Util.deref(r);
				if(r instanceof IntegerResult) {
					double value = ((IntegerResult)r).getValue().doubleValue();
					eres.setValue(eres.getValue() + value);
				} else if(r instanceof RealResult) {
					eres.setValue(eres.getValue() + ((RealResult)r).getValue());
				} else {
					throw new SBQLEvalException("SumOperator.eval - elementnie jest wartoscia liczbowa");
				}
			}
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			for(AbstractQueryResult r : structRes.getAtoms()) {
				r = Util.deref(r);
				if(r instanceof IntegerResult) {
					double value = ((IntegerResult)r).getValue().doubleValue();
					eres.setValue(eres.getValue() + value);
				} else if(r instanceof RealResult) {
					eres.setValue(eres.getValue() + ((RealResult)r).getValue());
				} else {
					throw new SBQLEvalException("SumOperator.eval - elementnie jest wartoscia liczbowa");
				}
			}
		} else {
			if(res instanceof IntegerResult) {
				double value = ((IntegerResult)res).getValue().doubleValue();
				eres.setValue(value);
			} else if(res instanceof RealResult) {
				eres.setValue(((RealResult)res).getValue());
			//throw new SBQLEvalException("SumOperator.eval - elementy do sumowania nie sa kolekcja");
			}
		}	
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitSumExpression(this);
	}

}
