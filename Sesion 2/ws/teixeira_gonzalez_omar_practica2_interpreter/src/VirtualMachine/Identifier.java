package VirtualMachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Instructions.*;

/**
 * Título: Clase Identifier
 * 
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Identifier {
	/**
	 * Constante TRACE
	 */
	private static final boolean TRACE = false;
	
	/**
	 * Atributo instructions
	 */
	private static List<Instruction> instructions = new ArrayList<>();	
		
	/**
	 * Método loadInstructionsFile
	 * @throws Exception, excepción
	 */
	public static List<Instruction> loadInstructionsFile(String instructionsFile){
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader(instructionsFile));
			String line;
			while ((line = file.readLine()) != null) {
				loadSentence(line);
			}
			file.close();
			return instructions;
		} catch (FileNotFoundException e) {
			System.out.println("Excepción capturada (FileNotFoundException)");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Excepción capturada (IOException)");
			e.printStackTrace();
		} 
		return instructions;
	}

	/**
	 * Método loadSentence
	 * @param line, linea
	 */
	private static void loadSentence(String line) 
	{
		if (line.trim().length() == 0)
			return;

		String[] tokens = line.split(" ");
		if (TRACE) {
			for (String token : tokens) {				
				System.out.println("*" + token + "*");
			}
		}
		instructions.add(Identifier.identifyInstruction(tokens));
	}
	
	/**
	 * Método identifyInstruction
	 * @param line, linea
	 * @return instruction, instrucción
	 */
	private static Instruction identifyInstruction(String[] line) {
		switch (line[0]) {
			case "push":
				return new Push(Integer.parseInt(line[1]));
			case "add":
				return new Add();
			case "sub":
				return new Sub();
			case "mul":
				return new Mul();
			case "jmp":
				return new Jmp(Integer.parseInt(line[1]));
			case "jmpg":
				return new Jmpg(Integer.parseInt(line[1]));
			case "load":
				return new Load();
			case "store":
				return new Store();
			case "input":
				return new Input();
			case "output":
				return new Output();
			default:
				return null;
		}
	}
}
