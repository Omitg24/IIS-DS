package extension.interpreter.instructions;

import java.util.Scanner;

import extension.interpreter.Memory;

public class Input extends AbstractInstruction {

	@Override
	protected void executeInstruction(Memory memory) {
		System.out.print("Escriba un entero: ");
		memory.push(readValue());
	}

	@SuppressWarnings("resource")
	private int readValue()
	{
		return new Scanner(System.in).nextInt();
	}

}
