package base;
public class Application
{
	public static void main(String[] args)
	{
		double[] temperaturas = new double[100];

		// Toma de datos
		for (int i = 0; i < temperaturas.length; i++)
			temperaturas[i] = leeSensorCelsius();

		// Cálculo con los datos en Celsius
		double mediaCelsius = 0;
		for (double element : temperaturas)
			mediaCelsius += element;
		mediaCelsius = mediaCelsius / temperaturas.length;
		System.out.printf("La media en Celsius es: %.1f ºC\n", mediaCelsius);

		// Cálculo con los datos en Fahrenheit
		double mediaFahrenheit = 0;
		for (double element : temperaturas)
			mediaFahrenheit += element * 9 / 5 + 32;
		mediaFahrenheit = mediaFahrenheit / temperaturas.length;
		System.out.printf("La media en Fahrenheit es: %.1f ºF\n", mediaFahrenheit);

		// Otro cálculo con los datos en Fahrenheit
		double varianza = 0;
		for (double element : temperaturas)
			varianza += Math.pow((element * 9 / 5 + 32) - mediaFahrenheit, 2);
		varianza = varianza / temperaturas.length;
		System.out.printf("La varianza en Fahrenheit es: %.1f\n", varianza);
	}

	public static double leeSensorCelsius()
	{
		return Math.random() * 30;
	}
}