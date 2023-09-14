package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Titulo: Clase Sub
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Sub implements Instruction {

	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		int b = state.pop();
		int a = state.pop();
		state.push(a - b);
		state.setIp(state.getIp() + 1);
	}
}
