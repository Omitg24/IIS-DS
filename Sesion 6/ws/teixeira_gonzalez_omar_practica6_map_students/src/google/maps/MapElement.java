package google.maps;

/**
 * Titulo: Interfaz MapElement
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public interface MapElement 
{
	/**
	 * Método getTitle
	 * @return String
	 */
	String getTitle();
	
	/**
	 * Método getCoordinates
	 * @return
	 */
	Coordinates getCoordinates();
	
	/**
	 * Método getHTMLInfo
	 * @return
	 */
	String getHTMLInfo();
	
	/**
	 * Método open
	 */
	void open();
}
