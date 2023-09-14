package extension.validators;

import extension.Validator;

public class LengthValidator implements Validator {

	private int length;

	public LengthValidator(int length) {
		this.length = length;
	}

	@Override
	public boolean validate(String text) {
		return text.length() == length;
	}

}
