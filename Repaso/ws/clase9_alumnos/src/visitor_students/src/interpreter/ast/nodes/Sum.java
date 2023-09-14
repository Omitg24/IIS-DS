package interpreter.ast.nodes;

import interpreter.Visitor;

public class Sum implements Expression
{
	public Expression left, right;

	public Sum(Expression left, Expression right)
	{
		this.left = left;
		this.right = right;
	}

	@Override
	public Object accept(Visitor v, Object o) {
		return v.visit(this, o);
	}
}
