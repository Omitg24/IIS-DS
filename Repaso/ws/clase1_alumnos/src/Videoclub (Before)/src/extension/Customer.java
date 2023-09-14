package extension;
import java.util.ArrayList;
import java.util.List;

public class Customer
{
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name)
	{
		this.name = name;
	}

	public void addRental(Rental rental)
	{
		rentals.add(rental);
	}

	public String getName()
	{
		return name;
	}

	public String statement()
	{
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			// Muestra el importe de esta película alquilada
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getAmount()) + "\n";
		}

		// Añade las líneas de total
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

		return result;
	}

	private double getTotalAmount()
	{
		double result = 0;
		for (Rental each : rentals) {
			result += each.getAmount();
		}
		return result;
	}

	private int getTotalFrequentRenterPoints()
	{
		int result = 0;
		for (Rental each : rentals) {
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
}
