package modifiers;

import java.io.IOException;

import outputs.Output;

/**
 * Titulo: Clase Divider
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class Divider implements Output {

	/**
	 * Atributo outputs
	 */
	private Output[] outputs;
	
	/**
	 * Constructor Divider
	 * @param outputs
	 */
	public Divider(Output... outputs) {
		this.outputs=outputs;
	}	

	/**
	 * Método send
	 */
	@Override
	public void send(char c) throws IOException {
		for(Output output : outputs) {
			output.send(c);
		}
	}

	/**
	 * Método close
	 */
	@Override
	public void close() throws IOException {
		for(Output output : outputs) {
			output.close();
		}
	}
}
