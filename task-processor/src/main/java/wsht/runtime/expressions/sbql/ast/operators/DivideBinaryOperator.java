package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.util.SBQLUtil;
import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
� +, -, *, /, =, <>, <, >, <=, >=, or, and � tradycyjne binarne operatory
			arytmetyczne, logiczne i porownania.
Ewaluacja: 
1. Wykonaj oba podzapytania. 
2. Podnies dwa elementy z QRES.
3. Sprawdz czy sa to pojedyncze wartosci. Jesli nie, podnies blad czasu wykonania.
4. Jesli ktorykolwiek z rezultatow jest referencja, wykonaj dereferencje.
5. Sprawdz typy danych obu razultatow. Jesli operator nie moze byc
   zastosowany do takich wartosci, podnies blad czasu wykonania. 
6. Wykonaj operacje zwiazana z operatorem.
7. Umiesc rezultat na QRES.
*/
public class DivideBinaryOperator extends BinaryExpression implements IOperator {

	public DivideBinaryOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		AbstractQueryResult right = QRES.getInstance().pop(false);
		AbstractQueryResult left = QRES.getInstance().pop(false);
		right = SBQLUtil.deref(right);
		left = SBQLUtil.deref(left);
		AbstractQueryResult result = null;
		
		if (right instanceof IntegerResult && left instanceof IntegerResult) {
			IntegerResult r = (IntegerResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new RealResult(l.getValue().doubleValue() / r.getValue().doubleValue());
		} else if (right instanceof RealResult && left instanceof RealResult) {
			RealResult r = (RealResult) right;
			RealResult l = (RealResult) left;
			result = new RealResult(l.getValue() / r.getValue());
		} else if (right instanceof IntegerResult && left instanceof RealResult) {
			IntegerResult r = (IntegerResult) right;
			RealResult l = (RealResult) left;
			result = new RealResult(l.getValue() / r.getValue());
		} else if (right instanceof RealResult && left instanceof IntegerResult) {
			RealResult r = (RealResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new RealResult(l.getValue() / r.getValue());
		} else {
			throw new SBQLEvalException("PlusBinaryOperator.eval: blad typu");
		}
		QRES.getInstance().push(result);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitDivideBinaryExpression(this);
	}
}
