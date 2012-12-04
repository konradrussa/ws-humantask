package wsht.runtime.expressions.sbql.ast.terminals;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class LongTerminal extends TerminalExpression {

	private Long value;
	
	public LongTerminal(long value) {
		this.value = value;
	}

	public Long getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitLongTerminal(this);
	}
	
	
}

