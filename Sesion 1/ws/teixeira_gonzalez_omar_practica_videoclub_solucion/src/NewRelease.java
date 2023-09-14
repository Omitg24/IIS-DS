/**
 * Titulo: Clase NewRelease
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class NewRelease implements MovieType {

	/**
	 * Método getCharge
	 * @param daysRented, días alquilados
	 * @return result, resultado
	 */
	@Override
	public double getCharge(int daysRented) {		
		return daysRented * 3;
	}

	/**
	 * Método getFrequentRenterPoints
	 * @param daysRented, días alquilados
	 * @return frequentRenterPoints, puntos de alquiler
	 */
	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if (daysRented > 1) 
			return 2;
		return 1;
	}

}
