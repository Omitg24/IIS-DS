package machine;

import java.util.*;

import machine.hardware.*;
import machine.model.*;
import ruralvia.BankGateway;

public class Machine 
{		
	private List<Event> events = new ArrayList<>();
	private List<PaymentMode> paymentModes = new ArrayList<>();
	private Map<String, Discount> discounts = new HashMap<>();
	
	// los distintos componentes físicos con los que interactúa la máquina expendedora
	private Display display = new Display();
	private Keyboard keyboard = new Keyboard();
	private Printer printer = new Printer();
	private CardReader cardReader = new CardReader();
	private BillAcceptor billAcceptor = new BillAcceptor();
	
	// pasarela de pagos (para los pagos con tarjeta)
	private BankGateway bankGateway = new BankGateway();
	
	
	
	//-- Métodos públicos
	//-------------------------------------------------------------------------

	public void addEvent(Event event)
	{
		events.add(event);
	}
	
	public void run()
	{
		while (true)
		{
			Event selectedEvent = selectEvent();
			
			display.show("\n¿Cuántas entradas desea comprar? ");
			int numberOfTickets = howManyTickets(selectedEvent.getAvailableTickets());

			// se calcula el importe a pagar
			double amountToPay = numberOfTickets * selectedEvent.getPrice();
			display.show(String.format("Importe a pagar: %.2f €%n", amountToPay));
			
			display.show("Por favor, si tiene un codigo de descuento, introduzcalo ahora: ");
			String discountCode = keyboard.readString();
			if (discounts.get(discountCode) != null) {
				amountToPay = discounts.get(discountCode).applyDiscounts(numberOfTickets, selectedEvent.getPrice());
				display.show("El código de descuento " + discountCode + " se ha aplicado correctamente, el precio final será: " + amountToPay);
			} else {
				display.show("Lo sentimos, el código de descuento que ha introducido no existe");
			}
			
			PaymentMode paymentMode = selectPaymentMode();
			
			// se realiza el pago
			boolean isValidPayment = paymentMode.pay(this, amountToPay);
			
			if (!isValidPayment) {
				display.show("No se ha podido completar el pago\n\n");
				continue;
			}
			
			// se generan las entradas
			List<Ticket> tickets = selectedEvent.generateTickets(numberOfTickets);
			
			// por último, la máquina imprime las entradas generadas
			display.show("\nSus entradas se están imprimiendo...\n");
			for (Ticket ticket : tickets) {
				printer.printTicket(ticket);			
			}
			
			display.show("Gracias por su compra, que disfrute del evento.\n\n");			
		}
	}
	
	
	
	//-- Pago
	//-------------------------------------------------------------------------
	
	public void addPaymentMode(PaymentMode paymentMode) {
		paymentModes.add(paymentMode);
	}
	
	private PaymentMode selectPaymentMode()
	{
		display.show("\nEscoja un método de pago:\n");
		int counter = 1;
		for (PaymentMode paymentMode : paymentModes) {
			display.show("\t" + counter + ". " + paymentMode.getPaymentMethod() + "\n");
			counter++;
		}
		int option = keyboard.readOption(this.paymentModes.size());
		if (option >= 1 && option <= this.paymentModes.size()) {
			return this.paymentModes.get(option - 1);
		} else {
			throw new AssertionError("Método de pago inválido");
		}		
	}
	
	//-- Seleccionar evento
	//-------------------------------------------------------------------------
	
	private Event selectEvent()
	{
		showEvents();
		int option = keyboard.readOption(events.size());
		Event event = events.get(option - 1);
		showEvent(event);
		return event;
	}
	
	private void showEvents()
	{
		display.show("Seleccione un evento:\n");
		int i = 1;
		for (Event each : events) {
			System.out.printf("%d. %s%n", i, each.getName());
			i++;
		}
	}
	
	private void showEvent(Event event)
	{
		display.show("Evento seleccionado:\n");
		display.show("  " + event.getName() + "\n");
		display.show(String.format("  Quedan %d entradas disponibles a %.2f euros%n", 
				event.getAvailableTickets(), event.getPrice()));
	}
	
	
	//-- Pedir el número de entradas
	//-------------------------------------------------------------------------
	
	private int howManyTickets(int availableTickets)
	{
		do {
			int numberOfTickets = keyboard.readInt();
			if (numberOfTickets <= availableTickets)
				return numberOfTickets;
			display.show(String.format("Sólo quedan %d entradas disponibles, seleccione un número menor: ",
					availableTickets));
		} while (true);
	}
	
	
	//-- Descuentos
	//-------------------------------------------------------------------------
	
	public void addDiscount(String discountCode, Discount discount) {
		this.discounts.put(discountCode, discount);
	}

	public Display getDisplay() {
		return display;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public Printer getPrinter() {
		return printer;
	}

	public CardReader getCardReader() {
		return cardReader;
	}

	public BillAcceptor getBillAcceptor() {
		return billAcceptor;
	}

	public BankGateway getBankGateway() {
		return bankGateway;
	}	
}
