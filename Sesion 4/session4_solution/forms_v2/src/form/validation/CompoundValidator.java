package form.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CompoundValidator implements Validator 
{
	protected List<Validator> validators = new ArrayList<>();
	
	public CompoundValidator(Validator... validators)
	{
		if (validators == null || validators.length == 0)
			throw new IllegalArgumentException("Se necesita al menos un validador para crear un validador compuesto");
		this.validators = Arrays.asList(validators);
	}
	
	public void addCondition(Validator validator)
	{
		if (validator == null)
			throw new IllegalArgumentException("¡No se puede añadir una condición nula a un validador compuesto!");
		validators.add(validator);
	}

	@Override
	public String getMessage() 
	{		
		StringBuffer result = new StringBuffer("");
		for (int i = 0; i < validators.size(); i++) {
			result.append(validators.get(i).getMessage());
			if (i < validators.size() - 2)
				result.append(", ");
			if (i == validators.size() - 2)
				result.append(" " + getConjuction() + " ");
		}
		return result.toString();
	}
	
	protected abstract String getConjuction();
}
