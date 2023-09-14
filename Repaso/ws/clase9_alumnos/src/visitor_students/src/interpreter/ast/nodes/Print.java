package interpreter.ast.nodes;

import interpreter.Visitor;

public class Print implements Statement
{
	public Expression expression;

	public Print(Expression expression)
	{
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object o) {
		return v.visit(this, o);
	}
}
