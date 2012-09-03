package wsht.runtime.expressions.sbql.ast.expressions;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;
import wsht.runtime.expressions.sbql.ast.terminals.IdentTerminal;
import wsht.runtime.expressions.sbql.ast.terminals.StringTerminal;


public class NameExpression extends UnaryExpression {

	private Expression name;
	
	public NameExpression(Expression name) {
		this.name = name;
		super.setInnerExpression(name);
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitNameExpression(this);	
	}
	
	//S/G
	public String getName() {
		return ((IdentTerminal)name).getValue();
	}

}
