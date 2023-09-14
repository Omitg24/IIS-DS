package temperature;

public class Temperature 
{
	private double celsius;
	private double fahrenheit;
	
	public Temperature(double value)
	{
		setCelsius(value);
	}

	public void setCelsius(double value)
	{
		celsius = value;
		fahrenheit = value * 9 / 5 + 32;
	}
	
	public void setFahrenheit(double value)
	{
		fahrenheit = value;
		celsius = (value - 32) * 5 / 9;
	}
	
	public double asCelsius()
	{
		return celsius;
	}
	
	public double asFahrenheit()
	{
		return fahrenheit;
	}
}
