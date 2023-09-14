package extension.main;

import java.io.IOException;

import extension.editor.Editor;
import extension.editor.Manager;
import extension.editor.UserInterface;

public class Main {
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		UserInterface ui = new UserInterface(editor, new Manager(editor));
		try {
			ui.run();
		} catch (IOException e) {
			System.out.println("Excepción de Entrada/Salida capturada");
		}		
	}
}
