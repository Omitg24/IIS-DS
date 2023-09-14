package campos.validation.single;

import campos.validation.Validation;

/**
 * Título: Clase DigitValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class DigitValidation implements Validation {
	/**
	 * Método check
	 * @param input
	 * @return boolean
	 */
	@Override
	public boolean check(String input) {
		for (char ch : input.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}