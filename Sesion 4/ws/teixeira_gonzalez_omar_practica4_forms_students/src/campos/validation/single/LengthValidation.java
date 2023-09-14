package campos.validation.single;

import campos.validation.Validation;

/**
 * Título: Clase LengthValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class LengthValidation implements Validation {
	/**
	 * Atributo length
	 */
	private int length;
	
	/**
	 * Constructor LengthValidation
	 * @param length
	 */
	public LengthValidation(int length) {
		this.length=length;
	}

	/**
	 * Método check
	 * @param input
	 * @return boolean
	 */
	@Override
	public boolean check(String input) {
		return input.length() == length;
	}
}