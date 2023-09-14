package outputs;

import java.io.*;

/**
 * Titulo: Clase FileOutput
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class FileOutput implements Output 
{
	/**
	 * Constructor FileOutput
	 * @param fileName
	 * @throws IOException
	 */
	public FileOutput(String fileName) throws IOException 
	{
		file = new FileWriter(fileName);
	}
	
	/**
	 * Método send
	 */
	public void send(char c) throws IOException 
	{
		file.append(c);
	}

	/**
	 * Método close
	 */
	public void close() throws IOException 
	{
		file.close();
	}

	/**
	 * Atributo file
	 */
	private FileWriter file;
}
