package modifiers;

import java.io.IOException;

import outputs.Output;

/**
 * Titulo: Clase Modifier
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public abstract class Modifier implements Output {
	/**
	 * Atributo output
	 */
	protected Output output;
	
	/**
	 * Constructor Modifier
	 * @param output
	 */
	public Modifier(Output output) {
		this.output=output;
	}
	
	/**
	 * Método send
	 */
	@Override
	public abstract void send(char c) throws IOException;

	/**
	 * Método close
	 */
	@Override
	public void close() throws IOException {
		output.close();
	}
}
