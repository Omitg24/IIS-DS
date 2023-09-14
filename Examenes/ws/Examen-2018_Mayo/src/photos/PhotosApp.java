package photos;

import java.io.FileNotFoundException;
import java.io.IOException;

import photos.model.*;
import photos.ui.Menu;

public class PhotosApp 
{
	private Editor editor;
	private Photo toranda, bodegon, helado, retrato, urriellu;
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		new PhotosApp().run();
	}
	
	public void run() throws FileNotFoundException, IOException
	{
		setUp();
				
		// ejecuta una versión interactiva del programa
		new Menu(editor).run();
		
		// simula una interacción de usuario específica leída de un fichero de entrada
		// y escribe la salida en otro fichero (a modo de prueba)
//		new Menu(editor, "test1.txt", "test1.out.txt").run();
	}
	
	
	//-- Inicialización
	
	private void setUp()
	{
		// se crea el editor
		editor = new Editor();
		// creamos unas cuantas fotografías de prueba
		toranda = new Photo("toranda.jpg");
		bodegon = new Photo("bodegon.jpg");
		helado = new Photo("helado.tiff");
		retrato = new Photo("retrato.tiff");
		urriellu = new Photo("urriellu.jpg");
		// y se añaden a la biblioteca
		editor.addPhoto(toranda);
		editor.addPhoto(bodegon);
		editor.addPhoto(helado);
		editor.addPhoto(retrato);
		editor.addPhoto(urriellu);	
	}
}
