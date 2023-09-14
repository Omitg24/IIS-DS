/**
 * Titulo: Clase Application
 *
 * @author Omar Teixeira González, UO281847
 * @version 19 sept 2022
 */
public class Application 
{
	/**
	 * Método Main
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) 
	{
//		double[] temperaturas = new double[100];
		Temperature[] temperaturas = new Temperature[100];

		// Toma de datos
		for (int i = 0; i < temperaturas.length; i++)
//			temperaturas[i] = leeSensorCelsius();
			temperaturas[i] = new Temperature(leeSensorCelsius(), true);

		// Cálculo con los datos en Celsius
		double mediaCelsius = 0;
		for (int i = 0; i < temperaturas.length; i++)
//			mediaCelsius += temperaturas[i];
			mediaCelsius += temperaturas[i].asCelsius();
		mediaCelsius = mediaCelsius / temperaturas.length;
		System.out.printf("La media en Celsius es: %.1f ºC\n", mediaCelsius);

		// Cálculo con los datos en Fahrenheit
		double mediaFahrenheit = 0;
		for (int i = 0; i < temperaturas.length; i++)
			mediaFahrenheit += temperaturas[i].asFahrenheit();
		mediaFahrenheit = mediaFahrenheit / temperaturas.length;
		System.out.printf("La media en Fahrenheit es: %.1f ºF\n", mediaFahrenheit);

		// Otro cálculo con los datos en Fahrenheit
		double varianza = 0;
		for (int i = 0; i < temperaturas.length; i++)
			varianza += Math.pow((temperaturas[i].asFahrenheit()) - mediaFahrenheit, 2);
		varianza = varianza / temperaturas.length;
		System.out.printf("La varianza en Fahrenheit es: %.1f\n", varianza);
	}

	/**
	 * Método leeSensorCelsius
	 * @return value, valor
	 */
	public static double leeSensorCelsius() 
	{
		return Math.random() * 30;
	}
}