package ligafutbol.validators;

import ligafutbol.Equipo;
import ligafutbol.Validator;

public class SameAge implements Validator {

	@Override
	public boolean execute(Equipo equipo, Equipo candidato) {
		return equipo.getEdad() == candidato.getEdad();
	}

}
