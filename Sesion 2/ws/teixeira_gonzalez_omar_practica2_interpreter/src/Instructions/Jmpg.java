package Instructions;

import VirtualMachine.Instruction;
import VirtualMachine.State;

public class Jmpg implements Instruction {

	/**
	 * Atributo value
	 */
	private int value;
	
	/**
	 * Constructor de la clase Jmp
	 * @param value, valor
	 */
	public Jmpg (int value) {
		this.value = value;
	}
	
	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		int b = state.pop();
		int a = state.pop();
		
		if (a > b) {
			state.setIp(value);
		} else {
			state.setIp(state.getIp() + 1);
		}
	}
}
