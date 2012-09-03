package wsht.runtime.expressions.sbql.ast.expressions;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*	
� . (kropka) � projekcja/nawigacja (niealgebraiczny).
Ewaluacja: 
	1. Zainicjalizuj pusty bag (bedziemy sie do niego odnosic jako eres). 
	2. Wykonaj lewe podzapytanie. 
	3. Podnies jego rezultat ze stosu QRES. 
	4. Dla kazdego elementu e z rezultatu otrzymanego w poprzednim
	   kroku wykonaj: 
		4.1. Otworz nowa sekcja na ENVS. 
		4.2. Wykonaj operacje nested(e). 
		4.3. Wykonaj prawe podzapytanie. 
		4.4 Podnies jego rezultat z QRES. 
		4.5. Dodaj go do eres. 
	5. Poloz eres na QRES.
*/
public class DotExpression extends BinaryExpression {
	
	public DotExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitDotExpression(this);
	}

}
