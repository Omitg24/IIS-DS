package extension.interpreter.instructions;

import extension.interpreter.Instruction;
import extension.interpreter.Memory;

public class Jmp implements Instruction {

	private int value;

	public Jmp(int value) {
		this.value = value;
	}

	@Override
	public void execute(Memory memory) {
		memory.jumpTo(value);
	}
}
