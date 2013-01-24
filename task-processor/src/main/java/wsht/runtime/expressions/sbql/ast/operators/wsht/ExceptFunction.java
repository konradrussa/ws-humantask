package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.runtime.expressions.sbql.ast.expressions.BinaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.IntegerResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.util.SBQLUtil;

/*
 * Constructs an organizationalEntity containing every user that occurs in set1 but not in set2.
Note: This function is required to allow enforcing the separation of duties (“4-eyes principle”).
In
 set1 (htt:organizationalEntity |htt:user)
 set2 (htt:organizationalEntity |htt:user)
Out
 result (htt:organizationalEntity)
 */
public class ExceptFunction extends BinaryExpression implements IOperator {

	public ExceptFunction(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	public void eval() {
		BagResult eres = new BagResult();
		AbstractQueryResult e2 = QRES.getInstance().pop(false);
		AbstractQueryResult e1 = QRES.getInstance().pop(false);
		
		BagResult bagRes1;
		BagResult bagRes2;
		if(!BagResult.class.isInstance(e1)) //throw new SBQLEvalException("IntersectOperator.eval - e1 nie jest bagiem");
		{	bagRes1 = new BagResult();
			bagRes1.add(e1);
		}
		else
			bagRes1 = (BagResult)e1;
		
		if(!BagResult.class.isInstance(e2)) //throw new SBQLEvalException("IntersectOperator.eval - e2 nie jest bagiem");
		{	bagRes2 = new BagResult();
			bagRes2.add(e2);
		}
		else
			bagRes2 = (BagResult)e2;
		
		for(AbstractQueryResult r1: bagRes1.getElements()) {
			r1 = SBQLUtil.deref(r1);
			boolean checker = false;
			for(AbstractQueryResult r2: bagRes2.getElements()) {
				r2 = SBQLUtil.deref(r2);
				if(checkValue(r1,r2)) 
					checker = true;
			}
			if(!checker) eres.add(r1);
		}
		
		for(AbstractQueryResult r2: bagRes2.getElements()) {
			r2 = SBQLUtil.deref(r2);
			boolean checker = false;
			for(AbstractQueryResult r1: bagRes1.getElements()) {
				r1 = SBQLUtil.deref(r1);
				if(checkValue(r1,r2)) 
					checker = true;
			}
			if(!checker) eres.add(r2);
		}

		QRES.getInstance().push(eres);
	}
	
	private boolean checkValue(AbstractQueryResult r1, AbstractQueryResult r2) {
		if(r1 instanceof IntegerResult && r2 instanceof IntegerResult) {
			IntegerResult rr1 = (IntegerResult) r1;
			IntegerResult rr2 = (IntegerResult) r2;
			return rr1.getValue() != rr2.getValue();
		} else if(r1 instanceof RealResult && r2 instanceof RealResult) {
			RealResult rr1 = (RealResult) r1;
			RealResult rr2 = (RealResult) r2;
			return rr1.getValue() != rr2.getValue();
		} else if(r1 instanceof StringResult && r2 instanceof StringResult) {
			StringResult rr1 = (StringResult) r1;
			StringResult rr2 = (StringResult) r2;
			return !rr1.getValue().equals(rr2.getValue());
		} else if(r1 instanceof BooleanResult && r2 instanceof BooleanResult) {
			BooleanResult rr1 = (BooleanResult) r1;
			BooleanResult rr2 = (BooleanResult) r2;
			return rr1.isValue() != rr2.isValue();
		}
		return false;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitExcept(this);
		
	}

}

/*intersect
Constructs an organizationalEntity containing every user that occurs in both set1 and set2, eliminating duplicate users.
In
 set1 (htt:organizationalEntity |htt:user)
 set2 (htt:organizationalEntity |htt:user)
Out
 result (htt:organizationalEntity)
*/
