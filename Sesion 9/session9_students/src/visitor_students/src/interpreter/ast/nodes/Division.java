package interpreter.ast.nodes;

public class Division implements Expression {
	public Expression left, right;

	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

}
