package machine.model;

public class Ticket 
{
	private Event event;
	private String number;
	
	public Ticket(Event event, String number) 
	{
		this.event = event;
		this.number = number;
	}
	
	public Event getEvent() 
	{
		return event;
	}
	
	public String getNumber() 
	{
		return number;
	}
	
	@Override
	public String toString()
	{
		return String.format("Entrada nº %d para %s", number, event.getName());
	}
}
