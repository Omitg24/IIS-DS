package ligafutbol.validators;

import ligafutbol.Equipo;
import ligafutbol.Validator;

public class SameGender implements Validator {

	@Override
	public boolean execute(Equipo equipo, Equipo candidato) {		
		return equipo.isMasculino() == candidato.isMasculino();
	}

}
