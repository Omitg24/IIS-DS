package extension.validators;

import extension.Validator;

public class PredefinedValidator implements Validator {

	private String[] values;

	public PredefinedValidator(String... values) {
		this.values = values;
	}

	@Override
	public boolean validate(String text) {
		for (String value : values) {
			if (text.toLowerCase().equals(value.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
