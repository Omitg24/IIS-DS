package editor.ui;

import java.io.*;

import editor.core.Editor;
import editor.core.Tool;
import editor.figures.*;

public class Menu 
{
	private Editor editor;
	private BufferedReader input;
	private PrintWriter output;
	private boolean exit = false;
	
	private Tool selection, rectangle, circle, triangle;
	
	public Menu(Editor editor)
	{
		this(editor, System.in, System.out);		
	}
	
	public Menu(Editor editor, InputStream input, PrintStream output)
	{
		this(editor, new BufferedReader(new InputStreamReader(input)), new PrintWriter(output, true));
	}
	
	public Menu(Editor editor, BufferedReader input, PrintWriter output)
	{
		this.editor = editor;
		this.input = input;
		this.output = output;
		selection = editor.getDefaultTool();
		rectangle = new RectangleCreationTool(editor);	
		circle = new CircleCreationTool(editor);
		triangle = new TriangleCreationTool(editor);
	}
	
	public void run() throws IOException
	{
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
	
	private void askUser() throws IOException
	{
		output.print("> ");
		output.flush();
		String[] tokens = input.readLine().split("[ ]", 2);
		String action = tokens[0];
				
		// En primer lugar, las acciones que requieren parámetros
		//
		if (action.equals("pulsar") || action.equals("mover")) {
			try {				
				// La siguiente  línea es para que funcione independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				if (action.equals("pulsar"))
					editor.clickedOn(x, y);
				else if (action.equals("mover"))
					editor.movedTo(x, y);
				else
					throw new AssertionError("¡Sólo puede ser pulsar o mover!");
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				output.printf("Error de sintaxis: faltan las coordenadas: %s <x>, <y>%n", action);
			}
			return;
		}
		
		// Para el resto de las acciones, que no requieren parámetros, comprueba
		// que efectivamente no se les pase ninguno (por usabilidad, para que el
		// usuario se dé cuenta de que la última acción no funciona como él esperaba). 
		// Por ejemplo, si por equivocación tecleó:
		//
		// 		"soltar 200, 345"
		//
		// cuando realmente esas coordenadas no son tenidas en cuenta (se debería haber
		// llamado previamente a "mover 200, 345" y luego simplemente "soltar").
		//
		if (tokens.length > 1) {
			output.printf("Error de sintaxis: \"%s\" no tiene parámetros%n", action);
			return;
		}
		
		if (action.equals("soltar")) {
			editor.released();
		} else if (action.equals("dibujar")) {
			editor.drawDocument();
		} else if (action.equals("ayuda")) {
			showHelp();
		} else if (action.equals("salir")) {
			exit = true;
		//-- Para las herramientas, si se desea, se podría haber utilizado un diccionario
		} else if (action.equals("seleccion")) {
			editor.selectTool(selection);
		} else if (action.equals("rectangulo")) {
			editor.selectTool(rectangle);
		} else if (action.equals("circulo")) {
			editor.selectTool(circle);
		} else if (action.equals("triangulo")) {
			editor.selectTool(triangle);
		} else {
			output.println("Acción desconocida");
			showHelp();
		}
	}
}
