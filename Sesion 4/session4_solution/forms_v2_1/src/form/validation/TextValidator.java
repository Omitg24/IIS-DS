package form.validation;


public class TextValidator implements Validator
{
	@Override
	public boolean isValid(String value) 
	{
		for (char ch : value.toCharArray()) {
			if (!(Character.isLetter(ch) || Character.isWhitespace(ch)))
				return false;
		}
		return true;
	}
	
	@Override
	public String getMessage() 
	{
		return "de texto";
	}	
}
