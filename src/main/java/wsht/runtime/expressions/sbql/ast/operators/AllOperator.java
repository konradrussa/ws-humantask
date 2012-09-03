package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
	� forall � kwantyfikator ogolny (niealgebraiczny).
	Ewaluacja: podobnie jak w . (kropka). 
	4.5. Jesli rezultat prawego wyrazenia
		nie jest pojedyncza wartoscia logiczna, podnies blad czasu wykonania.
	4.6. Jesli rezultat prawego wyrazenia jest false, umiesc wartosc false na QRES
		i przerwij ewaluacje operatora.
 */
public class AllOperator extends BinaryExpression {

	public AllOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitAllExpression(this);
	}

}
