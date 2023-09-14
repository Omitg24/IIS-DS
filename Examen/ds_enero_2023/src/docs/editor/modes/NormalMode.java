package docs.editor.modes;

import java.io.PrintWriter;

import docs.editor.Editor;

//PATRÓN STATE
//	Representa una de las clases ConcreteState...
//	Solo tiene uno de los métodos Request debido a la extracción de funcionalidad 
//	común a otra clase abstracta
//	Métodos:
//		Request3() -> mostrar()
public class NormalMode extends WriteMode {		
	
	public NormalMode(Editor editor) {	
		super(editor);
	}
	
	@Override
	public void mostrar(PrintWriter out) {
		out.println("Portada: " + this.editor.getDocument().getCover());
		out.println("Contenido:");
		for (String line : this.editor.getDocument().getContents()) {
			out.println(line);
		}
	}
}
