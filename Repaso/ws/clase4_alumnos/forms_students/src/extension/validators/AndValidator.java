package extension.validators;

import extension.Validator;

public class AndValidator implements Validator {

	private Validator[] validators;

	public AndValidator(Validator... validators) {
		this.validators = validators;
	}

	@Override
	public boolean validate(String text) {
		for (Validator validator : validators) {
			if (!validator.validate(text)) {
				return false;
			}
		}
		return true;
	}
}
