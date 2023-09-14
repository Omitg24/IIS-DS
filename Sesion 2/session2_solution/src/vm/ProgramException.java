package vm;

public class ProgramException extends Exception
{
	private static final long serialVersionUID = 1L;

	public ProgramException(Instruction instruction, String message)
	{
		super("Se produjo un error de ejecución en " + instruction + ": " + message);
	}
}
