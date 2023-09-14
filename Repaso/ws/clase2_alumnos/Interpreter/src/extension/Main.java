package extension;

import java.io.IOException;
import java.util.List;

import extension.interpreter.Instruction;
import extension.interpreter.Interpreter;
import extension.interpreter.Parser;

public class Main {


	public static void main(String[] args) throws IOException {
		Parser parser = new Parser();
		List<Instruction> instructions = parser.loadFile("fibonacci.txt");
		Interpreter interpreter = new Interpreter(instructions);
		interpreter.run();
	}
}
