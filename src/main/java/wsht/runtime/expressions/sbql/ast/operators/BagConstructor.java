package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
	� bag, sequence � konstruktory bagow i sekwencji.
	Ewaluacja: 
	1. Zainiacjalizuj pusty bag (bedziemy odnosic sie do niego jako
		eres). 
	2. Wykonaj podzapytanie. 
	3. Podnies wynik z QRES. 
	4. Potraktuj go jako strukture. Kazde pole tej struktury dodaj do eres. 
	5. Umiesc eres na QRES.
 */
public class BagConstructor extends UnaryExpression implements IOperator {
	
	public BagConstructor(Expression expression) {
		super.setInnerExpression(expression);
	}

	public void eval() {
		BagResult eres = new BagResult();
		AbstractQueryResult res = QRES.getInstance().pop(false);
		eres.add(res);
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitBagExpression(this);
	}
}
