package temperature;

public class Temperature 
{
	// La representación interna del valor de la temperatura representado por
	// este objeto, en grados Celsius 
	private double value;
	
	public Temperature(double value)
	{
		this.value = value;
	}

	public void setCelsius(double value)
	{
		this.value = value;
	}
	
	public void setFahrenheit(double value)
	{
		this.value = (value - 32) * 5 / 9;
	}
	
	public double asCelsius()
	{
		return value;
	}
	
	public double asFahrenheit()
	{
		return value * 9 / 5 + 32;
	}
}
