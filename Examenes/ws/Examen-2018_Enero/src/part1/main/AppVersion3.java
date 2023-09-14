package part1.main;

import java.util.*;

import part1.adapters.BookAdapter;
import part1.adapters.CompactDiscAdapter;
import part1.model.*;
import part1.server.*;
import part1.view.Table;

public class AppVersion3 
{
	public static void main(String[] args) 
	{
		AppVersion3 store = new AppVersion3();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<CompactDisc> discs = server.downloadCompactDiscs();
		List<Book> books = server.downloadBooks();

		// Mostrar en una misma tabla los discos y los libros
		// (que ponga "Título" y "Autor" en la cabecera)
		
		/*
			+--------------------+----------------+
			| Título             | Autor          |
			+--------------------+----------------+
			| Despacito          | Luis Fonsi     |
			| Dragon's Kiss      | Marty Friedman |
			| El Código Da Vinci | Dan Brown      |
			| Design Patterns    | Erich Gamma    |
			+--------------------+----------------+
		 */
		
		// 1. Mostrando los datos del servidor
		Table table = new Table();
		for (Book book : books) {
			table.insertRow(new BookAdapter(book));
		}
		for (CompactDisc disc : discs) {
			table.insertRow(new CompactDiscAdapter(disc));
		}
		table.drawTable("Titulo", "Autor");

		server.uploadCompactDiscs(discs);
		server.uploadBooks(books);
	}
}
