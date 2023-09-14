package form.editors;

import form.Console;
import form.EditPlace;
import model.Restaurant;

/**
 * Titulo: Clase RestaurantEditor
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class RestaurantEditor implements EditPlace
{
	/**
	 * Atributo restaurant
	 */
	private Restaurant restaurant;
	
	/**
	 * Constructor RestaurantEditor
	 * @param restaurant
	 */
	public RestaurantEditor(Restaurant restaurant) 
	{
		this.restaurant = restaurant;
	}

	/**
	 * Método edit
	 */
	@Override
	public void edit() {
		System.out.println("\nEditando el restaurante...");

		System.out.println("Valores actuales:");
		print();

		System.out.println("Escriba nuevos valores (dejar en blanco para dejar el valor actual):");
		System.out.print(" - Nombre: ");
		String value = Console.readLine();
		if (value.length() > 0)
			restaurant.setName(value);

		System.out.print(" - Dirección: ");
		value = Console.readLine();
		if (value.length() > 0)
			restaurant.setAddress(value);

		System.out.println("Valores finales:");
		print();
	}

	/**
	 * Método print
	 */
	@Override
	public void print() {
		System.out.println(" - Nombre: " + restaurant.getName());
		System.out.println(" - Dirección: " + restaurant.getAddress());
	}
}
