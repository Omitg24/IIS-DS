package vm.instructions;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Load extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		int address = context.pop();
		context.push(context.read(address));
	}
	
	@Override
	public String toString()
	{
		return "LOAD";
	}	
}
