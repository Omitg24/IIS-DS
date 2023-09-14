package model;

import google.maps.Coordinates;

/**
 * Titulo: Clase Photo
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class Photo
{
	/**
	 * Atributo description
	 */
	private String description;
	
	// Información del usuario que ha subido la foto
	/**
	 * Atributo user
	 */
	private String user;
	
	// Coordenadas donde está tomada la foto
	/**
	 * Atributo coordinates
	 */
	private Coordinates coordinates;

	/**
	 * Constructor Photo
	 * @param description
	 * @param user
	 * @param coordinates
	 */
	public Photo(String description, String user, Coordinates coordinates) 
	{
		this.description = description;
		this.user = user;
		this.coordinates = coordinates;
	}

	/**
	 * Método setDescription
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Método setUser
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Método setCoordinates
	 * @param coordinates
	 */
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	/**
	 * Método getDescription
	 * @return description
	 */
	public String getDescription() 
	{
		return description;
	}

	/**
	 * Método getUser
	 * @return user
	 */
	public String getUser() 
	{
		return user;
	}

	/**
	 * Método getCoordinates
	 * @return coordinates
	 */
	public Coordinates getCoordinates() 
	{
		return coordinates;
	}

	/**
	 * Método show
	 */
	public void show() 
	{
		System.out.printf("Abriendo la foto %s...\n",description);
	}

	/**
	 * Método toString
	 */
	@Override
	public String toString() {
		return "\nPhoto [description=" + description + ", user=" + user + ", coordinates=" + coordinates + "]";
	}	
}
