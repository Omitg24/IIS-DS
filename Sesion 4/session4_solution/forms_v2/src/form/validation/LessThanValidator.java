package form.validation;

public class LessThanValidator implements Validator
{
	private int value;
	
	public LessThanValidator(int value)
	{
		this.value = value;
	}
	
	@Override
	public boolean isValid(String value) 
	{		
		try {
			int number = Integer.parseInt(value);
			return number < this.value;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public String getMessage() 
	{
		return "menor que " + value;
	}
}
