import junit.framework.TestCase;

public class CustomerTest extends TestCase 
{
	protected void setUp() throws Exception 
	{
		super.setUp();
	}

	protected void tearDown() throws Exception 
	{
		super.tearDown();
	}

	public void testCustomer() 
	{
		Customer c = new Customer("David");
		assertNotNull(c);	
	}

	public void testAddRental() 
	{
		Customer customer2 = new Customer("Sallie");
		Movie movie1 = new Movie("Gone with the Wind", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 3); // 3 day rental
		customer2.addRental(rental1);
	}

	public void testGetName() 
	{
		Customer c = new Customer("David");
		assertEquals("David", c.getName());
	}

	public void testStatementForRegularMovie() 
	{
		Customer customer2 = new Customer("Sallie");
		Movie movie1 = new Movie("Gone with the Wind", Movie.REGULAR);
		Rental rental1 = new Rental(movie1, 3); // 3 day rental
		customer2.addRental(rental1);
		String expected = "Rental Record for Sallie\n" +
							"\tGone with the Wind\t3.5\n" +
							"Amount owed is 3.5\n" +
							"You earned 1 frequent renter points";
		String statement = customer2.statement();
		assertEquals(expected, statement);
	}
	
	public void testStatementForNewReleaseMovie() 
	{
		Customer customer2 = new Customer("Sallie");
		Movie movie1 = new Movie("Star Wars", Movie.NEW_RELEASE);
		Rental rental1 = new Rental(movie1, 3); // 3 day rental
		customer2.addRental(rental1);
		String expected = "Rental Record for Sallie\n" +
							"\tStar Wars\t9.0\n" +
							"Amount owed is 9.0\n" +
							"You earned 2 frequent renter points";
		String statement = customer2.statement();
		assertEquals(expected, statement);
	}
	
	public void testStatementForChildrensMovie() 
	{
		Customer customer2 = new Customer("Sallie");
		Movie movie1 = new Movie("Madagascar", Movie.CHILDRENS);
		Rental rental1 = new Rental(movie1, 3); // 3 day rental
		customer2.addRental(rental1);
		String expected = "Rental Record for Sallie\n" +
							"\tMadagascar\t1.5\n" +
							"Amount owed is 1.5\n" +
							"You earned 1 frequent renter points";
		String statement = customer2.statement();
		assertEquals(expected, statement);
	}
	
	public void testStatementForManyMovies() 
	{
		Customer customer1 = new Customer("David");
		Movie movie1 = new Movie("Madagascar", Movie.CHILDRENS);
		Rental rental1 = new Rental(movie1, 6); // 6 day rental
		Movie movie2 = new Movie("Star Wars", Movie.NEW_RELEASE);
		Rental rental2 = new Rental(movie2, 2); // 2 day rental
		Movie movie3 = new Movie("Gone with the Wind", Movie.REGULAR);
		Rental rental3 = new Rental(movie3, 8); // 8 day rental
		customer1.addRental(rental1);
		customer1.addRental(rental2);
		customer1.addRental(rental3);
		String expected = "Rental Record for David\n" +
							"\tMadagascar\t6.0\n" +
							"\tStar Wars\t6.0\n" +
							"\tGone with the Wind\t11.0\n" +
							"Amount owed is 23.0\n" +
							"You earned 4 frequent renter points";
		String statement = customer1.statement();
		assertEquals(expected, statement);
	}
}
