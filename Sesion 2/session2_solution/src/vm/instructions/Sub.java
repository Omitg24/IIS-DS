package vm.instructions;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Sub extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		int b = context.pop();
		int a = context.pop();
		context.push(a - b);
	}

	@Override
	public String toString()
	{
		return "SUB";
	}
}
