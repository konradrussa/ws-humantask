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
� +, � tradycyjne, unarne operatory arytmetyczne.
	Ewaluacja: 
		1. Wykonaj podzapytanie. 
		2. Podnies element ze stosu QRES.
		3. Sprawdz czy jest to pojedynczy element. 
			Jesli nie, podnies wyjatek czasu wykonania. 
		4. Jesli wynik jest referencja, wykonaj dereferencje. 
		5. Sprawdz typ rezultatu. Jesli operator nie moze byc zastosowany dla takiej wartosci, podnies blad czasu wykonania. 
		6. Wykonaj operacje zwiazana z danym operatorem.
		7. Umiesc rezultat na QRES.
 */
public class PlusUnaryOperator extends UnaryExpression implements IOperator {

	public PlusUnaryOperator(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult || res instanceof StructResult) 
			throw new SBQLEvalException("PlusUnaryOperator.eval - nie jest pojedynczym elementem");
		
		res = Util.deref(res);
		
		if(res instanceof IntegerResult) {
		} else if (res instanceof RealResult) {
		} else {
			throw new SBQLEvalException("PlusUnaryOperator.eval - operator nie moze byc zastosowany");
		}
		QRES.getInstance().push(res);
		
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitPlusUnaryOperator(this);
	}

}
