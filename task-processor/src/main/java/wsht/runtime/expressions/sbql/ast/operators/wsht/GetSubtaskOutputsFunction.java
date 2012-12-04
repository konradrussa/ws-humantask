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
 * Returns a node-set of simple-typed or complex-typed elements, 
 * constructed from the sub tasks‟ output documents in a routing pattern. 
 * The string parameter contains a location path evaluated on each sub task‟s output document. 
 * The individual node-sets are combined into the returned node-set. 
 * Only completed sub tasks of the current task MUST be considered
In
 part name
 location path
Out
 node-set of output message elements from sub tasks
 */
public class GetSubtaskOutputsFunction extends WSHTOperator implements IOperator {

	private String partName;
	private String locationPath;
	
	public GetSubtaskOutputsFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	

	public void eval() {
		
		//TODO: implement GetSubtaskOutputsFunction eval
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 3) 
				throw new SBQLEvalException("GetSubtaskOutputsFunction.eval - element nie jest wartoscia struct 2 elementowa");
		} else {
			throw new SBQLEvalException("GetSubtaskOutputsFunction.eval - parametr procent niewlasciwy");
		}
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitGetSubtaskOutputs(this);		
	}

}