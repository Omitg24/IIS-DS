package editor.ui;

import java.io.*;
import java.util.Arrays;

import editor.Editor;

public class EditorTextUI 
{
	private static BufferedReader in;
	private Editor editor;
	
	public EditorTextUI(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("La interfaz de usuario necesita una referencia al editor");
		this.editor = editor;
	}
	
	public void run() throws IOException
	{
		in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Acciones");
		System.out.println("--------");
		System.out.println("abre <fichero>");
		System.out.println("inserta <texto>\t\t// inserta las palabras al final del texto");
		System.out.println("borra\t\t\t// borra la última palabra");
		System.out.println("reemplaza <a> <b>\t// reemplaza la cadena <a> por la <b> en todo el texto");
		System.out.println("salir");
		System.out.println();
		System.out.println("Tareas");
		System.out.println("------");
		System.out.println("graba <macro>\t\t// comienza la grabación de una macro");
		System.out.println("para\t\t\t// finaliza la grabación");
		System.out.println("ejecuta <macro>\t\t// ejecuta la macro cuyo nombre se indique");
		System.out.println();

		do {
			System.out.print("> ");

			String[] line = in.readLine().split(" ");
			
			// No se comprueba que el número de palabras sea el adecuado

			if (line[0].equals("salir"))
				return;

			if (line[0].equals("abre")) {
				editor.open(line[1]);
			}  else if (line[0].startsWith("ins")) {
				String[] wordsToAppend = Arrays.copyOfRange(line, 1, line.length);
				editor.insert(wordsToAppend);
			} else if (line[0].startsWith("borr")) {
				editor.removeLastWord();
			} else if (line[0].startsWith("reem")) {
				editor.replace(line[1], line[2]);
			} else if (line[0].startsWith("graba")) {
				editor.recordMacro(line[1]);
			} else if (line[0].startsWith("para")) {
				editor.stop();
			} else if (line[0].startsWith("ejecuta")) {
				editor.executeMacro(line[1]);
			} else {
				System.out.println("Instrucción desconocida");
			}

			System.out.println(editor.getText());
		} while (true);
	}
}
