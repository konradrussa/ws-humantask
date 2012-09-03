package wsht.runtime.expressions.sbql.ast.operators.wsht;

import java.util.ArrayList;
import java.util.List;

import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.utils.OperatorUtils;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.Util;

/*
Returns the most frequently occurring boolean value if its occurrence 
is above the specified percentage, or false otherwise (including an empty node-set)
In
 node-set of boolean nodes
 percentage
 */

public class VoteFunction extends UnaryExpression implements IOperator {

	private Float percentage;
	
	public VoteFunction(Expression expression) {
		super.setInnerExpression(expression);
		
	}
	
	@Override
	public void eval() {
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("VoteFunction.eval - element nie jest wartoscia struct 2 elementowa");
			if(!(term.getElements().get(1) instanceof RealResult)) {
				throw new SBQLEvalException("VoteFunction.eval - parametr procent niewlasciwy");
			}
		} else {
			throw new SBQLEvalException("VoteFunction.eval - parametr procent niewlasciwy");
		}
		
		this.percentage = ((RealResult)term.getElements().get(1)).getValue().floatValue();
		if(percentage == null || percentage > 100) {
			throw new SBQLEvalException("VoteFunction.eval - parametr procent niewlasciwy");
		}
		BooleanResult eres = new BooleanResult();
		List<Boolean> boolList = new ArrayList<Boolean>();
		AbstractQueryResult res = term.getElements().get(0);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			for(AbstractQueryResult r : bagRes.getElements()) {
				r = Util.deref(r);
				if(r instanceof BooleanResult) {
					boolList.add(((BooleanResult) r).isValue());
				} else {
					throw new SBQLEvalException("VoteFunction.eval - element nie jest wartoscia bool");
				}
			}
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			for(AbstractQueryResult r : structRes.getAtoms()) {
				r = Util.deref(r);
				if(r instanceof BooleanResult) {
					boolList.add(((BooleanResult) r).isValue());
				} else {
					throw new SBQLEvalException("VoteFunction.eval - element nie jest wartoscia bool");
				}
			}
		}  else {
			throw new SBQLEvalException("VoteFunction.eval - powinien byc node-set");
		}
		
		Boolean A[] = boolList.toArray(new Boolean[0]);
		int dominator = OperatorUtils.dominator(A);
		boolean majority = false;
		if(dominator != -1 && (majority = OperatorUtils.isMajority(A, A[dominator], percentage))) {
			eres.setValue(majority);
		} else {
			eres.setValue(majority);
		}
		
		QRES.getInstance().push(eres);
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitVote(this);		
	}

}
