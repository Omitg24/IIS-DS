package part2.server;

import java.util.*;

import part2.model.*;

// Clase que simula el acceso al servidor web de la tienda online
public class Server {

	// Este método simula el conectar con el servidor y descargarse la lista de discos compactos
	public List<CompactDisc> downloadCompactDiscs() 
	{
		System.out.println("Bajando discos del servidor...");
		if (cds == null) {
			cds = new ArrayList<CompactDisc>();
			cds.add(new CompactDisc("Despacito", "Luis Fonsi", "Latino"));
			cds.add(new CompactDisc("Dragon's Kiss", "Marty Friedman", "Metal"));
		}
		return cds;
	}

	// Este método simula el conectar con el servidor y descargarse la lista de móviles
	public List<Mobile> downloadMobiles() 
	{
		System.out.println("Bajando móviles del servidor...");
		if (mobiles == null) {
			mobiles = new ArrayList<Mobile>();
			mobiles.add(new Mobile("Samsung", "Galaxy S8"));
			mobiles.add(new Mobile("Apple", "iPhone 8"));
		}
		return mobiles;
	}

	// Este metodo simula el conectar con el servidor y descargarse la lista de libros
	public List<Book> downloadBooks() 
	{
		System.out.println("Bajando Libros del servidor...");
		if (books == null) {
			books = new ArrayList<Book>();

			books.add(new Book("El Código Da Vinci", "Dan Brown", "Planeta", "Español"));
			books.add(new Book("Design Patterns", "Erich Gamma", "Addison-Wesley", "Español"));
		}
		return books;
	}

	// Este método simula el conectar con el servidor y enviarle la lista de DVD modificada
	public void uploadCompactDiscs(List<CompactDisc> discos) 
	{
		System.out.println("Enviando discos al servidor...");
		this.cds = discos;
	}

	// Este método simula el conectar con el servidor y enviarle la lista de móviles modificada
	public void uploadMobiles(List<Mobile> moviles) 
	{
		System.out.println("Enviando móviles al servidor...");
		this.mobiles = moviles;
	}

	// Este método simula el conectar con el servidor y enviarle la lista de Libro modificada
	public void uploadBooks(List<Book> libros) 
	{
		System.out.println("Enviando libros al servidor...");
		this.books = libros;
	}

	private List<CompactDisc> cds;
	private List<Mobile> mobiles;
	private List<Book> books;
}
