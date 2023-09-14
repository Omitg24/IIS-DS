package google.maps.adapters;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Monument;

/**
 * Titulo: Clase MonumentAdapter
 *
 * @author Omar Teixeira González, UO281847
 * @version 24 oct 2022
 */
public class MonumentAdapter implements MapElement {
	/**
	 * Atributo monument
	 */
	private Monument monument;
	/**
	 * Atributo gps
	 */
	private GPS gps;
	
	/**
	 * Constructor MonumentAdapter
	 * @param monument
	 */
	public MonumentAdapter(Monument monument) {
		this.monument=monument;
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
		return gps.getCoordinates(monument.getAddress());
	}

	/**
	 * Método getHTMLInfo
	 * @return string
	 */
	@Override
	public String getHTMLInfo() {
		return monument.toString();
	}

	/**
	 * Método open
	 */
	@Override
	public void open() {
		gps.getDirectionsTo(monument.getAddress());
	}
}
