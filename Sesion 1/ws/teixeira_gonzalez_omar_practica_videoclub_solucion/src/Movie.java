/**
 * Titulo: Clase Movie
 *
 * @author Omar Teixeira González, UO281847
 * @version 19 sept 2022
 */
public class Movie 
{
	/**
	 * Constante CHILDRENS
	 */
	public static final MovieType CHILDRENS = new Childrens();
	/**
	 * Constante NEW_RELEASE
	 */
	public static final MovieType NEW_RELEASE = new NewRelease();
	/**
	 * Constante REGULAR
	 */
	public static final MovieType REGULAR = new Regular();
	
	/**
	 * Atributo title
	 */
	private String title;
	/**
	 * Atributo movieType
	 */
	private MovieType movieType;
	
	/**
	 * Constructor Movie
	 * @param title, titulo
	 * @param priceCode, precio
	 */
	public Movie(String title, MovieType type) 
	{
		this.title = title;
		this.movieType = type;
	}
		
	/**
	 * Método getTitle
	 * @return title, titulo
	 */
	public String getTitle() 
	{
		return title;
	}

	/**
	 * Método getCharge
	 * @param daysRented, días alquilados
	 * @return result, resultado
	 */
	public double getCharge(int daysRented) {
		return movieType.getCharge(daysRented);
	}

	/**
	 * Método getFrequentRenterPoints
	 * @param daysRented, días alquilados
	 * @return frequentRenterPoints, puntos de alquiler
	 */
	public int getFrequentRenterPoints(int daysRented) {
		return movieType.getFrequentRenterPoints(daysRented);
	}	
}
