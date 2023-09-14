package modifiers;

import java.io.IOException;

import outputs.Output;

/**
 * Titulo: Clase Encript
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class Encript extends Modifier {
	
	/**
	 * Constructor Encript
	 * @param output
	 */
	public Encript(Output output) {
		super(output);
	}

	/**
	 * Método send
	 */
	@Override
	public void send(char c) throws IOException {
		if (Character.isDigit(c) || Character.isLetter(c)) {
			c += 1;
		}
		output.send(c);
	}
}
