package outputs;

import java.io.*;

/**
 * Titulo: Clase Internet
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class Internet implements Output 
{	
	/**
	 * Constructor Internet
	 * @param url
	 */
	public Internet(String url) 
	{
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START Internet [" + url + "]\n");
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
		System.out.println("\n--- END   Internet");
	}
	
	/**
	 * Atributo stringWriter
	 */
	private StringWriter stringWriter = new StringWriter();	
}
