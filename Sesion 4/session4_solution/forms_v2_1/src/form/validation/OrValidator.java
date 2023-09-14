package form.validation;

public class OrValidator extends CompoundValidator implements Validator 
{
	public OrValidator(Validator... validators)
	{
		super(validators);
	}
	
	public void addCondition(Validator validator)
	{
		super.addCondition(validator);
	}
	
	@Override
	public boolean isValid(String value) 
	{
		for (Validator validator : validators) {
			if (validator.isValid(value))
				return true;
		}
		return false;
	}

	@Override
	protected String getConjuction() 
	{
		return "o";
	}
}
