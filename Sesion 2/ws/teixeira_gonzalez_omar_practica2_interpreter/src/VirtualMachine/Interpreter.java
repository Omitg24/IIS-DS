package VirtualMachine;

import java.util.*;

/**
 * Titulo: Clase Interpreter
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Interpreter 
{		
	/**
	 * Atributo state
	 */
	private static State state = new State();

	/**
	 * Método executeProgram
	 */
	public static void executeProgram(String instructionsFile) 
	{
		List<Instruction> instructions = Identifier.loadInstructionsFile(instructionsFile);
		while (state.getIp() < instructions.size()) {
			instructions.get(state.getIp()).execute(state);
		}
	}

	
}
