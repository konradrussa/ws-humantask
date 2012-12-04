package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
� forany � kwantyfikator szczegolowy (niealgebraiczny).
	Ewaluacja: podobnie jak w . (kropka). 
	4.5. Jesli rezultatem prawego wyrazenia
		nie jest pojedyncza wartosc logiczna, podnires blad czasu wykonania.
	4.6. Jesli rezultatem prawego wyrazenia jest true, umiesc true na QRES
		i przerwij ewaluacje operatora.
 */

public class AnyOperator extends BinaryExpression {

	public AnyOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitAnyExpression(this);
	}

}