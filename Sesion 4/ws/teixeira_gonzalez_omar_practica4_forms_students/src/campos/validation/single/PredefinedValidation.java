package campos.validation.single;

import campos.validation.Validation;

/**
 * Título: Clase PredefinedValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class PredefinedValidation implements Validation {
	/**
	 * Atributo values
	 */
	private String[] values;
	
	/**
	 * Constructor PredefinedValidation
	 * @param values
	 */
	public PredefinedValidation(String... values) {
		this.values=values;
	}
	
	/**
	 * Método check
	 * @param input
	 * @return boolean
	 */
	@Override
	public boolean check(String input) {
		for (String valor : values) {
			if (input.toLowerCase().equals(valor.toLowerCase())) {
				return true;
			}
		}
		return false;
	}
}