package modifiers;

import java.io.IOException;

import outputs.Output;

/**
 * Titulo: Clase RemoveDuplicatedSpaces
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class RemoveDuplicatedSpaces extends Modifier {
	
	/**
	 * Atributo previousChar
	 */
	private char previousChar;
	
	/**
	 * Constructor RemoveDuplicatedSpaces
	 * @param output
	 */
	public RemoveDuplicatedSpaces(Output output) {
		super(output);
	}

	/**
	 * Método send
	 */
	@Override
	public void send(char c) throws IOException {
		if (previousChar == ' ' && c == ' ') {
			return;
		}
		output.send(c);
		previousChar = c;
	}

}
