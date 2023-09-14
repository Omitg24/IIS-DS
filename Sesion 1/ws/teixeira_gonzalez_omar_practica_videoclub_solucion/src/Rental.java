/**
 * 
 * Titulo: Clase Rental
 * Esta clase representa el alquiler de una película por parte de un cliente.
 *
 * @author Omar Teixeira González, UO281847
 * @version 19 sept 2022
 */
public class Rental 
{
	/**
	 * Atributo movie
	 */
	private Movie movie;
	/**
	 * Atributo daysRented
	 */
	private int daysRented;
	
	/**
	 * Constructor Rental
	 * @param movie
	 * @param daysRented
	 */
	public Rental(Movie movie, int daysRented) 
	{
		this.movie = movie;
		this.daysRented = daysRented;
	}

	/**
	 * Método getDaysRented
	 * @return daysRented, días alquilados
	 */
	public int getDaysRented() 
	{
		return daysRented;
	}

	/**
	 * Método getMovie
	 * @return movie, pelicula
	 */
	public Movie getMovie() 
	{
		return movie;
	}
	
	/**
	 * Método getAmount
	 * @return amount, cantidad
	 */
	public double getAmount() {
		return movie.getCharge(daysRented);
	}

	/**
	 * Método getFrequentRenterPoints
	 * @return frequentRenterPoints, puntos de alquiler
	 */
	public int getFrequentRenterPoints() {
		return movie.getFrequentRenterPoints(daysRented);
	}
}
