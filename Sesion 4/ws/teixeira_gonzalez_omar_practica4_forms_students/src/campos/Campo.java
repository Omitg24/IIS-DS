package campos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import campos.validation.Validation;

/**
 * Título: Clase Campo
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class Campo {
	/**
	 * Atributo etiqueta
	 */
	private String etiqueta;
	/**
	 * Atribubo validation
	 */
	private Validation validation;
	/**
	 * Atributo text
	 */
	private String text;
	
	/**
	 * Constructor Campo
	 * @param etiqueta
	 * @param validation
	 */
	public Campo(String etiqueta, Validation validation) {
		this.etiqueta = etiqueta;
		this.validation=validation;
	}

	/**
	 * Método getValue
	 * @return
	 */
	public String getValue() {
		return text;
	}
	
	/**
	 * Método pideDato
	 */
	public void pideDato() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
	
		boolean valido;
		do {
			valido = true;
			try {
				System.out.print(etiqueta + ": ");
				text = consola.readLine();
	
				valido = validation.check(text);
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}	
}