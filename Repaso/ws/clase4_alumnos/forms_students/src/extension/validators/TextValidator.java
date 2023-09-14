package extension.validators;

import extension.Validator;

public class TextValidator implements Validator {

	@Override
	public boolean validate(String text) {
		for (char ch : text.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

}
