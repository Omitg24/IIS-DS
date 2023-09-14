package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

public class IntegerLiteral implements Expression 
{
	public String value;

	public IntegerLiteral(String value) 
	{
		this.value = value;
	}

	@Override
	public Object accept(Visitor v, Object o) {
		return v.visit(this, o);
	}
}
