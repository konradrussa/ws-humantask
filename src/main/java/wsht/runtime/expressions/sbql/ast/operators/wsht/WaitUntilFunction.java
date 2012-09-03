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
import wsht.runtime.expressions.sbql.qres.result.RealResult;
import wsht.runtime.expressions.sbql.qres.result.StructResult;
import wsht.runtime.utils.ApplicationContextProvider;

/*
The parameter is an XPath expression evaluating to a string conforming to the definition
 of the XML Schema type dateTime
o The return value is true after the specified absolute time has passed, otherwise false.

boolean htd:waitUntil(string)
 */

public class WaitUntilFunction  extends WSHTOperator implements IOperator {

	private String dateTime;
	
	public WaitUntilFunction(Expression expression) {
		super.setInnerExpression(expression);
		
	}
	
	@Override
	public void eval() {
		
		StructResult term = null;
		AbstractQueryResult resF = QRES.getInstance().pop(false);
		if(resF instanceof StructResult) {
			term = (StructResult) resF;
			if(term.getElements().size() != 2) 
				throw new SBQLEvalException("WaitUntilFunction.eval - element nie jest wartoscia struct 2 elementowa");
		} else {
			throw new SBQLEvalException("WaitUntilFunction.eval - parametr procent niewlasciwy");
		}
		
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitWaitUntil(this);		
	}


}