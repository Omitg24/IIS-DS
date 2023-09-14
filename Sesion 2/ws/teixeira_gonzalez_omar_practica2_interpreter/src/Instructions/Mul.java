package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Titulo: Clase Mul
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Mul implements Instruction {

	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		state.push(state.pop() * state.pop());
		state.setIp(state.getIp() + 1);
	}
}
