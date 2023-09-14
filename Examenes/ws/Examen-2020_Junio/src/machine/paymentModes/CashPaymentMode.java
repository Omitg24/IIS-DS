package machine.paymentModes;

import machine.Machine;
import machine.PaymentMode;

public class CashPaymentMode implements PaymentMode {

	@Override
	public String getPaymentMethod() {
		return "Pago en efectivo";
	}

	@Override
	public boolean pay(Machine machine, double amountToPay) {
		int insertedAmount = 0;
		boolean cancel = false;
		machine.getBillAcceptor().reset();
		do {
			machine.getDisplay().show(String.format("Quedan por pagar %.2f €%n", amountToPay - insertedAmount));
			double inserted = machine.getBillAcceptor().insertBill();
			insertedAmount = machine.getBillAcceptor().getTotalAmount();
			if (inserted == 0)
				cancel = true;
		} while (insertedAmount < amountToPay && !cancel);
		
		if (cancel) {
			machine.getDisplay().show("Operación cancelada por el usuario\n");
			// si antes de cancelar había introducido dinero, se le devuelve
			if (insertedAmount > 0)
				machine.getBillAcceptor().returnChange(insertedAmount);
			return false;
		}
		machine.getDisplay().show("Pago completado\n");
		// se devuelve el cambio
		if (insertedAmount > amountToPay) {
			machine.getBillAcceptor().returnChange(insertedAmount - amountToPay);
		} 
		return true;
	}

}
