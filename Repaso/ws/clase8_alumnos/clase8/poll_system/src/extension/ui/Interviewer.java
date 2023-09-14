package extension.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import extension.poll.Poll;

public class Interviewer
{
	private BufferedReader input;

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

			if (line[0].equals("salir"))
				return;

			if (line[0].toLowerCase().equals("sí") || line[0].toLowerCase().equals("si"))
				poll.incrementYeses();

			if (line[0].toLowerCase().equals("no"))
				poll.incrementNos();
		}
	}
}

