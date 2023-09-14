package form.main;

import form.Form;
import form.editors.MonumentEditor;
import form.editors.PhotoEditor;
import form.editors.RestaurantEditor;
import google.maps.*;
import model.*;

/**
 * Titulo: Clase Main
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class Main 
{
	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Monument coliseo = new Monument("Coliseo", "Vespasiano", "Piazza del Colosseo, 1, 00184 Roma, Italia");
		Photo photoColosseum = new Photo("Colosseum in Rome, Italy - April 2007", "DAVID ILIFF", new Coordinates(20, 20));
		Restaurant tavernaDeiFori = new Restaurant("La Taverna dei Fori Imperiali", 
				"via Madonna dei Monti, 9, 00184 Roma, Italia", "+39 06 6798643");
		
		Form form = new Form();
		form.edit(new MonumentEditor(coliseo));
		
		// Tarea 1. Editar también el restaurante: que se puedan editar el nombre y la dirección
		form.edit(new RestaurantEditor(tavernaDeiFori));
		
		// Tarea 2. Editar también la foto (usuario y descripción)
		form.edit(new PhotoEditor(photoColosseum));
	}
}
