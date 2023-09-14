package vm;

public interface Instruction 
{
	public void execute(Context context) throws ProgramException;
}
