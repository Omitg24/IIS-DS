package vm.parser;

public class ParserException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ParserException(String message)
	{
		super(message);
	}
	
	public ParserException(int lineNumber, String line, String message)
	{
		super(String.format("Error de sintaxis en la línea %d (%s): %s", lineNumber, line, message));
	}
}
