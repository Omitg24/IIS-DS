package machine.discounts;

import machine.Discount;

public class PercentageDiscount implements Discount {

	private double percentageToDiscount;
	
	public PercentageDiscount(double percentageToDiscount) {		
		this.percentageToDiscount = percentageToDiscount;
	}	

	@Override
	public double applyDiscounts(int numberOfTickets, double price) {
		double total = numberOfTickets * price;
		double discountToApply = (total * this.percentageToDiscount)/100;
		return total - discountToApply;
	}

}
