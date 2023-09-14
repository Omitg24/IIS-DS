/**
 * Titulo: Interfaz MovieType
 *
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public interface MovieType {
	/**
	 * Método getCharge
	 * @param daysRented, días alquilados
	 * @return result, resultado
	 */
	public abstract double getCharge(int daysRented);
	/**
	 * Método getFrequentRenterPoints
	 * @param daysRented, días alquilados
	 * @return frequentRenterPoints, puntos de alquiler
	 */
	public abstract int getFrequentRenterPoints(int daysRented);
}
