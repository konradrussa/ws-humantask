package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
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

/*
Returns the disjunction of all boolean nodes - returns false for an empty node-set
In
 node-set of boolean nodes
 */

public class OrOperator extends BinaryExpression implements IOperator {

	public OrOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		AbstractQueryResult right = QRES.getInstance().pop(false);
		AbstractQueryResult left = QRES.getInstance().pop(false);
		right = SBQLUtil.deref(right);
		left = SBQLUtil.deref(left);
		AbstractQueryResult result = null;
		
		 if (right instanceof BooleanResult && left instanceof BooleanResult) {
			 BooleanResult r = (BooleanResult) right;
			 BooleanResult l = (BooleanResult) left;
			 result = new BooleanResult(l.isValue() || r.isValue());
		} else if (right instanceof IntegerResult && left instanceof BooleanResult) {
			IntegerResult r = (IntegerResult) right;
			 BooleanResult l = (BooleanResult) left;
			 result = new BooleanResult(l.isValue() || (r.getValue() == 1));
		} else if (right instanceof BooleanResult && left instanceof IntegerResult) {
			 BooleanResult r = (BooleanResult) right;
			 IntegerResult l = (IntegerResult) left;
			 result = new BooleanResult((l.getValue() == 1) || r.isValue());
		} else {
			throw new SBQLEvalException("OrOperator.eval: blad typu");
		}
		QRES.getInstance().push(result);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitOrExpression(this);
	}
}

