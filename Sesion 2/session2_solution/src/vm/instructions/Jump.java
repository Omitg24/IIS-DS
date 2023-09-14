package vm.instructions;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Jump implements Instruction
{
	private int address;
	
	public Jump(int address)
	{
		this.address = address;
	}
	
	@Override
	public void execute(Context context) throws ProgramException 
	{
		context.setIp(address);
	}
	
	@Override
	public String toString()
	{
		return "JMP " + address;
	}
}
