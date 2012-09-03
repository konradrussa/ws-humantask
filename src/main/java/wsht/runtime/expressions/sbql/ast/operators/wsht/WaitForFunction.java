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
The parameter is an XPath expression evaluating to a string conforming to the definition 
 of the XML Schema type duration
o The return value is true after the specified duration has elapsed, otherwise false

boolean htd:waitFor(string)
 */

public class WaitForFunction extends WSHTOperator implements IOperator {

	private String time;
	
	public WaitForFunction(Expression expression) {
		super.setInnerExpression(expression);
	}
	
	@Override
	public void eval() {
		
		//TODO: implement WaitForFunction eval
		AbstractQueryResult res = QRES.getInstance().pop(false);
		if(res instanceof StructResult) {
			StructResult term = (StructResult) res;
			if(term.getElements().size() != 1 || term.getElements().size() != 2) 
				throw new SBQLEvalException("WaitForFunction.eval - element nie jest wartoscia struct 1 lub 2 elementowa");
		}
	}

	@Override
	public void accept(ASTVisitor visitor) {
		visitor.visitWaitFor(this);		
	}

}