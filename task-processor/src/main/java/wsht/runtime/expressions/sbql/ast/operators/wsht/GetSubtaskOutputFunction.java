package wsht.runtime.expressions.sbql.ast.operators.wsht;

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
 * Returns a node-set representing the specified part or contained elements 
 * of a sub task‟s output message. Only completed sub tasks of the current task MUST be considered
In
 sub task name
 part name
 location path
Out
 node-set of output message element(s)
 */
public class GetSubtaskOutputFunction extends WSHTOperator implements IOperator {
	
	private String subTaskName;
	private String partName;
	private String locationPath;
	
	public GetSubtaskOutputFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	
	public void eval() {
		
		//TODO: implement GetSubtaskOutputFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 4) 
				throw new SBQLEvalException("GetSubtaskOutputFunction.eval - element nie jest wartoscia struct 3 elementowa");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetSubtaskOutput(this);		
	}

}