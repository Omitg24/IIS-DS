package VirtualMachine;

/**
 * Titulo: Interfaz IInstruction
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public interface Instruction {
	/**
	 * Método execute
	 * @param state, estado
	 */
	public abstract void execute(State state);
}
