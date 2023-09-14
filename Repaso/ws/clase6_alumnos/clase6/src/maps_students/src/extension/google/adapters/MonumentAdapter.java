package extension.google.adapters;

import extension.google.maps.GPS;
import extension.google.maps.Coordinates;
import extension.google.maps.MapElement;
import extension.model.Monument;

public class MonumentAdapter implements MapElement {
	
	private Monument monument;		
	
	private GPS gps = new GPS();

	public MonumentAdapter(Monument monument) {	
		this.monument = monument;
	}

	@Override
	public String getTitle() {		
		return "Monumento: " + monument.getName();
	}

	@Override
	public Coordinates getCoordinates() {
		return this.gps.getCoordinates(this.monument.getAddress());
	}

	@Override
	public String getHTMLInfo() {
		return this.monument.getName() + ". Creado por " + this.monument.getAuthor() + " " + this.monument.getAddress();
	}

	@Override
	public void open() {
		System.out.println("GPS: Gire a la derecha [...] Ha llegado a su destino: " + this.monument.getAddress());
	}

}
