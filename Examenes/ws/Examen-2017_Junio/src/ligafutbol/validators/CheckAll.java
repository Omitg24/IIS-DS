package ligafutbol.validators;

import ligafutbol.Equipo;
import ligafutbol.Validator;

public class CheckAll implements Validator{

	private Validator[] validators;

	public CheckAll(Validator... validators) {
		this.validators = validators;
	}

	@Override
	public boolean execute(Equipo equipo, Equipo candidato) {
		for (Validator validator : validators) {
			if (!validator.execute(equipo, candidato)) {
				return false;
			}
		}
		return true;
	}
	
}
