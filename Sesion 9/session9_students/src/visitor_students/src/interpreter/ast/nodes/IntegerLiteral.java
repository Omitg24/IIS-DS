package interpreter.ast.nodes;

public class IntegerLiteral implements Expression 
{
	public String value;

	public IntegerLiteral(String value) 
	{
		this.value = value;
	}
}
