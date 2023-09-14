package modifiers;

import java.io.IOException;

import outputs.Output;

/**
 * Titulo: Clase CountCharacters
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class CountCharacters extends Modifier {
	/**
	 * Atributo msg
	 */
	private String msg;
	/**
	 * Atributo counter
	 */
	private int counter;
	
	/**
	 * Contructor CountCharacters
	 * @param msg
	 * @param output
	 */
	public CountCharacters(Output output, String msg) {
		super(output);
		this.msg=msg;
	}

	/**
	 * Método send
	 */
	@Override
	public void send(char c) throws IOException {
		this.counter++;
		this.output.send(c);
	}
	
	/**
	 * Método close
	 */
	@Override
	public void close() throws IOException {	
		super.close();
		System.out.println(msg + ": " + counter + "# caracteres");
	}

}
