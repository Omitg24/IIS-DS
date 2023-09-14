package interpreter.ast.nodes;

import interpreter.Visitor;

public class Read implements Statement
{
	public Variable variable;

	public Read(Variable variable)
	{
		this.variable = variable;
	}

	@Override
	public Object accept(Visitor v, Object o) {
		return v.visit(this, o);
	}
}
