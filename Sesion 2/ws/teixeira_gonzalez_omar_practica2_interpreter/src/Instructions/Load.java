package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Titulo: Clase Load
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Load implements Instruction {
	
	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		int address = state.pop();
		state.push(state.readMemory(address));
		state.setIp(state.getIp() + 1);
	}
}
