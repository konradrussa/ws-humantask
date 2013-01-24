package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
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
public class EqualsOperator extends BinaryExpression implements IOperator {

	public EqualsOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		AbstractQueryResult right = QRES.getInstance().pop(false);
		AbstractQueryResult left = QRES.getInstance().pop(false);
		right = SBQLUtil.deref(right);
		left = SBQLUtil.deref(left);
		AbstractQueryResult result = null;
		
		if (right instanceof StringResult && left instanceof StringResult) {
			StringResult r = (StringResult) right;
			StringResult l = (StringResult) left;
			result = new BooleanResult(r.getValue().equals(l.getValue()));
		} else if (right instanceof IntegerResult && left instanceof IntegerResult) {
			IntegerResult r = (IntegerResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new BooleanResult(r.getValue().equals(l.getValue()));
		} else if (right instanceof RealResult && left instanceof RealResult) {
			RealResult r = (RealResult) right;
			RealResult l = (RealResult) left;
			result = new BooleanResult(r.getValue().equals(l.getValue()));
		} else if (right instanceof BooleanResult && left instanceof BooleanResult) {
			BooleanResult r = (BooleanResult) right;
			BooleanResult l = (BooleanResult) left;
			result = new BooleanResult(r.isValue() == l.isValue());
		} else if (right instanceof IntegerResult && left instanceof BooleanResult) {
			IntegerResult r = (IntegerResult) right;
			BooleanResult l = (BooleanResult) left;
			result = new BooleanResult((r.getValue() == 1) == l.isValue());
		} else if (right instanceof BooleanResult && left instanceof IntegerResult) {
			BooleanResult r = (BooleanResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new BooleanResult(r.isValue() == (l.getValue() == 1));
		} else if (right instanceof StringResult && left instanceof IntegerResult) {
			StringResult r = (StringResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new BooleanResult(r.getValue().matches("\\d+") == (l.getValue() == 1));
		} else if (right instanceof IntegerResult && left instanceof StringResult) {
			IntegerResult r = (IntegerResult) right;
			StringResult l = (StringResult) left;
			result = new BooleanResult((r.getValue() == 1) == l.getValue().matches("\\d+[.\\d+]?"));
		} else if (right instanceof StringResult && left instanceof RealResult) {
			StringResult r = (StringResult) right;
			RealResult l = (RealResult) left;
			result = new BooleanResult(r.getValue().matches("\\d+") == (l.getValue() == 1));
		} else if (right instanceof RealResult && left instanceof StringResult) {
			RealResult r = (RealResult) right;
			StringResult l = (StringResult) left;
			result = new BooleanResult((r.getValue() == 1) == l.getValue().matches("\\d+[.\\d+]?"));
		} else if (right instanceof IntegerResult && left instanceof RealResult) {
			IntegerResult r = (IntegerResult) right;
			RealResult l = (RealResult) left;
			result = new BooleanResult(r.getValue().doubleValue() == l.getValue().doubleValue());
		} else if (right instanceof RealResult && left instanceof IntegerResult) {
			RealResult r = (RealResult) right;
			IntegerResult l = (IntegerResult) left;
			result = new BooleanResult(r.getValue().doubleValue() == l.getValue().doubleValue());
		} else {
			//FIXME
			//throw new SBQLEvalException("EqualsOperator.eval: blad typu");
			System.err.println("EqualsOperator.eval: blad typu");
		}
		QRES.getInstance().push(result);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitEqualsExpression(this);
	}

}
