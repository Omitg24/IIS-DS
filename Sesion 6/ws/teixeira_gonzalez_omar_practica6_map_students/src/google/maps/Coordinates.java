package google.maps;

/**
 * Titulo: Clase Coordinates
 *
 * @author Omar Teixeira González, UO281847
 * @version 24 oct 2022
 */
public class Coordinates 
{
	/**
	 * Atributo longitude
	 */
	private double longitude;
	/**
	 * Atributo latitude
	 */
	private double latitude;

	/**
	 * Constructor Coordinates
	 * @param longitude
	 * @param latitude
	 */
	public Coordinates(double longitude, double latitude) 
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/**
	 * Método getLongitude
	 * @return longitude
	 */
	public double getLongitude() 
	{
		return longitude;
	}
	
	/**
	 * Método getLatitude
	 * @return latitude
	 */
	public double getLatitude() 
	{
		return latitude;
	}

	/**
	 * Método toString
	 * @return string
	 */
	@Override
	public String toString() 
	{
		return "[longitude = " + longitude + ", latitude = " + latitude + "]";
	}
}