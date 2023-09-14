package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;
/**
 * Titulo: Clase Push
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Push implements Instruction {
	/**
	 * Atributo value
	 */
	private int value;
	
	/**
	 * Constructor Push
	 * @param value, value
	 */
	public Push (int value) {
		this.value = value;
	}
	
	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		state.push(value);
		state.setIp(state.getIp() + 1);
	}
}
