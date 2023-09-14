package interpreter.ast.nodes;

public class Variable implements Expression 
{
	public String name;

	public Variable(String name) 
	{
		this.name = name;
	}
}
