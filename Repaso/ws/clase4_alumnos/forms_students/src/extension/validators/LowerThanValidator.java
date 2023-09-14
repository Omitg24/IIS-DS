package extension.validators;

import extension.Validator;

public class LowerThanValidator implements Validator {

	private int numberComparison;

	public LowerThanValidator(int numberComparison) {
		this.numberComparison = numberComparison;
	}

	@Override
	public boolean validate(String text) {
		return Integer.valueOf(text).compareTo(numberComparison) < 0;
	}
}
