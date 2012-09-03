package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
� , (przecinek) � iloczyn kartezjanski.
Ewaluacja: 
1. Zainicjalizuj pusty bag (bedziemy odnosic sie do niego jako eres). 
2. Wykonaj oba podwyrazenia. 
3 Podnies jeden element z QRES (bedziemy odnosic sie do niego jako e2res). 
4. Podnies jeden element z QRES (bedziemy odnosic sie do niego jako e1res). 
5. Dla kazdego elementu e1 z e1res wykonaj: 
	5.1 Dla kazdego elementu e2 z e2res wykonaj: 
		5.1.1 utworz struct { e1, e2 }. Jesli e1 i/lub e2 jest struktura, wez jej pola. 
		5.1.2 Dodaj strukture do eres. 
6. Umiesc eres na QRES.
*/
public class CommaOperator extends BinaryExpression implements IOperator {

	public CommaOperator(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		BagResult eres = new BagResult();
		AbstractQueryResult e2res = QRES.getInstance().pop(false);
		AbstractQueryResult e1res = QRES.getInstance().pop(false);

		if(e1res instanceof BagResult) {
			BagResult e1bag = (BagResult) e1res;
			for(AbstractQueryResult e1 : e1bag.getElements()) {
				if(e2res instanceof BagResult) {
					BagResult e2bag = (BagResult) e2res;
					for(AbstractQueryResult e2 : e2bag.getElements()) {
						StructResult struct = new StructResult();
						struct.add(e1);
						struct.add(e2);
						eres.add(struct);
					}
				} else {
					StructResult struct = new StructResult();
					struct.add(e1res);
					struct.add(e2res);
					eres.add(struct);
					break;
				}
			}
		} else {
			StructResult struct = new StructResult();
			struct.add(e1res);
			struct.add(e2res);
			eres.add(struct);
		}
		QRES.getInstance().push(eres);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitCommaExpression(this);
	}

}

