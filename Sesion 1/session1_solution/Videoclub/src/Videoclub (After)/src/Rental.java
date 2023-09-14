/**
 * Esta clase representa el alquiler de una película por parte de un cliente.
 */
public class Rental 
{
	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int daysRented) 
	{
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() 
	{
		return daysRented;
	}

	public Movie getMovie() 
	{
		return movie;
	}

	public double getCharge() 
	{
		return movie.getCharge(daysRented);
	}

	int getFrequentRenterPoints() 
	{
		return movie.getFrequentRenterPoints(daysRented);
	}
}
