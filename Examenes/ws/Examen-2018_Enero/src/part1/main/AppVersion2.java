package part1.main;

import java.util.List;

import part1.adapters.BookAdapter;
import part1.model.Book;
import part1.server.Server;
import part1.view.Table;

public class AppVersion2 
{
	public static void main(String[] args) 
	{
		AppVersion2 store = new AppVersion2();
		store.openWindow();
	}

	public void openWindow() 
	{
		Server server = new Server();

		List<Book> books = server.downloadBooks();

		// Mostrar sólo los libros en una tabla (que ponga "Título" y "Autor" en la cabecera)
		
		/*		
			+--------------------+-------------+
			| Título             | Autor       |
			+--------------------+-------------+
			| El Código Da Vinci | Dan Brown   |
			| Design Patterns    | Erich Gamma |
			+--------------------+-------------+
		*/
		
		// 1. Mostrando los datos del servidor
		Table table = new Table();
		for (Book book : books) {
			table.insertRow(new BookAdapter(book));
		}
		table.drawTable("Titulo", "Autor");

		server.uploadBooks(books);
	}
}
