package base;
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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each : rentals) {
			double thisAmount = 0;

			// Calcula el importe de cada alquiler
			switch (each.getMovie().getPriceCode()) {
			case Movie.REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}

			// Añade los puntos de alquiler frecuente
			frequentRenterPoints++;
			// Un punto extra en el caso de las novedades alquiladas por un período de dos o más días
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
				frequentRenterPoints++;

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
