package wsht.runtime.expressions.sbql.ast.operators.wsht;

import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.store.TaskInstance;

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
		
		
		AbstractQueryResult res = QRES.getInstance().pop(true);
		if(res == null) {
			BagResult resOut = ENVS.getInstance().bind(TaskInstance._F_logicalPeopleGroupsField);
			QRES.getInstance().push(resOut);
		} else if(res instanceof StringResult) {
			//BagResult resOut = ENVS.getInstance().bind(((StringResult) res).getValue());
			BagResult resOut = ENVS.getInstance().bind(TaskInstance._F_logicalPeopleGroupsField);
			QRES.getInstance().push(resOut);
		} else {
			throw new SBQLEvalException("GetLogicalPeopleGroupFunction.eval - nieobslugiwana ilosc agrumentow");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetLogicalPeopleGroup(this);		
	}

}