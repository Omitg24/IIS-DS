package campos.validation.single;

import campos.validation.Validation;

/**
 * Título: Clase TextValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class TextValidation implements Validation {

	/**
	 * Método check
	 * @param input
	 * @return boolean
	 */
	@Override
	public boolean check(String input) {
		for (char ch : input.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}			
		}
		return true;
	}
}