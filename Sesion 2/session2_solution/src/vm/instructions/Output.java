package vm.instructions;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Output extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		System.out.println(context.pop());
	}
	
	@Override
	public String toString()
	{
		return "OUTPUT";
	}	
}
