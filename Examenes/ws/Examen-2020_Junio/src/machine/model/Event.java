package machine.model;

import java.util.*;

public class Event 
{
	private String name;
	private double price;
	// número de entradas disponibles
	private int availableTickets;
	// el número de la última entrada vendida para el evento; se va incrementando automáticamente
	private int ticketNumber = 1;
	
	public Event(String name, double price, int availableTickets) 
	{
		this.name = name;
		this.price = price;
		this.availableTickets = availableTickets;
	}

	public String getName() 
	{
		return name;
	}

	public double getPrice() 
	{
		return price;
	}

	public int getAvailableTickets() 
	{
		return availableTickets;
	}
	
	public List<Ticket> generateTickets(int numberOfTickets) 
	{
		if (numberOfTickets > availableTickets)
			throw new IllegalArgumentException("No quedan suficientes entradas disponibles");
		List<Ticket> result = new ArrayList<>();
		for (int i = 0; i < numberOfTickets; i++) {
			String locator = String.format("%04d", ticketNumber);
			Ticket ticket = new Ticket(this, locator);
			result.add(ticket);
			ticketNumber++;
		}
		availableTickets = availableTickets - numberOfTickets;
		return result;
	}
	
	@Override
	public String toString()
	{
		return String.format("Evento: %s - Precio: %.2f € - %d entradas disponibles",
				name, price, availableTickets);
	}
}
