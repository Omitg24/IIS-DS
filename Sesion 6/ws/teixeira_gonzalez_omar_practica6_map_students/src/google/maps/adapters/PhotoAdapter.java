package google.maps.adapters;

import google.maps.Coordinates;
import google.maps.GPS;
import google.maps.MapElement;
import model.Photo;

/**
 * Titulo: Clase PhotoAdapter
 *
 * @author Omar Teixeira González, UO281847
 * @version 24 oct 2022
 */
public class PhotoAdapter implements MapElement {
	/**
	 * Atributo monument
	 */
	private Photo photo;
	/**
	 * Atributo gps
	 */
	private GPS gps;
	
	/**
	 * Constructor MonumentAdapter
	 * @param monument
	 */
	public PhotoAdapter(Photo photo) {
		this.photo=photo;
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
		return photo.getCoordinates();
	}

	/**
	 * Método getHTMLInfo
	 * @return string
	 */
	@Override
	public String getHTMLInfo() {
		return photo.toString();
	}

	/**
	 * Método open
	 */
	@Override
	public void open() {
		photo.show();
	}
}
