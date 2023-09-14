package extension.interpreter.instructions;

import extension.interpreter.Memory;

public class Output extends AbstractInstruction {

	@Override
	protected void executeInstruction(Memory memory) {
		System.out.println(memory.pop());
	}
}
