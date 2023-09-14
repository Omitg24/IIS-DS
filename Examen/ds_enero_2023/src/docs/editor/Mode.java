package docs.editor;

import java.io.PrintWriter;

//PATRÓN STATE
//	Representa la interfaz State
//	Métodos:	
//		Request1() -> portada()
//		Request2() -> insertar()
//		Request3() -> mostrar()
public interface Mode {
	void insertar(String texto);
	void portada(String texto);
	void mostrar(PrintWriter out);
}
