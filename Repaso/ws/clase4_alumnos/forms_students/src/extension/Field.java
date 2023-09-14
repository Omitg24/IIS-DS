package extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Field {

	private String label;

	private Validator validator;

	public Field(String label, Validator validator) {
		this.label = label;
		this.validator = validator;
	}

	public void askData() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

		boolean valid;
		do {
			valid = true;
			try {
				System.out.print(label + ": ");
				texto = console.readLine();

				valid = validator.validate(texto);
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!valid);
	}

	public String getString() {
		return " -> " + texto;
	}

	private String texto;
}
