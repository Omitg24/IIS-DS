package campos.validation.single;

import campos.validation.Validation;

/**
 * Título: Clase LowerValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class LowerValidation implements Validation {
	/**
	 * Atributo value
	 */
	private int value;
	
	/**
	 * Constructor LowerValidation
	 * @param value
	 */
	public LowerValidation(int value) {
		this.value=value;
	}
	
	/**
	 * Método check
	 * @param input
	 * @return boolean
	 */
	@Override
	public boolean check(String input) {
		return Integer.parseInt(input) < value;
	}
}