package part1.main;

import java.util.List;

import part1.adapters.BookAdapter;
import part1.adapters.CompactDiscAdapter;
import part1.adapters.MobileAdapter;
import part1.adapters.MobileAdapterInversed;
import part1.model.Book;
import part1.model.CompactDisc;
import part1.model.Mobile;
import part1.server.Server;
import part1.view.Table;

public class AppVersion4 
{
	public static void main(String[] args) 
	{
		AppVersion4 store = new AppVersion4();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();
		List<Mobile> mobiles = server.downloadMobiles();

		// Parte 1
		// -------
		// Mostrar sólo los móviles en una tabla (que ponga "Marca" y "Modelo" en la cabecera)
		
		/*
			+---------+-----------+
			| Marca   | Modelo    |
			+---------+-----------+
			| Samsung | Galaxy S8 |
			| Apple   | iPhone 8  |
			+---------+-----------+
		*/
		
		Table table = new Table();
		for (Mobile mobile : mobiles) {
			table.insertRow(new MobileAdapter(mobile));
		}
		table.drawTable("Marca", "Modelo");
		
		// Parte 2
		// -------
		// Mostrar en una misma tabla los discos, libros y móviles (que ponga "Nombre"
		// y "Propietario" en la cabecera). 
		//
		// Nótese que en esta ocasión, en los móviles, el modelo debe quedar en la
		// columna 1 (nombre) y la marca en la columna 2 (propietario).
		
		/*
			+--------------------+----------------+
			| Nombre             | Propietario    |
			+--------------------+----------------+
			| Despacito          | Luis Fonsi     |
			| Dragon's Kiss      | Marty Friedman |
			| El Código Da Vinci | Dan Brown      |
			| Design Patterns    | Erich Gamma    |
			| Galaxy S8          | Samsung        |
			| iPhone 8           | Apple          |
			+--------------------+----------------+
		*/
		
		table = new Table();
		for (CompactDisc disc : discs) {
			table.insertRow(new CompactDiscAdapter(disc));
		}
		for (Book book : books) {
			table.insertRow(new BookAdapter(book));
		}		
		for (Mobile mobile : mobiles) {
			table.insertRow(new MobileAdapterInversed(mobile));
		}		
		table.drawTable("Nombre", "Propietario");
		
		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
		server.uploadMobiles(mobiles);
	}
}
