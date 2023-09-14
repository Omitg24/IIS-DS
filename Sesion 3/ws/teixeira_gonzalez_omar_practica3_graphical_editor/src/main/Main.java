package main;

import editor.*;

/**
 * Titulo: Clase Main
 *
 * @author Omar Teixeira González, UO281847
 * @version 3 oct 2022
 */
public class Main {	

	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args)  {
		Editor editor = new Editor(new Drawing());
		UserInterface ui = new UserInterface(editor);
		ui.run();;		
	}	
}
