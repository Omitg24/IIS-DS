package interpreter.ast.nodes;

public class Sum implements Expression 
{
	public Expression left, right;

	public Sum(Expression left, Expression right) 
	{
		this.left = left;
		this.right = right;
	}
}
