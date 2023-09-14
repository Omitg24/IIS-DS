package google.maps;

public class Coordinates 
{
	private double longitude;
	private double latitude;

	public Coordinates(double longitude, double latitude) 
	{
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() 
	{
		return longitude;
	}

	public double getLatitude() 
	{
		return latitude;
	}

	@Override
	public String toString() 
	{
		return "[longitude = " + longitude + ", latitude = " + latitude + "]";
	}
}