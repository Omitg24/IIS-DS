package form.validation;

public class AndValidator extends CompoundValidator implements Validator 
{
	public AndValidator(Validator... validators)
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
			if (!validator.isValid(value))
				return false;
		}
		return true;
	}

	@Override
	protected String getConjuction() 
	{
		return "y";
	}
}
