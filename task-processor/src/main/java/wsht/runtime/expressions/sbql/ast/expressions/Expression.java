package wsht.runtime.expressions.sbql.ast.expressions;

import wsht.runtime.expressions.sbql.ast.expressions.visitor.ASTVisitor;

public interface Expression {
	
	public void accept(ASTVisitor visitor);

}
