package campos.validation;

/**
 * Título: Clase OrValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class OrValidation implements Validation{
	/**
	 * Atributo validations
	 */
	private Validation[] validations;
	
	/**
	 * Constructor OrValidation
	 * @param validations
	 */
	public OrValidation(Validation... validations) {
		this.validations=validations;
	}
	
	/**
	 * Método check
	 * @param input
	 * @return boolean
	 */
	@Override
	public boolean check(String input) {
		for (Validation v : validations) {
			if (v.check(input)) {
				return true;
			}
		}
		return false;
	}
}