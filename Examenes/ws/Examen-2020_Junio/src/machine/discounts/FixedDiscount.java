package machine.discounts;

import machine.Discount;

public class FixedDiscount implements Discount {

	private double amountToDiscount;
	
	public FixedDiscount(double amountToDiscount) {
		this.amountToDiscount = amountToDiscount;
	}
	
	@Override
	public double applyDiscounts(int numberOfTickets, double price) {		
		return (numberOfTickets * price) - this.amountToDiscount;
	}

}
