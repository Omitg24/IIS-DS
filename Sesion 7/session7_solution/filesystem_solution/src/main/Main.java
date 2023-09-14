package main;

import java.io.*;

import filesystem.FileSystem;
import outputs.*;
import outputs.filters.*;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();

		//-- Diseño de Referencia
		//   Cambios: Añadir 3 clases (LinesFilter, SpacesFilter y Encriptor)
		//-------------------------------------------------------------------
		system.copyFile("privado.txt", new LinesFilter(new FileOutput("privado2.txt")));
		system.copyFile("privado.txt", new Encryptor(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new Encryptor(new SpacesFilter(new Bluetooth("Galaxy de Raúl"))));

		
		//-- Modificación 1: que se pueda encriptar al escribir en fichero
		//   Cambios: Ninguno
		//-------------------------------------------------------------------
		system.copyFile("privado.txt", new LinesFilter(new FileOutput("a.txt")));
		system.copyFile("privado.txt", new LinesFilter(new Encryptor(new FileOutput("b.txt"))));

		
		//-- Modificación 2: en Internet que se pueda normalizar y/o eliminar espacios
		//   Cambios: Ninguno
		//-------------------------------------------------------------------
		system.copyFile("privado.txt", new LinesFilter(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new SpacesFilter(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new SpacesFilter(new LinesFilter(new Internet("156.17.11.196"))));

		
		//-- Modificación 3: Contar caracteres escritos
		//   Cambios: Añadir clase Counter
		//-------------------------------------------------------------------
		Counter counter = new Counter(new Internet("156.17.11.196"));
		system.copyFile("privado.txt", new LinesFilter(counter));
		System.out.println("Modificacion 3a: " + counter.getCounter());

		// (Otra forma de hacerlo:)
		system.copyFile("privado.txt", new LinesFilter(counter = new Counter(new Internet("156.17.11.196"))));
		System.out.println("Modificacion 3b: " + counter.getCounter());

		
		//-- Modificación 4: Poder contar caracteres también antes de normalizar
		//   Cambios: ninguno
		//-------------------------------------------------------------------
		Counter after = new Counter((new Internet("156.17.11.196")));
		Counter before = new Counter(new LinesFilter(after));
		system.copyFile("privado.txt", before);
		System.out.println("Modificacion 4a: " + before.getCounter() + " -> " + after.getCounter());

		// Otra forma de hacerlo:
		system.copyFile("privado.txt", before = new Counter(new LinesFilter(after = new Counter((new Internet("156.17.11.196"))))));
		System.out.println("Modificacion 4b: " + before.getCounter() + " -> " + after.getCounter());

		//-- Modificación 5: Poder contar caracteres también antes de normalizar
		//   Cambios: Añadir clase Fork
		//-------------------------------------------------------------------
		system.copyFile("privado.txt", new Encryptor(new Fork(new Internet("156.17.11.196"), new Bluetooth("Galaxy de Raúl"))));
	}
}
