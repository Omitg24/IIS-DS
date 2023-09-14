package extension.interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import extension.interpreter.instructions.Add;
import extension.interpreter.instructions.Input;
import extension.interpreter.instructions.Jmp;
import extension.interpreter.instructions.Jmpg;
import extension.interpreter.instructions.Load;
import extension.interpreter.instructions.Mul;
import extension.interpreter.instructions.Output;
import extension.interpreter.instructions.Push;
import extension.interpreter.instructions.Store;
import extension.interpreter.instructions.Sub;

public class Parser {

	private final boolean TRACE = false;

	private List<Instruction> instructions = new ArrayList<>();

	public List<Instruction> loadFile(String fileName) throws IOException {
		BufferedReader file = new BufferedReader(new FileReader(fileName));

		String line;
		while ((line = file.readLine()) != null)
			loadSentence(line);
		file.close();
		return instructions;
	}

	private void loadSentence(String line)
	{
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens) {
				System.out.println("*" + token + "*");
			}
		}
		loadInstruction(tokens);
	}

	private void loadInstruction(String[] tokens) {
		switch(tokens[0]) {
		case "push":
			instructions.add(new Push(Integer.parseInt(tokens[1])));
			break;
		case "add":
			instructions.add(new Add());
			break;
		case "sub":
			instructions.add(new Sub());
			break;
		case "mul":
			instructions.add(new Mul());
			break;
		case "jmp":
			instructions.add(new Jmp(Integer.parseInt(tokens[1])));
			break;
		case "jmpg":
			instructions.add(new Jmpg(Integer.parseInt(tokens[1])));
			break;
		case "load":
			instructions.add(new Load());
			break;
		case "store":
			instructions.add(new Store());
			break;
		case "input":
			instructions.add(new Input());
			break;
		case "output":
			instructions.add(new Output());
			break;
		}
	}
}
