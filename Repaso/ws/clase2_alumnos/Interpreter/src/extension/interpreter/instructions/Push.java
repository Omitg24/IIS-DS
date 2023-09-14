package extension.interpreter.instructions;

import extension.interpreter.Memory;

public class Push extends AbstractInstruction {

	private int value;

	public Push(int value) {
		this.value = value;
	}

	@Override
	protected void executeInstruction(Memory memory) {
		memory.push(value);
	}
}
