package machine;

public interface PaymentMode {
	String getPaymentMethod();
	boolean pay(Machine machine, double amountToPay);
}
