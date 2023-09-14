package vm.instructions;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Store extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		int value = context.pop();
		int address = context.pop();
		context.write(address, value);
	}
	
	@Override
	public String toString()
	{
		return "STORE";
	}	
}
