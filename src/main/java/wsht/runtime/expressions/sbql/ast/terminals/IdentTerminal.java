package wsht.runtime.expressions.sbql.ast.terminals;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class IdentTerminal extends TerminalExpression {

	private String value;

	public IdentTerminal(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitIdentTerminal(this);
	}
	
	
}