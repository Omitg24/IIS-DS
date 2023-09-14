/**
 * Titulo: Clase Regular
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Regular implements MovieType {

	/**
	 * Método getCharge
	 * @param daysRented, días alquilados
	 * @return result, resultado
	 */
	@Override
	public double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2) 
			result += (daysRented - 2) * 1.5;
		return result;
	}

	/**
	 * Método getFrequentRenterPoints
	 * @param daysRented, días alquilados
	 * @return frequentRenterPoints, puntos de alquiler
	 */
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
