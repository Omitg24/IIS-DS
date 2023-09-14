package interpreter.ast.nodes;

import interpreter.Visitor;

public class Assignment implements Statement
{
	public Variable variable;
	public Expression expression;

	public Assignment(Variable variable, Expression expression)
	{
		this.variable = variable;
		this.expression = expression;
	}

	@Override
	public Object accept(Visitor v, Object o) {
		return v.visit(this, o);
	}
}
