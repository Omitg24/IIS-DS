package extension.interpreter.instructions;

import extension.interpreter.Memory;

public class Store extends AbstractInstruction {

	@Override
	protected void executeInstruction(Memory memory) {
		int value = memory.pop();
		int address = memory.pop();
		memory.updateMemory(address, value);
	}
}
