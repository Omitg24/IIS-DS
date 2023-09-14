package outputs;

import java.io.*;

/**
 * Titulo: Clase Output
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public interface Output 
{
	/**
	 * Método send
	 */
	void send(char c) throws IOException;
	/**
	 * Método close
	 * @throws IOException
	 */
	void close() throws IOException;
}
