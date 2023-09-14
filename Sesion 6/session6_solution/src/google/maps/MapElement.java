package google.maps;

public interface MapElement 
{
	String getTitle();
	Coordinates getCoordinates();
	String getHTMLInfo();
	void open();
}
