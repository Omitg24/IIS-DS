package model;

import google.maps.Coordinates;

public class Photo 
{
	private String description;
	
	// Información del usuario que ha subido la foto
	private String user;
	
	// Coordenadas donde está tomada la foto
	private Coordinates coordinates;

	public Photo(String description, String user, Coordinates coordinates) 
	{
		this.description = description;
		this.user = user;
		this.coordinates = coordinates;
	}

	public String getDescription() 
	{
		return description;
	}

	public String getUser() 
	{
		return user;
	}

	public Coordinates getCoordinates() 
	{
		return coordinates;
	}

	public void show() 
	{
		System.out.printf("Abriendo la foto %s...\n",description);
	}
}
