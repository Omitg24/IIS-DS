package extension.google.adapters;

import extension.google.maps.Coordinates;
import extension.google.maps.MapElement;
import extension.model.Photo;

public class PhotoAdapter implements MapElement {

	private Photo photo;	
	
	public PhotoAdapter(Photo photo) {
		this.photo = photo;
	}

	@Override
	public String getTitle() {
		return "Foto: " + this.photo.getDescription();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.photo.getCoordinates();
	}

	@Override
	public String getHTMLInfo() {
		return this.photo.getDescription() + " (foto de " + this.photo.getUser() + ")";
	}

	@Override
	public void open() {
		this.photo.show();
	}

}
