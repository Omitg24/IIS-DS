package extension.interpreter.instructions;

import extension.interpreter.Instruction;
import extension.interpreter.Memory;

public class Jmpg implements Instruction {

	private int value;

	public Jmpg(int value) {
		this.value = value;
	}

	@Override
	public void execute(Memory memory) {
		int b = memory.pop();
		int a = memory.pop();
		if (a > b) {
			memory.jumpTo(value);
		} else {
			memory.incrementIp();
		}
	}

}
