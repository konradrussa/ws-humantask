package wsht.runtime.expressions.sbql.ast.operators;

import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BinderResult;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

/*
	� as � przypisanie nazwy pomocniczej elementom kolekcji.
	Ewaluacja: 
	1. Wykonaj podzapytanie. 
	2. Podnies rezultat z QRES. 
	3. Kazdy element otrzymanej kolekcji 
		zastap binderem o nazwie podanej jako parametr
		operatora i wartosci bedacej zastepowanym rezultatem. 
	4. Umiesc wynikowa kolekcje na QRES.
 */
public class AsOperator extends UnaryExpression implements IOperator {

	private String name;
	
	public AsOperator(Expression exp, String name) {
		super.setInnerExpression(exp);
		this.name = name;
	}

	public void eval() {
		AbstractQueryResult value = QRES.getInstance().pop(false);
		AbstractQueryResult result = null;
		
		if(value instanceof BagResult) {
			result = new BagResult();
			for(AbstractQueryResult r : ((BagResult)value).getElements()) {
				((BagResult)result).add(new BinderResult(r, name));
			}
		} else {
			result = new BinderResult(value, name);
		}
		QRES.getInstance().push(result);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitAsExpression(this);
	}

}
