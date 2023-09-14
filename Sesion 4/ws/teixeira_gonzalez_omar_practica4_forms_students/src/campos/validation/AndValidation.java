package campos.validation;

/**
 * Título: Clase AndValidation
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class AndValidation implements Validation{
	/**
	 * Atributo validations
	 */
	private Validation[] validations;
	
	/**
	 * Constructor AndValidation
	 * @param validations
	 */
	public AndValidation(Validation... validations) {
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
			if (!v.check(input)) {
				return false;
			}
		}
		return true;
	}
}