package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Título: Clase Store
 * 
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Store implements Instruction {

	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		int value = state.pop();
		int address = state.pop();
		state.writeMemory(address, value);
		state.setIp(state.getIp() + 1);
	}
}
