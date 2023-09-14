package extension.main;

import extension.form.Form;
import extension.form.editors.MonumentEditor;
import extension.form.editors.PhotoEditor;
import extension.form.editors.RestaurantEditor;
import extension.google.maps.Coordinates;
import extension.model.Monument;
import extension.model.Photo;
import extension.model.Restaurant;

public class Main
{
	public static void main(String[] args)
	{
		Monument coliseo = new Monument("Coliseo", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia");
		Photo photoColosseum = new Photo("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20));
		Restaurant tavernaDeiFori = new Restaurant("La Taverna dei Fori Imperiali",
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643");

		Form form = new Form();
		form.edit(new MonumentEditor(coliseo));
		System.out.println();
		// Tarea 1. Editar también el restaurante: que se puedan editar el nombre y la dirección
		form.edit(new RestaurantEditor(tavernaDeiFori));
		System.out.println();
		// Tarea 2. Editar también la foto (usuario y descripción)
		form.edit(new PhotoEditor(photoColosseum));
	}

}
