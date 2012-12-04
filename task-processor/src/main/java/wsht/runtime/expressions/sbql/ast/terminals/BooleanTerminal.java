package wsht.runtime.expressions.sbql.ast.terminals;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class BooleanTerminal extends TerminalExpression {

	private Boolean value;
	
	public BooleanTerminal(Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {	
		visitor.visitBooleanTerminal(this);
	}
	
	
}
