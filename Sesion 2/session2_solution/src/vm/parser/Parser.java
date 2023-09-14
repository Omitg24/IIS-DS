package vm.parser;

import vm.Instruction;
import vm.instructions.*;

import java.util.*;
import java.io.*;

public class Parser 
{
	private static final boolean TRACE = false;	
	
	public List<Instruction> parse(String filename) throws IOException, ParserException
	{
		List<Instruction> program = new ArrayList<>();
		BufferedReader file = new BufferedReader(new FileReader(filename));
		String line;
		int lineNumber = 0;
		while ((line = file.readLine()) != null) {
			lineNumber++;
			// salta la línea si está en blanco
			if (line.trim().length() == 0)
				continue;
			program.add(parseLine(lineNumber, line));
		}
		file.close();
		return program;
	}
	
	private Instruction parseLine(int lineNumber, String line) throws ParserException
	{
		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens)
				System.out.println("*" + token + "*");
		}
		
		String name = tokens[0].toUpperCase();
		
		if (name.equals("PUSH")) {
			try {
				int value = Integer.parseInt(tokens[1]);
				return new Push(value);
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				throw new ParserException(lineNumber, line, "La instrucción PUSH necesita como argumento el valor entero a almacenar en la pila");
			}			
		}

		if (name.equals("JMP") || name.equals("JMPG")) {
			try {
				int address = Integer.parseInt(tokens[1]);
				if (name.equals("JMP")) {
					return new Jump(address);
				} else if (name.equals("JMPG")) {
					return new JumpIfGreaterThan(address);
				}
			} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
				throw new ParserException(lineNumber, line, "La instrucción " + name + " necesita como argumento un valor entero con la dirección de memoria");
			}
		}
		
		if (name.equals("ADD")) {
			return new Add();
		} else if (name.equals("SUB")) {
			return new Sub();
		} else if (name.equals("MUL")) {
			return new Mul();
		} else if (name.equals("LOAD")) {
			return new Load();
		} else if (name.equals("STORE")) {
			return new Store();
		} else if (name.equals("INPUT")) {
			return new Input();
		} else if (name.equals("OUTPUT")) {
			return new Output();
		} else {
			throw new ParserException(lineNumber, line, "Instrucción desconocida: " + name);
		}
	}
}
