package main;

import java.io.IOException;

import outputs.Bluetooth;
import outputs.FileOutput;
import outputs.Internet;
import outputs.formatters.*;

public class Main {
	public static void main(String[] args) throws IOException {
		FileSystem system = new FileSystem();

		system.copyFile("privado.txt", new FileOutput("copia.txt"));
		system.copyFile("privado.txt", new Internet("156.17.11.196"));
		system.copyFile("privado.txt", new Bluetooth("Galaxy de Raúl"));

		// CAMBIOS:
		System.out.println("\n--------------------------------------------------\nCAMBIOS:");
		system.copyFile("privado.txt", new Normalize(new FileOutput("copia.txt")));
		system.copyFile("privado.txt", new Encripter(new Internet("156.17.11.196")));
		system.copyFile("privado.txt", new Encripter(new DuplicatedSpaces(new Bluetooth("Galaxy de Raúl"))));

		// MODIFICACION 1:
		System.out.println("\n--------------------------------------------------\nMODIFICACIÓN 1:");
		system.copyFile("privado.txt", new FileOutput("a.txt"));
		system.copyFile("privado.txt", new Encripter(new FileOutput("b.txt")));

		// MODIFICACION 2:
		System.out.println("\n--------------------------------------------------\nMODIFICACIÓN 2:");
		system.copyFile("privado.txt", new Normalize(new Internet("1.1.1.1")));
		system.copyFile("privado.txt", new DuplicatedSpaces(new Internet("1.1.1.2")));
		system.copyFile("privado.txt", new Normalize(new DuplicatedSpaces(new Internet("1.1.1.3"))));

		// MODIFICACION 3:
		System.out.println("\n--------------------------------------------------\nMODIFICACIÓN 3:");
		CharCounter counter;
		system.copyFile("privado.txt", counter = new CharCounter(new FileOutput("copia.txt")));
		System.out.println("Se han enviado " + counter.getCharCounter() + "# caracteres");
		system.copyFile("privado.txt", counter = new CharCounter(new Internet("1.1.1.1")));
		System.out.println("Se han enviado " + counter.getCharCounter() + "# caracteres");
		system.copyFile("privado.txt", counter = new CharCounter(new Bluetooth("Galaxy de Raúl")));
		System.out.println("Se han enviado " + counter.getCharCounter() + "# caracteres");

		// MODIFICACION 4:
		System.out.println("\n--------------------------------------------------\nMODIFICACIÓN 4:");
		CharCounter counter2;
		system.copyFile("privado.txt",
				counter = new CharCounter(new Normalize(counter2 = new CharCounter(new Internet("1.1.1.1")))));
		System.out.println("Inicialmente había " + counter.getCharCounter() + "# caracteres");
		System.out.println("Despues de normalizar, se han enviado " + counter2.getCharCounter() + "# caracteres");

		// MODIFICACION 5:
		System.out.println("\n--------------------------------------------------\nMODIFICACIÓN 5:");
		system.copyFile("privado.txt",
				new Encripter(new MultipleFormats(new Internet("1.1.1.1"), new Bluetooth("Galaxy de Raúl"))));

		// MODIFICACIONES EXTRAS:
		System.out.println("\n--------------------------------------------------\nMODIFICACIONES EXTRAS:");
		system.copyFile("privado.txt",
				new MultipleFormats(new FileOutput("a.txt"), new Encripter(new FileOutput("b.txt"))));
		system.copyFile("privado.txt",
				new MultipleFormats(new Normalize(new FileOutput("copia.txt")),
						new Encripter(new Internet("156.17.11.196")),
						new Encripter(new DuplicatedSpaces(new Bluetooth("Galaxy de Raúl")))));
		SignCalculator calculator;
		system.copyFile("privado.txt", calculator = new SignCalculator(new Encripter(new Internet("1.1.1.1"))));
		System.out.println("La firma MD5 del archivo es: " + calculator.getSignSum());
	}
}
