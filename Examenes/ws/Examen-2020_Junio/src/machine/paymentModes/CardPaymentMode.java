package machine.paymentModes;

import machine.Machine;
import machine.PaymentMode;

public class CardPaymentMode implements PaymentMode {

	@Override
	public String getPaymentMethod() {		
		return "Pago con tarjeta";
	}

	@Override
	public boolean pay(Machine machine, double amountToPay) {
		String cardNumber = machine.getCardReader().readCardNumber();
		boolean isValid = machine.getBankGateway().pay(cardNumber, amountToPay);
		if (!isValid) {
			machine.getDisplay().show("Tarjeta rechazada\n");
			return false;
		}
		// pago correcto
		machine.getDisplay().show("Tarjeta aceptada: pago realizado con éxito\n");
		return true;
	}

}
