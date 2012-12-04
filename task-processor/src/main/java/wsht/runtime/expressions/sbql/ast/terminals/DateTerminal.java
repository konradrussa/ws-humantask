package wsht.runtime.expressions.sbql.ast.terminals;

import java.util.Date;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public class DateTerminal extends TerminalExpression {

	private Date value;
	
	public DateTerminal(Date value) {
		this.value = value;
	}

	public Date getValue() {
		return value;
	}

	public void accept(ASTVisitor visitor) {
		visitor.visitDateTerminal(this);
	}
	
	
}

