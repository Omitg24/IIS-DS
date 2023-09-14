package base.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import base.editor.Drawing;
import base.editor.Editor;

public class Main
{
	private Editor editor;
	private boolean exit;
	private BufferedReader input;
	private PrintStream output;

	public static void main(String[] args) throws IOException
	{
		new Main().run();
	}

	public void run() throws IOException
	{
		editor = new Editor(new Drawing());
		input = new BufferedReader(new InputStreamReader(System.in));
		output = System.out;

		showHelp();
		while (!exit) {
			askUser();
		}
		output.println("¡Adios!");
		return;
	}

	private void showHelp()
	{
		output.println("");
		output.println("Herramientas: seleccion - rectangulo - circulo - triangulo");
		output.println("Acciones del ratón: pulsar <x>,<y> - mover <x>,<y> - soltar");
		output.println("Otras acciones: dibujar - ayuda - salir");
		output.println("-----------------------------------------------------------");
	}

	@SuppressWarnings("unused")
	private void askUser() throws IOException
	{
		output.print("> ");
		output.flush();
		String[] tokens = input.readLine().split("[ ]", 2);
		String action = tokens[0];

		// Comprueba que a las acciones que no requieren parámetros, efectivamente no se les
		// pase ninguno (por usabilidad, para que el usuario se dé cuenta de que la última
		// acción no funciona como él esperaba). Por ejemplo, si por equivocación tecleó:
		//
		// 		"soltar 200, 345"
		//
		// cuando realmente esas coordenadas no son tenidas en cuenta (se debería haber
		// llamado previamente a "mover 200, 345" y luego simplemente "soltar").
		//
		if (action.equals("seleccion") || action.equals("rectangulo") ||
				action.equals("circulo") || action.equals("triangulo") ||
				action.equals("soltar") || action.equals("dibujar") ||
				action.equals("ayuda") || action.equals("salir")) {
			if (tokens.length > 1) {
				output.printf("Error de sintaxis: \"%s\" no tiene parámetros\n", action);
				return;
			}
		}

		if (action.equals("salir")) {
			exit = true;
		} else if (action.equals("seleccion")) {
			// TODO: editor.______(...);
		} else if (action.equals("rectangulo")) {
			// TODO: editor.______(...);
		} else if (action.equals("circulo")) {
			// TODO: editor.______(...);
		} else if (action.equals("triangulo")) {
			// TODO: editor.______(...);
		} else if (action.equals("pulsar")) {
			try {
				// la siguiente línea es para que funcione independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				// TODO: editor.______(...);
			} catch (NumberFormatException e) {
				output.println("Error de sintaxis: se esperaban las coordenadas del punto en que se hizo clic: pulsar <x>, <y>");
			}
		} else if (action.equals("mover")) {
			try {
				// la siguiente línea es para que funcione independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				// TODO: editor.______(...);
			} catch (NumberFormatException e) {
				output.println("Error de sintaxis: se esperaban las coordenadas del punto adonde se movió el cursor: mover <x>, <y>");
			}
		} else if (action.equals("soltar")) {
			// TODO: editor.______(...);
		} else if (action.equals("dibujar")) {
			editor.drawDocument();
		} else if (action.equals("ayuda")) {
			showHelp();
		} else {
			output.println("Acción desconocida");
			showHelp();
		}
	}
}
