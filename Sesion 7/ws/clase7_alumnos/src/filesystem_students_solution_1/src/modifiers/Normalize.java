package modifiers;

import java.io.IOException;

import outputs.Output;

/**
 * Titulo: Clase Normalize
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class Normalize extends Modifier {

	/**
	 * Constructor Normalize
	 * @param output
	 */
	public Normalize(Output output) {
		super(output);
	}

	/**
	 * Método send
	 */
	@Override
	public void send(char c) throws IOException {
		if (c != '\r') {
			output.send(c);
		}
	}
}
