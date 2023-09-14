import java.util.List;
import java.util.ArrayList;

/**
 * Titulo: Clase Customer
 *
 * @author Omar Teixeira González, UO281847
 * @version 19 sept 2022
 */
public class Customer 
{
	/**
	 * Atributo name
	 */
	private String name;
	/**
	 * Atributo rentals
	 */
	private List<Rental> rentals = new ArrayList<Rental>();
	
	/**
	 * Constructor Customer
	 * @param name, nombre
	 */
	public Customer(String name) 
	{
		this.name = name;
	}
	
	/**
	 * Método addRental
	 * @param rental, alquiler
	 */
	public void addRental(Rental rental) 
	{
		rentals.add(rental);
	}
	
	/**
	 * Método getName
	 * @return name, nombre
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Método statement
	 * @return result, estado
	 */
	public String statement() 
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		
		for (Rental each : rentals) {
			
			// Calcula el importe de cada alquiler
			double thisAmount = each.getAmount();
			
			// Añade los puntos de alquiler frecuente
			frequentRenterPoints += each.getFrequentRenterPoints();
			
			// Muestra el importe de esta película alquilada
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		
		// Añade las líneas de total
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
		
		return result;
	}
}
