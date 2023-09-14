package part2.view;

import java.util.*;

import part2.model.*;

public class Table 
{
	//-- Métodos públicos
	//-------------------------------------------------------------

	public void insertRow(CompactDisc cd) 
	{
		rows.add(cd);
	}

	public void drawTable() 
	{
		computeRowWidths();

		printHeader();
		for (CompactDisc cd : rows)
			printRow(cd.getTitle(), cd.getArtist());
		printSeparator();
		System.out.println();

	}

	//-- Métodos privados
	//-------------------------------------------------------------

	private void computeRowWidths() 
	{
		longestTitle = longestArtist = 0;
		for (CompactDisc disco : rows) {
			if (disco.getTitle().length() > longestTitle)
				longestTitle = disco.getTitle().length();

			if (disco.getArtist().length() > longestArtist)
				longestArtist = disco.getArtist().length();
		}
	}

	private void printHeader() 
	{	
		printSeparator();
		printRow("Título", "Artista");
		printSeparator();
	}

	private void printRow(String title, String artist) 
	{
		System.out.print("| ");
		System.out.print(fillWithBlanks(title, longestTitle));
		System.out.print(" | ");
		System.out.print(fillWithBlanks(artist, longestArtist));
		System.out.println(" |");
	}

	private void printSeparator() 
	{
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
	 * Ejemplo:
	 * 		fillWithBlanks("abc", 5)  ->   "abc  " (añade dos espacios)
	 */
	public static String fillWithBlanks(String text, int width) 
	{
		return String.format("%1$-" + width + "s", text);
	}

	/**
	 * Devuelve una raya de tantos caracteres como indique el parámetro.
	 * 
	 * Ejemplo:
	 * 		createDashedLine(5)  ->   "-----"
	 */
	private String createDashedLine(int ancho) 
	{
		return String.format("%0" + ancho + "d", 0).replace('0', '-');
	}

	private List<CompactDisc> rows = new ArrayList<CompactDisc>();
	private int longestTitle = 0, longestArtist = 0;
}
