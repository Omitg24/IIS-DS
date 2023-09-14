package form.editors;

import form.Console;
import form.EditPlace;
import model.Monument;

/**
 * Titulo: Clase MonumentEditor
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class MonumentEditor implements EditPlace
{
	/**
	 * Atributo monument
	 */
	private Monument monument;

	/**
	 * Constructor MonumentEditor
	 * @param monument
	 */
	public MonumentEditor(Monument monument) 
	{
		this.monument=monument;
	}

	/**
	 * Método edit
	 */
	@Override
	public void edit() {
		System.out.println("\nEditando el monumento...");

		System.out.println("Valores actuales:");
		print();

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.print(" - Autor: ");
		String value = Console.readLine();
		if (value.length() > 0)
			monument.setAuthor(value);

		System.out.print(" - Dirección: ");
		value = Console.readLine();
		if (value.length() > 0)
			monument.setAddress(value);

		System.out.println("Valores finales:");
		print();
	}

	/**
	 * Método print
	 */
	@Override
	public void print() {
		System.out.println(" - Autor: " + monument.getAuthor());
		System.out.println(" - Dirección: " + monument.getAddress());
	}
}
