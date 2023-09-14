package extension.editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import extension.editor.actions.*;

public class UserInterface {
	
	private Editor editor;
	
	private Manager manager;
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	public UserInterface(Editor editor, Manager manager) {
		this.editor = editor;
		this.manager = manager;
	}
	
	public void run() throws IOException {
		showHelp();		
		do {
			askData();
		} while (true);
	}
	
	private void askData() throws IOException {
		System.out.print("> ");

		String[] line = in.readLine().split(" ");
		
		// No se comprueba que el número de palabras sea el adecuado

		if (line[0].equals("salir"))
			return;

		if (line[0].equals("abre")) {
			this.manager.execute(new Open(line[1]));
		} else if (line[0].startsWith("ins")) {
			this.manager.execute(new Insert(line));
		} else if (line[0].startsWith("borr")) {
			this.manager.execute(new Delete());
		} else if (line[0].startsWith("reem")) {
			this.manager.execute(new Replace(line[1], line[2]));
		} else if (line[0].startsWith("graba")) {
			this.manager.recordNewMacro(line[1]);
		} else if (line[0].startsWith("para")) {
			this.manager.stopRecording();
		} else if (line[0].startsWith("ejecuta")) {
			this.manager.executeMacro(line[1]);
		} else {
			System.out.println("Instrucción desconocida");
		}

		System.out.println(editor.getText());
	}
	
	private void showHelp() {
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
	}
}
