package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import action.Action;
import action.Delete;
import action.Execute;
import action.Insert;
import action.Open;
import action.Replace;
import main.Editor;

public class UserInterface {
	
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private Editor editor;
	private boolean saving;
	
	public UserInterface(Editor editor) {
		this.editor=editor;
	}
	
	public void run() throws IOException {		
		showInfo();
		
		do {
			System.out.print("> ");

			askUser();

			System.out.println(editor.getTexto());
			
		} while (true);
	}
	
	private void showInfo() {
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
	
	private void askUser() throws IOException {
		String[] line = in.readLine().split(" ");
		
		// No se comprueba que el número de palabras sea el adecuado			
		if (line[0].equals("salir"))
			return;
		
			
		if (line[0].equals("abre")) {
			addOrExecute(new Open(line[1]));
		} else if (line[0].startsWith("ins")) {
			addOrExecute(new Insert(line));
		} else if (line[0].startsWith("borr")) {
			addOrExecute(new Delete());
		} else if (line[0].startsWith("reem")) {
			addOrExecute(new Replace(line));
		} else if (line[0].startsWith("graba")) {
			editor.añadirMacro(line[1]);
			this.saving = true;
		} else if (line[0].startsWith("para")) {
			editor.parar();
			this.saving = false;;
		} else if (line[0].startsWith("ejecuta")) {
			addOrExecute(new Execute(line[1]));
		} else {
			System.out.println("Instrucción desconocida");
		}
	}
	
	private void addOrExecute(Action action) {
		if (this.saving) {
			editor.añadirAccion(action);
		} else {
			action.execute();
		}
	}
}
