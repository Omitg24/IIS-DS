/**
 * Titulo: Clase Temperature
 *
 * @author Omar Teixeira González, UO281847
 * @version 19 sept 2022
 */
public class Temperature {
	/**
	 * Atributo value
	 */
	private double value;
	
	/**
	 * Atributo isCelsius
	 */
	private boolean isCelsius;
	
	/**
	 * Constructor Temperature
	 * @param value, valor
	 */
	public Temperature(double value, boolean isCelsius) {
		if (isCelsius) {
			setCelsius(value);
		} else {
			setFahrenheit(value);
		}		
	}
	
	/**
	 * Método setCelsius
	 * @param value, valor
	 */
	public void setCelsius(double value) {
		this.value = value;
		this.isCelsius = true;
	}
	
	/**
	 * Método setFahrenheit
	 * @param value, valor
	 */
	public void setFahrenheit(double value) {
		this.value = value;
		this.isCelsius = false;
	}
	
	/**
	 * Método asCelsius
	 * @return value, valor
	 */
	public double asCelsius() {
		return isCelsius ? value : value / (9 / 5 + 32);
	}
	
	/**
	 * Método asFahrenheit
	 * @return value, valor
	 */
	public double asFahrenheit() {
		return isCelsius ? value * (9 / 5 + 32) : value;
	}
	
	/**
	 * Método toString
	 * @return string, valor
	 */
	public String toString() {
		return isCelsius ? value + " ºC": value * (9 / 5 + 32) + " ºF";
	}
}
