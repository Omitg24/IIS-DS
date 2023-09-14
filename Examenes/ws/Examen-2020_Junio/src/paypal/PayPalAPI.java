package paypal;

import java.util.*;

/*
 	Esta clase representa el cliente de la API de PayPal, y se encarga de simular
 	la comunicación con el servidor para realizar pagos a través de la plataforma.
 	Para ello primero el usuario debe registrarse: si el nombre de usuario y
 	contraseña son correctos se generará un token válido. Posteriormente, habrá
 	que llamar al método "checkout" proporcionando dicho token y el importe a pagar.
 	Devolverá verdadero si el pago fue correcto y falso en caso contrario.
 	
 	Ejemplo de uso:
 	
 		PayPalAPI payPal = new PayPalAPI();
 		// pedir el nombre de usuario y contraseña
 		String username = ...
 		String password = ...
 		String token = payPal.logIn(username, password);
 		boolean isValid = payPal.checkout(token, 60.0);
 		
 	También proporciona un método isLogged(token) que permite saber si se ha iniciado
 	sesión o no.
 		
 	Nota: ESTA CLASE NO SE PUEDE MODIFICAR.
 	      --------------------------------
 */
public class PayPalAPI 
{
	public static final String INVALID_LOGIN = "invalid login";

	private static final int USERNAME = 0;
	private static final int PASSWORD = 1;
	
	private String[][] users = { 
			{"ana@gmail.com", "ana"},
			{"juan@gmail.com", "juan"},
			{"lucia@uniovi.es", "lucia"}
	};
		
	private List<String> sessionTokens = new ArrayList<>();
	private Random random = new Random();
	
	public String logIn(String username, String password)
	{
		for (Object[] user : users) {
			if (user[USERNAME].equals(username) && user[PASSWORD].equals(password)) {
				String sessionToken = generateToken();
				sessionTokens.add(sessionToken);
				return sessionToken;
			}
		}
		return INVALID_LOGIN;
	}
	
	private String generateToken()
	{
		return String.valueOf(random.nextLong()); 
	}
	
	public boolean isLogged(String token)
	{
		return sessionTokens.contains(token);
	}
	
	public boolean checkout(String token, double amount)
	{
		if (!isLogged(token)) {
			System.out.println("PayPal: no se ha iniciado sesión, no se puede realizar el pago");
			return false;
		}
		System.out.printf("PayPal: se ha realizado un pago de %.2f €%n", amount);
		return true;
	}
}
