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
	public static final int CHILDRENS = 2;
	/**
	 * Constante NEW_RELEASE
	 */
	public static final int NEW_RELEASE = 1;
	/**
	 * Constante REGULAR
	 */
	public static final int REGULAR = 0;
	
	/**
	 * Atributo title
	 */
	private String title;
	/**
	 * Atributo priceCode
	 */
	private int priceCode;
	
	/**
	 * Constructor Movie
	 * @param title, titulo
	 * @param priceCode, precio
	 */
	public Movie(String title, int priceCode) 
	{
		this.title = title;
		this.priceCode = priceCode;
	}
	
	/**
	 * Método getPriceCode
	 * @return priceCode, precio
	 */
	public int getPriceCode() 
	{
		return priceCode;
	}

	/**
	 * Método setPriceCode
	 * @param priceCode, precio
	 */
	public void setPriceCode(int priceCode) 
	{
		this.priceCode = priceCode;
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
		double result = 0;
		switch (priceCode) {
			case Movie.REGULAR:
				result += 2;
				if (daysRented > 2) 
					result += (daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += daysRented * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if (daysRented > 3)
					result += (daysRented - 3) * 1.5;
				break;
		}
		return result;
	}

	/**
	 * Método getFrequentRenterPoints
	 * @param daysRented, días alquilados
	 * @return frequentRenterPoints, puntos de alquiler
	 */
	public int getFrequentRenterPoints(int daysRented) {
		int frequentRenterPoints = 1;
		// Un punto extra en el caso de las novedades alquiladas por un período de dos o más días
		if ((priceCode == Movie.NEW_RELEASE) && daysRented > 1) 
			frequentRenterPoints++;
		return frequentRenterPoints;
	}	
}
