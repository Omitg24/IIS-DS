package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Título: Clase Output
 * 
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Output implements Instruction {

	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		System.out.println("El resultado es: " + state.pop());
		state.setIp(state.getIp() + 1);
	}
}
