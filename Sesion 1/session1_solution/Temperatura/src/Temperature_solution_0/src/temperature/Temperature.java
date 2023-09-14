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
	
	public double asCelsius()
	{
		return value;
	}
	
	public double asFahrenheit()
	{
		return value * 9 / 5 + 32;
	}
}
