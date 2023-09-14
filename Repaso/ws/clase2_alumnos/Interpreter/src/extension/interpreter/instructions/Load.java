package extension.interpreter.instructions;

import extension.interpreter.Memory;

public class Load extends AbstractInstruction {

	@Override
	protected void executeInstruction(Memory memory) {
		int address = memory.pop();
		memory.push(memory.getMemory(address));
	}
}
