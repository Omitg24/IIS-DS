package temperature;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TemperatureTest 
{
	private static final double delta = 0.01;
	private Temperature t37C, t32F;
	
	@Before
	public void setUp()
	{
		t37C = new Temperature(37);
		t32F = new Temperature(0);
	}
	
	@Test
	public void testCelsiusAsCelsius() 
	{
		assertEquals(37, t37C.asCelsius(), delta);
	}

	@Test
	public void testFahrenheitAsFahrenheit()
	{
		assertEquals(32, t32F.asFahrenheit(), delta);
	}
	
	@Test
	public void testCelsiusAsFahrenheit()
	{
		assertEquals(98.6, t37C.asFahrenheit(), delta);
	}
	
	@Test
	public void testFahrenheitAsCelsius()
	{
		assertEquals(0, t32F.asCelsius(), delta);
	}
}
