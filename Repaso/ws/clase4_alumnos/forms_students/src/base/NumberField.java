package base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberField implements Field {

	private String etiqueta;

	public NumberField(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	@Override
	public void askData() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = true;
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();

				for (char ch : texto.toCharArray()) {
					if (!Character.isDigit(ch)) {
						valido = false;
						break;
					}
				}
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valido);
	}

	@Override
	public String getString() {
		return texto;
	}

	private String texto;
}
