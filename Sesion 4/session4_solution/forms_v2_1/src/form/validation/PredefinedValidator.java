package form.validation;


public class PredefinedValidator implements Validator
{
	private String[] predefinedValues;
	private String message;
	
	public PredefinedValidator(String... values)
	{
		if (values == null || values.length == 0)
			throw new IllegalArgumentException("Se necesita al menos un valor posible para el campo predefinido");
		this.predefinedValues = values;
		this.message = buildMessage();
	}
	
	@Override
	public boolean isValid(String value) 
	{
		for (String each : predefinedValues) {
			if (each.equalsIgnoreCase(value))
				return true;
		}
		return false;
	}
	
	private String buildMessage()
	{
		StringBuilder result = new StringBuilder("predefinido: [");
		for (int i = 0; i < predefinedValues.length; i++) {
			result.append(predefinedValues[i]);
			if (i < predefinedValues.length - 2)
				result.append(", ");
			if (i == predefinedValues.length - 2)
				result.append(" o ");
		}
		result.append("]");
		return result.toString();		
	}
	
	@Override
	public String getMessage() 
	{
		return message;
	}
}
