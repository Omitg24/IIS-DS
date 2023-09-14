package machine.discounts;

import machine.Discount;

public class FreeTicket implements Discount {

	@Override
	public double applyDiscounts(int numberOfTickets, double price) {		
		return (numberOfTickets - 1) * price;
	}
}
