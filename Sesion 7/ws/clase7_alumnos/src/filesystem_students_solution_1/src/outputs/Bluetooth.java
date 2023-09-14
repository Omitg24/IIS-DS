package outputs;

import java.io.*;

/**
 * Titulo: Clase Bluetooth
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class Bluetooth implements Output 
{
	/**
	 * Constructor Bluetooth
	 * @param device
	 */
	public Bluetooth(String device) 
	{
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START Bluetooth [" + device + "]\n");
	}

	/**
	 * Método send
	 */
	public void send(char c) throws IOException 
	{
		stringWriter.append(c);
	}

	/**
	 * Método close
	 */
	public void close() throws IOException 
	{
		System.out.print(stringWriter.toString());
		System.out.println("\n--- END   Bluetooth");
	}

	/**
	 * Atributo stringWriter
	 */
	private StringWriter stringWriter;
}
