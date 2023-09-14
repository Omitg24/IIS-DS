package extension.interpreter.instructions;

import extension.interpreter.Memory;

public class Mul extends AbstractInstruction {

	@Override
	protected void executeInstruction(Memory memory) {
		memory.push(memory.pop() * memory.pop());
	}

}
