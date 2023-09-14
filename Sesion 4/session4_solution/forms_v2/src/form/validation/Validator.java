package form.validation;

public interface Validator 
{
	boolean isValid(String value);
	String getMessage();
}
