package temperature;

public class Temperature 
{
	private double celsius;
	private double fahrenheit;
	
	private boolean celsiusOk;
	private boolean fahrenheitOk;
	
	public Temperature(double value)
	{
		setCelsius(value);
	}

	public void setCelsius(double value)
	{
		celsiusOk = true;
		fahrenheitOk = false;
		celsius = value;
	}
	
	public void setFahrenheit(double value)
	{
		celsiusOk = false;
		fahrenheitOk = true;
		fahrenheit = value;
	}
	
	public double asCelsius()
	{
		if (celsiusOk)
			return celsius;
		celsiusOk = true;
		celsius = (fahrenheit - 32) * 5 / 9;
		return celsius;
	}
	
	public double asFahrenheit()
	{
		if (fahrenheitOk)
			return fahrenheit;
		fahrenheitOk = true;
		fahrenheit = celsius * 9 / 5 + 32;
		return fahrenheit;
	}
}
