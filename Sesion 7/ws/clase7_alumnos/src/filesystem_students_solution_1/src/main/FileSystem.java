package main;

import java.io.*;

import outputs.*;

/**
 * Titulo: Clase FileSystem
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class FileSystem
{
	/**
	 * Método copyFile
	 * @param name
	 * @param output
	 */
	public void copyFile(String name, Output output) 
	{
		try {
			FileReader reader = new FileReader(name);

			int c;
			while ((c = reader.read()) != -1)
				output.send((char) c);

			reader.close();
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}