package wsht.runtime.expressions.sbql.ast.expressions;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*	
� where � selekcja (niealgebraiczny).
Ewaluacja: podobnie jak w . (kropka). 
	4.5. Jesli wynik ewaluacji prawego wyrazenia nie 
	     jest pojedyncza wartoscia logiczna, podnies blad czasu wykonania.
    4.6. Jesli rezultat prawego podzapytania jest true, dodaj e do eres.	
*/

public class WhereExpression extends BinaryExpression {

	public WhereExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitWhereExpression(this);
	}

}
