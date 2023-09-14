package ui;

import java.io.*;

import poll.Poll;

/**
 * Titulo: Clase Interviewer
 *
 * @author Omar Teixeira González, UO281847
 * @version 9 nov 2022
 */
public class Interviewer 
{
	/**
	 * Atributo input
	 */
	private BufferedReader input;

	/**
	 * Método fill
	 * @param poll
	 * @throws IOException
	 */
	public void fill(Poll poll) throws IOException 
	{
		input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Acciones: [sí] / [no]");

		while (true) {
			System.out.println();
			System.out.println("Pregunta: " + poll.getQuestion());
			System.out.print(">");

			String[] line = input.readLine().split(" ");
			// (no se comprueba que el número de palabras sea el adecuado)

			if (line[0].toLowerCase().equals("salir"))
				return;

			if (line[0].toLowerCase().equals("sí") || line[0].toLowerCase().equals("si"))
				poll.incrementYeses();

			if (line[0].toLowerCase().equals("no"))
				poll.incrementNos();
		}
	}
}

