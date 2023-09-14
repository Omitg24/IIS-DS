package editor.core;

import java.io.PrintWriter;
import java.util.List;
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
	
	/**
	 * Guarda la selección actual del documento. En esta versión del documento
	 * suponemos que sólo hay una figura seleccionada en cada momento.<p> 
	 * 
	 * Una implementación más realista permitiría seleccionar varias figuras,
	 * bien mediante la combinación de la pulsación de una determinada tecla más
	 * el clic de ratón (usualmente, [Control] en Windows, [Command] en Mac), bien
	 * pulsando la primera vez en un punto que no tenga ninguna figura y a partir
	 * de ahí arrastrando y soltando, seleccionando todas las figuras contenidas
	 * en el área rectangular así definida. Para ello (además de cambiar la
	 * implementación actual de la herramienta de selección), habría que definir
	 * este atributo como una lista de figuras en vez de como una figura individual.<p>
	 * 
	 * Por último, el motivo de guardar la selección actual en el documento, en
	 * vez de directamente en la herramienta de selección, no es otro que poder
	 * mostrar cuál es la selección actual al dibujar el documento, a modo de 
	 * información útil para la depuración. En un editor real (o si decidimos
	 * añadir más funcionalidad a éste) también se haría así ya que normalmente
	 * será posible aplicar determinadas acciones sobre la selección actual:
	 * copiar o cortar y pegar, agrupar/desagrupar, eliminar dicha figura o
	 * figuras seleccionadas, etcétera.
	 */
	private Figure currentSelection;
	
	/**
	 * Añade una figura al documento. Cada vez que se crea una nueva figura en
	 * el editor se limpia la selección que hubiera anteriormente (si es que
	 * había algo seleccionado) y la nueva figura pasa a ser la selección actual
	 * del documento.<p>
	 * 
	 * Dicha figura se situará encima del resto de figuras (lo que implica que
	 * al realizar una búsqueda de qué figura contiene este documento de dibujo
	 * en una determinada posición por medio del método 
	 * {@code findFigureAt(int x, int y)} se devolverá esta nueva figura antes
	 * que cualquiera de las ya existentes que pudiera haber en dicha posición).
	 * Nótese que no se permiten añadir figuras nulas al documento: en ese caso
	 * se lanzará una excepción.<p>
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
		clearCurrentSelection();
		setCurrentSelection(figure);
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
	 * lista (" - "). Así mismo, la figura seleccionada se indica con un asterisco
	 * detrás (" (*)").
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
			if (figure == currentSelection)
				output.print(" (*)");
			output.println();
		}
	}
	
	// Operaciones que trabajan con la selección actual
	
	public void setCurrentSelection(Figure figure)
	{
		if (!figures.contains(figure))
			throw new IllegalArgumentException("¡No se puede seleccionar una figura que no existe en el documento!: " + figure);
		currentSelection = figure;
	}
	
	public Figure getCurrentSelection()
	{
		return currentSelection;
	}
	
	public void clearCurrentSelection()
	{
		currentSelection = null;
	}
}
