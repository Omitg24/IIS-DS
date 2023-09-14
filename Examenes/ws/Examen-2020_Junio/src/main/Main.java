package main;

import machine.Machine;
import machine.discounts.*;
import machine.model.Event;
import machine.paymentModes.*;

// El main sólo debería ser modificado para crear nuevos objetos que formen
// parte de la solución.
//
public class Main 
{
	public static void main(String[] args) 
	{		
		Machine machine = new Machine();
				
		// se introducen unos eventos en la máquina expendedora
		machine.addEvent(new Event("Concierto de los Rolling Stones", 120, 5));
		machine.addEvent(new Event("Cartelera: Blade runner", 10, 100));
		machine.addEvent(new Event("Actuación de Rubén García", 60, 80));
		machine.addEvent(new Event("Concierto de la OSPA", 90, 30));
		machine.addEvent(new Event("Ópera: Nabuco", 160, 20));
		
		machine.addPaymentMode(new CardPaymentMode());
		machine.addPaymentMode(new CashPaymentMode());
		machine.addPaymentMode(new PayPalPaymentMode());
		
		machine.addDiscount("15EURACOS", new FixedDiscount(15));
		machine.addDiscount("VERANO20", new PercentageDiscount(10));
		machine.addDiscount("FREE1", new FreeTicket());
		
		// se cede el control de la ejecución a la máquina
		machine.run();
	}
}
