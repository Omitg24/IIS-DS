package extension.google.adapters;

import extension.model.Restaurant;
import extension.google.maps.Coordinates;
import extension.google.maps.GPS;
import extension.google.maps.MapElement;

public class RestaurantAdapter implements MapElement {

	private Restaurant restaurant;	
	
	private GPS gps = new GPS();
	
	public RestaurantAdapter(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public String getTitle() {
		return "Restaurante: " + this.restaurant.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.gps.getCoordinates(this.restaurant.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return this.restaurant.getName() + " " + this.restaurant.getAddress() + " " + this.restaurant.getPhone();
	}

	@Override
	public void open() {
		this.restaurant.call();
	}

}
