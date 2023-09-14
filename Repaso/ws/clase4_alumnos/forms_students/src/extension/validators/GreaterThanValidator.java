package extension.validators;

import extension.Validator;

public class GreaterThanValidator implements Validator {

	private int numberComparison;

	public GreaterThanValidator(int numberComparison) {
		this.numberComparison = numberComparison;
	}

	@Override
	public boolean validate(String text) {
		return Integer.valueOf(text).compareTo(numberComparison) > 0;
	}
}
