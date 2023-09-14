package part2.main;

import java.util.*;

import part2.model.*;
import part2.server.*;
import part2.view.Table;

public class OnlineStoreApp 
{
	public static void main(String[] args) 
	{
		OnlineStoreApp store = new OnlineStoreApp();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();

		// 1. Mostrando los datos del servidor
		Table table = new Table();
		for (CompactDisc disc : discs) {
			table.insertRow(disc);
		}
		table.drawTable();

		/*
		  	Se muestra por pantalla la siguiente tabla:
		 
			+---------------+----------------+
			| Título        | Artista        |
			+---------------+----------------+
			| Despacito     | Luis Fonsi     |
			| Dragon's Kiss | Marty Friedman |
			+---------------+----------------+
		 */
	
		// 2. Modificamos los datos
		System.out.println("Modificando los datos...");
		discs.get(0).setArtist("Metallica");
		discs.get(0).setTitle("For Whom the Bells Tolls");

		// 3. Presentamos los nuevos datos
		table = new Table();
		for (CompactDisc disco : discs) {
			table.insertRow(disco);
		}
		table.drawTable();

		/*
		  	Tras la modificación, ésta es la nueva ventana que se muestra:
		 
			+--------------------------+----------------+
			| Título                   | Artista        |
			+--------------------------+----------------+
			| For Whom the Bells Tolls | Metallica      |
			| Dragon's Kiss            | Marty Friedman |
			+--------------------------+----------------+
		 */
		
		// 4. Se suben al servidor
		server.uploadCompactDiscs(discs);
	}
}
