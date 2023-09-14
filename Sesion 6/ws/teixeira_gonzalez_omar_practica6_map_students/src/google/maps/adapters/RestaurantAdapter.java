package google.maps.adapters;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Restaurant;

/**
 * Titulo: Clase RestaurantAdapter
 *
 * @author Omar Teixeira González, UO281847
 * @version 24 oct 2022
 */
public class RestaurantAdapter implements MapElement {
	/**
	 * Atributo monument
	 */
	private Restaurant restaurant;
	/**
	 * Atributo gps
	 */
	private GPS gps;
	
	/**
	 * Constructor MonumentAdapter
	 * @param monument
	 */
	public RestaurantAdapter(Restaurant restaurant) {
		this.restaurant=restaurant;
		this.gps = new GPS();
	}
	
	/**
	 * Método getTitle
	 * @return string
	 */
	@Override
	public String getTitle() {
		return gps.getAddress(getCoordinates());
	}

	/**
	 * Método getCoordinates
	 * @return coordinates
	 */
	@Override
	public Coordinates getCoordinates() {
		return gps.getCoordinates(restaurant.getAddress());
	}

	/**
	 * Método getHTMLInfo
	 * @return string
	 */
	@Override
	public String getHTMLInfo() {
		return restaurant.toString();
	}

	/**
	 * Método open
	 */
	@Override
	public void open() {
		restaurant.call();
	}
}
