package form.editors;

import form.Console;
import form.EditPlace;
import model.Photo;

/**
 * Titulo: Clase PhotoEditor
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class PhotoEditor implements EditPlace
{
	/**
	 * Atributo photo
	 */
	private Photo photo;
	
	/**
	 * Constuctor PhotoEditor
	 * @param photo
	 */
	public PhotoEditor(Photo photo) 
	{
		this.photo=photo;
	}
	
	/**
	 * Método edit
	 */
	@Override
	public void edit() {
		System.out.println("\nEditando la foto...");

		System.out.println("Valores actuales:");
		print();

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.print(" - Usuario: ");
		String value = Console.readLine();
		if (value.length() > 0)
			photo.setUser(value);

		System.out.print(" - Descripción: ");
		value = Console.readLine();
		if (value.length() > 0)
			photo.setDescription(value);

		System.out.println("Valores finales:");
		print();
	}

	/**
	 * Método print
	 */
	@Override
	public void print() {
		System.out.println(" - User: " + photo.getUser());
		System.out.println(" - Descripción: " + photo.getDescription());
	}
}
