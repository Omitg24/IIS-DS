package part1.view;

import java.util.ArrayList;
import java.util.List;

public class Table {
	
	private List<Media> rows = new ArrayList<Media>();
	private int longestTitle = 0, longestArtist = 0;
	
	// -- Métodos públicos
	// -------------------------------------------------------------

	public void insertRow(Media m) {
		rows.add(m);
	}

	public void drawTable(String t1, String t2) {
		computeRowWidths();

		printHeader(t1, t2);
		for (Media m : rows)
			printRow(m.getCad1(), m.getCad2());
		printSeparator();
		System.out.println();
	}

	// -- Métodos privados
	// -------------------------------------------------------------

	private void computeRowWidths() {
		longestTitle = longestArtist = 0;
		for (Media m : rows) {
			if (m.getCad1().length() > longestTitle)
				longestTitle = m.getCad1().length();

			if (m.getCad2().length() > longestArtist)
				longestArtist = m.getCad2().length();
		}
	}

	private void printHeader(String t1, String t2) {
		printSeparator();
		printRow(t1, t2);
		printSeparator();
	}

	private void printRow(String title, String artist) {
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestArtist));
		System.out.println(" |");
	}

	private void printSeparator() {
		System.out.print("+");
		System.out.print(createDashedLine(longestTitle + 2));
		System.out.print("+");
		System.out.print(createDashedLine(longestArtist + 2));
		System.out.println("+");
	}

	/**
	 * Si el ancho del texto recibido como parámetro es menor que el deseado
	 * añade espacios hasta que el texto tenga el número de caracteres deseado.
	 * 
	 * Ejemplo: fillWithBlanks("abc", 5) -> "abc " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) {
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo: createDashedLine(5) -> "-----"
	 */
	private String createDashedLine(int ancho) {
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}
}
