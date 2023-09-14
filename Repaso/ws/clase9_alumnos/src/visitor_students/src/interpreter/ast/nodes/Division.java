package interpreter.ast.nodes;

import interpreter.Visitor;

public class Division implements Expression {
	public Expression left, right;

	public Division(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object o) {
		return v.visit(this, o);		 
	}

}
