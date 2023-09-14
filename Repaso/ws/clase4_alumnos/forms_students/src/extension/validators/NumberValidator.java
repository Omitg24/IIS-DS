package extension.validators;

import extension.Validator;

public class NumberValidator implements Validator {

	@Override
	public boolean validate(String text) {
		for (char ch : text.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

}
