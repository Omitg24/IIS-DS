package adapters.map;

import google.maps.*;
import model.Restaurant;

public class RestaurantMapElement implements MapElement
{
	private Restaurant restaurant;
	private GPS gps = new GPS();
	
	public RestaurantMapElement(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	@Override
	public String getTitle() 
	{
		return "Restaurante: " + restaurant.getName();
	}

	@Override
	public Coordinates getCoordinates() 
	{
		return gps.getCoordinates(restaurant.getAddress());
	}

	@Override
	public String getHTMLInfo() 
	{
		return restaurant.getName() + "\n" + restaurant.getAddress() + "\n" + restaurant.getPhone();
	}

	@Override
	public void open() 
	{
		restaurant.call();
	}
}
