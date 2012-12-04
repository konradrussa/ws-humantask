package wsht.runtime.expressions.sbql.ast.terminals;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class StringTerminal extends TerminalExpression {

	private String value;

	public StringTerminal(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitStringTerminal(this);
	}
	
	
}
