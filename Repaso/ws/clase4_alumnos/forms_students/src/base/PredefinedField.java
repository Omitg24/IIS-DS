package base;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PredefinedField implements Field {

	private String etiqueta;
	private String[] valores;

	public PredefinedField(String etiqueta, String... valores) {
		this.etiqueta = etiqueta;
		this.valores = valores;
	}

	@Override
	public void askData() {
		BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

		boolean valido;
		do {
			valido = false;
			try {
				System.out.print(etiqueta + ": ");
				texto = consola.readLine();

				for (String valor : valores) {
					if (texto.toLowerCase().equals(valor.toLowerCase())) {
						valido = true;
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
