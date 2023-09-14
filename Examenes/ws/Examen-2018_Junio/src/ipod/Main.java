package ipod;

import java.util.*;

import ipod.model.IPod;
import ipod.model.Song;
import ipod.ui.Controller;

public class Main 
{
	private IPod ipod;	
	private List<Song> lista1;
	private Song surfinUSA, ikoIko, noSePorqueTeQuiero, blowingInTheWind, estaTardeViLLover, livinOnAPrayer,
				totalEclipseOfTheHeart, theRiver, londonCalling, michiPanero, lasCuatroYDiez, voyAPasarmeloBien;

	public static void main(String[] args)
	{
		new Main().run();
	}
	
	private void run()
	{
		setUp();
		
		new Controller(ipod).run();
	}
	
	/**
	 * Simula la sincronización del iPod con iTunes en el ordenador para añadir música.
	 */
	private void setUp()
	{
		// creamos una lista de reproducción
		lista1 = new ArrayList<Song>();
		
		// creamos varias canciones
		surfinUSA = new Song("Surfin' USA", "The Beach Boys", "Surfin' USA.m4a");
		ikoIko = new Song("Iko Iko", "The Belle Stars", "Iko Iko.m4a");
		noSePorqueTeQuiero = new Song("No sé por qué te quiero", "Antonio García de Diego y Olga Román", "No sé por qué te quiero.m4a");
		blowingInTheWind = new Song("Blowin' In the Wind", "Bob Dylan", "Blowin' In the Wind.m4a");
		estaTardeViLLover = new Song("Esta tarde vi llover", "Armando Manzanero", "Esta tarde vi llover.m4a");
		livinOnAPrayer = new Song("Livin' On a Prayer", "Bon Jovi", "Livin' On a Prayer.m4a");
		totalEclipseOfTheHeart = new Song("Total Eclipse of the Heart", "Bonnie Tyler", "Total Eclipse of the Heart.m4a");
		theRiver = new Song("The River", "Bruce Springsteen", "The River.m4a");
		londonCalling = new Song("London Calling", "The Clash", "London Calling.m4a");
		michiPanero = new Song("El hombre que casi conoció a Michi Panero", "Nacho Vegas", "El hombre que casi conoció a Michi Panero.m4a");
		lasCuatroYDiez = new Song("Las cuatro y diez", "Luis Eduardo Aute", "Las cuatro y diez.m4a");
		voyAPasarmeloBien = new Song("Voy a pasármelo bien", "Hombres G", "Voy a pasármelo bien.m4a");
		
		// las añadimos a la lista
		lista1.add(surfinUSA);
		lista1.add(ikoIko);
		lista1.add(noSePorqueTeQuiero);
		lista1.add(blowingInTheWind);
		lista1.add(estaTardeViLLover);
		lista1.add(livinOnAPrayer);
		lista1.add(totalEclipseOfTheHeart);
		lista1.add(theRiver);
		lista1.add(londonCalling);
		lista1.add(michiPanero);
		lista1.add(lasCuatroYDiez);
		lista1.add(voyAPasarmeloBien);
		
		// se crea el iPod
		ipod = new IPod(lista1);
	}
}
