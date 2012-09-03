package wsht.runtime.expressions.sbql.ast.operators.wsht;

import java.util.List;

import wsht.infrastructure.service.IRepositoryService;
import wsht.runtime.expressions.sbql.ast.expressions.Expression;
import wsht.runtime.expressions.sbql.ast.expressions.UnaryExpression;
import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.operators.IOperator;
import wsht.runtime.expressions.sbql.ast.operators.wsht.ext.WSHTOperator;
import wsht.runtime.expressions.sbql.envs.ENVS;
import wsht.runtime.expressions.sbql.envs.ENVSBinder;
import wsht.runtime.expressions.sbql.qres.QRES;
import wsht.runtime.expressions.sbql.qres.exception.SBQLEvalException;
import wsht.runtime.expressions.sbql.qres.result.AbstractQueryResult;
import wsht.runtime.expressions.sbql.qres.result.BagResult;
import wsht.runtime.expressions.sbql.qres.result.BooleanResult;
import wsht.runtime.expressions.sbql.qres.result.StringResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.expressions.sbql.util.Util;
import wsht.runtime.utils.ApplicationContextProvider;

/*
 * Returns the part of the task‟s input message.
If the task name is not present the current task MUST be considered.
In
 part name
 task name (optional)
Out
 input message part
 */
public class GetInputFunction extends WSHTOperator implements IOperator {

	
	public GetInputFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		//TODO: implement GetInputFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		
		if(res instanceof StringResult) {
			BagResult resOut = ENVS.getInstance().bind(((StringResult) res).getValue());
			QRES.getInstance().push(resOut);
		} else if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("GetInputFunction.eval - element nie jest wartoscia struct 2 elementowa");
			
			for(AbstractQueryResult r : ((StructResult)term).getAtoms()) {
				
			}
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitGetInput(this);		
	}

}