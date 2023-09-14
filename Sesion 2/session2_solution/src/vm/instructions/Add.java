package vm.instructions;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Add extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		context.push(context.pop() + context.pop());
	}
	
	@Override
	public String toString()
	{
		return "ADD";
	}
}
