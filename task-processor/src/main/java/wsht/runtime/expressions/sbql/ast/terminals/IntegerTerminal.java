package wsht.runtime.expressions.sbql.ast.terminals;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class IntegerTerminal extends TerminalExpression {

	private Integer value;
	
	public IntegerTerminal(int value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitIntegerTerminal(this);
	}
	
	
}
