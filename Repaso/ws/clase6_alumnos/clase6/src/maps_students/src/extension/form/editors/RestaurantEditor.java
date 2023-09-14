package extension.form.editors;

import extension.form.Editor;
import extension.model.Restaurant;

public class RestaurantEditor extends Editor {

	private Restaurant restaurant;
		
	public RestaurantEditor(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	protected void editFields() {
		System.out.print(" - Nombre: ");
		String value = readLine();
		if (value.length() > 0) {
			this.restaurant.setName(value);
		}

		System.out.print(" - Dirección: ");
		value = readLine();
		if (value.length() > 0) {
			this.restaurant.setAddress(value);
		}
	}

	@Override
	protected void printFields() {
		System.out.println(" - Nombre: " + this.restaurant.getName());
		System.out.println(" - Dirección: " + this.restaurant.getAddress());
	}
	
	@Override
	protected void showInfo() {
		System.out.println("Editando el restaurante...");
	}
}
