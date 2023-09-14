import java.io.*;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();

		system.copyFile("privado.txt", "copia.txt");
		system.sendToInternet("privado.txt", "156.17.11.196");
		system.sendWithBluetooth("privado.txt", "Galaxy de Raúl");
	}
}
