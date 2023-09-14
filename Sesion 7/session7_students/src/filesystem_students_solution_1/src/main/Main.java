package main;

import java.io.*;

import outputs.*;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();

		system.copyFile("privado.txt", new FileOutput("copia.txt"));
		system.copyFile("privado.txt", new Internet("156.17.11.196"));
		system.copyFile("privado.txt", new Bluetooth("Galaxy de Raúl"));
	}

}
