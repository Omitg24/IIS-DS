package extension;
public class Application
{
	public static void main(String[] args)
	{
		Temperature[] temperaturas = new Temperature[100];

		// Toma de datos
		for (int i = 0; i < temperaturas.length; i++)
			temperaturas[i] = new Temperature(leeSensorCelsius());

		// Cálculo con los datos en Celsius
		double mediaCelsius = 0;
		// Cálculo con los datos en Fahrenheit
		double mediaFahrenheit = 0;
		for (Temperature element : temperaturas) {
			mediaCelsius += element.getCelsius();
			mediaFahrenheit += element.getFahrenheit();
		}
		mediaCelsius = mediaCelsius / temperaturas.length;
		System.out.printf("La media en Celsius es: %.1f ºC\n", mediaCelsius);
		System.out.printf("La media en Fahrenheit es: %.1f ºF\n", mediaFahrenheit);

		// Otro cálculo con los datos en Fahrenheit
		double varianza = 0;
		for (Temperature element : temperaturas) {
			varianza += Math.pow((element.getFahrenheit()) - mediaFahrenheit, 2);
		}
		varianza = varianza / temperaturas.length;
		System.out.printf("La varianza en Fahrenheit es: %.1f\n", varianza);
	}

	public static double leeSensorCelsius()
	{
		return Math.random() * 30;
	}
}