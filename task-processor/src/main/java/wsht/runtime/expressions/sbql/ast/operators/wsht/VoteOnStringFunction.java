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
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.Util;

/*
Returns the most frequently occurring string value if its occurrence is above 
the specified percentage and there is no tie, or an empty string otherwise 
(including an empty node-set)
In
 node-set of string nodes
 percentage
 */
public class VoteOnStringFunction extends UnaryExpression implements IOperator {

	private Float percentage;
	
	public VoteOnStringFunction(Expression expression) {
		super.setInnerExpression(expression);
		
	}
	
	public void eval() {
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("VoteOnStringFunction.eval - element nie jest wartoscia struct 2 elementowa");
			if(!(term.getElements().get(1) instanceof RealResult)) {
				throw new SBQLEvalException("VoteOnStringFunction.eval - parametr procent niewlasciwy");
			}
		} else {
			throw new SBQLEvalException("VoteOnStringFunction.eval - parametr procent niewlasciwy");
		}
		
		this.percentage = ((RealResult)term.getElements().get(1)).getValue().floatValue();
		
		if(percentage == null || percentage > 100) {
			throw new SBQLEvalException("VoteOnStringFunction.eval - parametr procent niewlasciwy");
		}
		StringResult eres = new StringResult();
		List<String> stringList = new ArrayList<String>();
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			for(AbstractQueryResult r : bagRes.getElements()) {
				r = Util.deref(r);
				if(r instanceof StringResult) {
					
				} else {
					throw new SBQLEvalException("VoteOnStringFunction.eval - element nie jest wartoscia string");
				}
			}
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			for(AbstractQueryResult r : structRes.getAtoms()) {
				r = Util.deref(r);
				if(r instanceof StringResult) {
					
				} else {
					throw new SBQLEvalException("VoteOnStringFunction.eval - element nie jest wartoscia string");
				}
			}
		} else {
			throw new SBQLEvalException("VoteOnStringFunction.eval - powinien byc node-set");
		}
		
		String A[] = stringList.toArray(new String[0]);
		int dominator = OperatorUtils.dominator(A);
		if(dominator != -1 && OperatorUtils.isMajority(A, A[dominator], percentage)) {
			eres.setValue(A[dominator]);
		} else {
			eres.setValue("");
		}
		
		QRES.getInstance().push(eres);
		
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitVoteOnString(this);		
	}

}