package main;

import java.io.IOException;

import modifiers.CountCharacters;
import modifiers.Divider;
import modifiers.Encript;
import modifiers.Normalize;
import modifiers.RemoveDuplicatedSpaces;
import outputs.Bluetooth;
import outputs.FileOutput;
import outputs.Internet;

/**
 * Titulo: Clase Main
 *
 * @author Omar Teixeira González, UO281847
 * @version 6 nov 2022
 */
public class Main 
{
	/**
	 * Método main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();
		
		//Modificaciones base
		System.out.println("|- Modificaciones base --------------------------");
		//Cambios:
		//	◦ Cuando se hace una copia de un fichero en disco (anteriormente llamado copyFile) se quiere normalizar
		//	los saltos de línea (quitar ‘\r’ y dejar solo los ‘\n’).
		//	◦ Para mandar por internet se quiere encriptar (+1 si es letra o dígito).
		//	◦ Para mandar por Bluetooth se quiere encriptar y eliminar espacios repetidos.
		system.copyFile("privado.txt", new Normalize(new FileOutput("copia.txt")));
		system.copyFile("privado.txt", new Encript(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new Encript(
				new RemoveDuplicatedSpaces(new Bluetooth("Galaxy de Raúl"))));
		
		//Modificación 1
		System.out.println("\n|- Modificación 1 -----------------------------");		
		//Cuando se haga una copia de un fichero en disco (anteriormente llamado copyFile), además de
		//normalizar (quitar ‘\r’), hay veces que también se querrá encriptar. El Main debería poder
		//indicar si al hacer la copia la quiere encriptar o no.
		System.out.println("\nSalida a ficheros");
		system.copyFile("privado.txt", new Normalize(new FileOutput("a.txt")));
		system.copyFile("privado.txt", new Normalize(
				new Encript(new FileOutput("b.txt"))));
		
		//Modificación 2
		System.out.println("\n|- Modificación 2 -----------------------------");
		//Al enviar por Internet, además de encriptar, se quiere poder indicar si hay que normalizar (quitar
		//‘\r’) y/o eliminar espacios repetidos (una de ellas o las dos).
		system.copyFile("privado.txt", new Normalize(
				new Internet("1.1.1.1")));
		system.copyFile("privado.txt", new RemoveDuplicatedSpaces(
				new Internet("1.1.1.1")));
		system.copyFile("privado.txt", new Normalize(
				new RemoveDuplicatedSpaces(new Internet("1.1.1.1"))));
		
		//Modificación 3
		System.out.println("\n|- Modificación 3 -----------------------------");
		//En los tres casos (tanto si se copia el fichero en disco como si se envía por Internet o Bluetooth)
		//se quiere saber, desde el Main, el número de caracteres copiados.
		system.copyFile("privado.txt", new CountCharacters(
				new Internet("1.1.1.1"), "Se han enviado"));
		
		//Modificación 4
		System.out.println("\n|- Modificación 4 -----------------------------");
		//Tanto al normalizar (quitar ‘\r’) como al eliminar espacios repetidos, se quiere saber también
		//cuántos caracteres había antes del procesado.
		system.copyFile("privado.txt", new CountCharacters(
				new Normalize(new Internet("1.1.1.1")), "\tInicialmente había"));
		system.copyFile("privado.txt", new Normalize(
				new RemoveDuplicatedSpaces(
						new CountCharacters(new Internet("1.1.1.1"), "\tDespués de normalizar, se han enviado"))));
		
		//Modificación 5
		System.out.println("\n|- Modificación 5 -----------------------------");
		//Encriptar un fichero grande es una operación lenta. Se quiere que, si un fichero se va a mandar
		//tanto por Internet como por Bluetooth, se encripte solo una vez para ganar tiempo.
		system.copyFile("privado.txt", new Encript(new Divider(new Internet("1.1.1.1"), new Bluetooth("Galaxy S"))));
	}
}
