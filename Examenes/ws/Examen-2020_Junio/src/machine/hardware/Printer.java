package machine.hardware;

import machine.model.Ticket;

public class Printer 
{	
	public void printTicket(Ticket ticket) 
	{
		System.out.printf("-------------ENTRADA nº %s ---------------%n", ticket.getNumber());
		System.out.println(ticket.getEvent().getName());
		System.out.println("--------------------------------------------");
	}
}
