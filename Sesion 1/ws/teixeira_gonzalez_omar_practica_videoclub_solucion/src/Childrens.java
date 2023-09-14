/**
 * Titulo: Clase Childrens
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Childrens implements MovieType {

	/**
	 * Método getCharge
	 * @param daysRented, días alquilados
	 * @return result, resultado
	 */
	@Override
	public double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result += (daysRented - 3) * 1.5;
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
