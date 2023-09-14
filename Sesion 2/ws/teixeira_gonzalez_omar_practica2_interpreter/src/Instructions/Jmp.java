package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Titulo: Clase Jmp
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Jmp implements Instruction {

	/**
	 * Atributo value
	 */
	private int value;
	
	/**
	 * Constructor de la clase Jmp
	 * @param value, valor
	 */
	public Jmp (int value) {
		this.value = value;
	}
	
	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		state.setIp(value);
	}
}
