package wsht.runtime.expressions.sbql.ast.terminals;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class DoubleTerminal extends TerminalExpression {

	private Double value;
	
	public DoubleTerminal(double value) {
		this.value = value;
	}

	public Double getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitDoubleTerminal(this);
	}
	
	
}
