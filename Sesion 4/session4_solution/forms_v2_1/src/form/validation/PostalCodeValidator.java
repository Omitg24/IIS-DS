package form.validation;

import form.Field;

public class PostalCodeValidator extends AndValidator implements Validator
{
	public PostalCodeValidator()
	{
		super(Field.NUMBER, new LengthValidator(5));
	}
}
