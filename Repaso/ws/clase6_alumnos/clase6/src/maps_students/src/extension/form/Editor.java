package extension.form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Editor {
	
	private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

	public void edit() {
		showInfo();

		System.out.println("Valores actuales:");
		printFields();

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		editFields();

		System.out.println("Valores finales:");
		printFields();
	}
	
	protected String readLine()
	{
		do {
			try {
				return console.readLine();
			} catch (IOException ex) {
				System.out.println("Error de lectura: inténtelo de nuevo");
			}
		} while (true);
	}
	
	protected abstract void editFields();
	
	protected abstract void printFields();
	
	protected abstract void showInfo();
}
