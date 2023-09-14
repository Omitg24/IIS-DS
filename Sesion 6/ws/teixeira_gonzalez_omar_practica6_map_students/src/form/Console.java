package form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Titulo: Clase Console
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class Console {
	/**
	 * Método readLine
	 * @return String
	 */
	public static String readLine() 
	{
		do {
			try {
				return console.readLine();
			} catch (IOException ex) {
				System.out.println("Error de lectura: inténtelo de nuevo");
			}
		} while (true);
	}

	/**
	 * Atributo console
	 */
	private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
}
