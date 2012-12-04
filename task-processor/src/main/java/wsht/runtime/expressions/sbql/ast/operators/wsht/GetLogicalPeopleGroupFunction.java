package wsht.runtime.expressions.sbql.ast.operators.wsht;

import java.util.Map;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.utils.ApplicationContextProvider;

/*
 * Returns the value of a logical people group. In case of an error 
 * (e.g., when referencing a non existing logical people group) 
 * the htt:organizationalEntity MUST contain an empty user list.
If the task name is not present the current task MUST be considered.
In
 name of the logical people group
 The optional parameters that follow MUST appear in pairs. Each pair is defined as:
o the qualified name of a logical people group parameter
o the value for the named logical people group parameter; it can be an XPath expression
Out
 the value of the logical people group (htt:organizationalEntity)
 */
public class GetLogicalPeopleGroupFunction extends WSHTOperator implements IOperator {
	
	public GetLogicalPeopleGroupFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	public void eval() {
		
		
		//TODO: implement GetLogicalPeopleGroupFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 1 || term.getElements().size() != 2) 
				throw new SBQLEvalException("GetLogicalPeopleGroupFunction.eval - element nie jest wartoscia struct 1 lub 2 elementowa");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetLogicalPeopleGroup(this);		
	}

}