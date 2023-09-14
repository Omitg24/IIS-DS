package machine.paymentModes;

import machine.Machine;
import machine.PaymentMode;
import paypal.PayPalAPI;

public class PayPalPaymentMode implements PaymentMode {

	private PayPalAPI paypalApi;
		
	public PayPalPaymentMode() {
		this.paypalApi = new PayPalAPI();
	}
	@Override
	public String getPaymentMethod() {
		return "Pago con PayPal";
	}

	@Override
	public boolean pay(Machine machine, double amountToPay) {
		machine.getDisplay().show("Nombre de usuario: ");
		String username = machine.getKeyboard().readString();
		machine.getDisplay().show("Contraseña: ");
		String password = machine.getKeyboard().readString();
		String token = this.paypalApi.logIn(username, password);
		return this.paypalApi.checkout(token, amountToPay);	
	}
}
