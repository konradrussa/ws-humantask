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
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.Util;

/*
Returns the most frequently occurring string value within all string nodes, or an empty string in case of a tie or for an empty node-set
In
 node-set of string nodes
 */
public class MostFrequentOccurenceFunction extends UnaryExpression implements IOperator {

	
	public MostFrequentOccurenceFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		StringResult eres = new StringResult();
		List<String> stringList = new ArrayList<String>();
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof BagResult) {
			BagResult bagRes = (BagResult) res;
			for(AbstractQueryResult r : bagRes.getElements()) {
				r = Util.deref(r);
				if(r instanceof StringResult) {
					
				} else {
					throw new SBQLEvalException("MostFrequentOccurenceFunction.eval - element nie jest wartoscia string");
				}
			}
		} else if(res instanceof StructResult) {
			StructResult structRes = (StructResult) res;
			for(AbstractQueryResult r : structRes.getAtoms()) {
				r = Util.deref(r);
				if(r instanceof StringResult) {
					
				} else {
					throw new SBQLEvalException("MostFrequentOccurenceFunction.eval - element nie jest wartoscia string");
				}
			}
		} else {
			throw new SBQLEvalException("MostFrequentOccurenceFunction.eval - powinien byc node-set");
		}
		
		String A[] = stringList.toArray(new String[0]);
		eres.setValue(OperatorUtils.occurence(A, true));
		
		QRES.getInstance().push(eres);
		
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitMostFrequentOccurence(this);		
	}

}
