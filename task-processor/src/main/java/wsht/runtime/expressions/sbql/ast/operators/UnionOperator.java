package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
	� union � suma zbiorow.
	Ewaluacja: 
	1. Zainicjalizuj pusty bag (bedziemy odnosic sie do niego jaki eres). 
	2. Wykonaj oba podwyrazenia. 
	3. Podnies dwa elementy z QRES.
	4. Dodaj wszystkie elementy z obu rezultatow do eres. 
	5. Umiesc eres na QRES.
 */
public class UnionOperator extends BinaryExpression implements IOperator {

	public UnionOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		BagResult eres = new BagResult();
		AbstractQueryResult e2 = QRES.getInstance().pop(false);
		AbstractQueryResult e1 = QRES.getInstance().pop(false);
		eres.add(e1);
		eres.add(e2);
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitUnionExpression(this);
	}

}
