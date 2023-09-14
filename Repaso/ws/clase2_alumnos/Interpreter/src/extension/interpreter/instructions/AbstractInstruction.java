package extension.interpreter.instructions;

import extension.interpreter.Instruction;
import extension.interpreter.Memory;

public abstract class AbstractInstruction implements Instruction {

	@Override
	public void execute(Memory memory) {
		executeInstruction(memory);
		memory.incrementIp();
	}

	protected abstract void executeInstruction(Memory memory);
}
