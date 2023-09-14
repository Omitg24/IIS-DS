package editor.core;

import java.io.PrintWriter;
import java.util.List;

import editor.actions.ActionManager;

import java.util.ArrayList;

/**
 * Representa un documento de dibujo. Aunque en la versión actual el editor
 * suponemos que únicamente tiene un solo documento, añadir más, como en el
 * caso de cualquier aplicación gráfica real, sería trivial. El documento es
 * responsable de guardar las figuras que contiene así como su selección actual.
 */
public class Drawing 
{
	private List<Figure> figures = new ArrayList<>();
	
	// El gestor de deshacer/repetir pertenece al documento de dibujo y no al
	// editor porque, si tuviésemos varios documentos activos, cada acción se
	// ejecuta sobre el dibujo actual, es dependiente de éste.
	//
	private ActionManager actionManager = new ActionManager();	

	/**
	 * Añade una figura al documento. Dicha figura se situará encima del resto
	 * de figuras (lo que implica que al realizar una búsqueda de qué figura 
	 * contiene este documento de dibujo en una determinada posición por medio
	 * del método  {@code findFigureAt(int x, int y)} se devolverá esta nueva
	 * figura antes que cualquiera de las ya existentes que pudiera haber en 
	 * dicha posición). Nótese que no se permiten añadir figuras nulas al 
	 * documento: en ese caso se lanzará una excepción.<p>
	 * 
	 * @param figure la nueva figura a añadir al documento; ha de ser un objeto
	 *               {@code Figure} válido (no nulo)
	 * @throws IllegalArgumentException si se trata de añadir una figura nula
	 */
	public void addFigure(Figure figure)
	{
		if (figure == null)
			throw new IllegalArgumentException("¡No se puede añadir una figura nula!");
		figures.add(0, figure);
	}
	
	public void removeFigure(Figure figure)
	{
		if (figure == null)
			throw new IllegalArgumentException("¡No se puede borrar una figura nula!");
		if (!figures.contains(figure))
			throw new IllegalArgumentException("El documento no contiene dicha figura, no se ha podido borrar: " + figure);
		figures.remove(figure);
	}
	
	/**
	 * Devuelve la figura situada en la posición especificada de este documento,
	 * o {@code null} si no hay ninguna. En caso de que existan varias en ese
	 * punto, devolverá la figura situada encima del resto. Esto, en nuestra
	 * implementación actual del editor, consiste simplemente en devolver la
	 * última figura añadida, ya que no cuenta con operaciones para enviar las
	 * figuras atrás o al frente.
	 * 
	 * @param x la coordenada horizontal 
	 * @param y la coordenada vertical
	 * @return la figura existente en dicha posición, o {@code null} si no hay
	 *         ninguna
	 */
	public Figure findFigureAt(int x, int y)
	{
		for (Figure figure : figures) {
			if (figure.contains(x, y))
				return figure;
		}
		return null;
	}
	
	/**
	 * Dibuja el documento. En nuestra implementación del editor en modo texto dibujar
	 * el documento consiste simplemente en mostrar todas las figuras que contiene,
	 * llamando para ello al método {@code draw} de cada una de ellas. Cada figura se
	 * muestra en una línea aparte con un guión delante, a modo de elementos de una
	 * lista (" - ").
	 * 
	 * @param output la salida en modo texto donde se mostrará este documento de dibujo
	 */
	public void draw(PrintWriter output)
	{
		if (figures.isEmpty())
			return;
		output.println("Figuras: ");
		for (Figure figure : figures) {
			output.print(" - ");
			figure.draw(output);
			output.println();
		}
	}
	
	public ActionManager getActionManager()
	{
		return actionManager;
	}
}
