package ruralvia;

/*
 	Esta clase es proporcionada por nuestro banco y representa el cliente que se
 	encarga de la comunicación con su pasarela de pagos para realizar los pagos
 	con tarjeta. En nuestra simulación únicamente se utiliza el número de tarjeta
 	para determinar si la tarjeta es válida o no, y se simula lo que sería la
 	comunicación con el banco simplemente escribiendo en la consola.
 	
 	Nota: ESTA CLASE NO SE PUEDE MODIFICAR.
 	      --------------------------------
 */
public class BankGateway 
{
	private static final String[] validCreditCards = { "1111", "2222", "3333" };
	
	public boolean pay(String cardNumber, double amount) 
	{
		if (!isValid(cardNumber))
			return false;
		String messageOk = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>%n" +
				"Pagando en el banco...%n" +
				"Nº de tarjeta: %s%n" +
				"Importe: %.2f €%n" +
				">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>%n";
		System.out.printf(messageOk, cardNumber, amount);
		return true;
	}
	
	private boolean isValid(String cardNumber)
	{
		for (int i = 0; i < validCreditCards.length; i++) {
			if (validCreditCards[i].equals(cardNumber))
				return true;
		}
		return false;
	}
}
