package extension.interpreter.instructions;

import extension.interpreter.Memory;

public class Sub extends AbstractInstruction {

	@Override
	protected void executeInstruction(Memory memory) {
		int a = memory.pop();
		int b = memory.pop();
		memory.push(a - b);
	}

}
