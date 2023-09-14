package editor.tools;

import editor.core.Editor;
import editor.core.Figure;
import editor.core.Tool;

/**
 * Permite seleccionar y mover figuras de un documento de dibujo del editor.<p>
 *  
 * Actualmente, en esta implementación únicamente se permiten seleccionar 
 * figuras individuales, al hacer clic sobre ellas. Es decir, no permite (por
 * ahora) seleccionar varias figuras mediante un área rectangular, pulsando en
 * un lugar del documento en que no haya ninguna figura y arrastrando y
 * soltando, como hacen la mayoría de editores gráficos. En ese caso, se
 * seleccionarían todas las figuras confinadas en el interior de dicha área,
 * o podría bastar incluso con que el área rectangular así definida tocase a
 * una figura (la implementación concreta varía de unas aplicaciones a otras,
 * y dependería de cómo quisiéramos que funcionara nuestro editor).<p>
 * 
 * Del mismo modo, cuando se hace clic sobre otra figura existente se limpia la
 * selección anterior que hubiera y pasaría a estar seleccionada la nueva
 * figura sobre la que se pulsó. Es decir, no cuenta, tampoco, por ahora, con
 * la posibilidad de seleccionar varias figuras mediante alguna combinación de
 * la pulsación de una tecla más el botón del ratón, como suele ser común en
 * cualquier editor gráfico (normalmente mediante la tecla [Control] en Windows
 * o [Command] en Mac más el botón del ratón).<p>
 * 
 * Por último, si una vez seleccionada una figura se desplaza el cursor,
 * arrastrándola, se actualiza la posición de dicha figura, moviéndola a la
 * nueva posición.
 */
public class SelectionTool implements Tool
{
	private Editor editor;
	
	/**
	 * Las coordenadas con la posición actual del cursor. Inicialmente, el
	 * punto donde se pulsó con la herramienta de selección (es decir, las que
	 * se recibieron en la llamada a {@code clickOn(int x, int y)}; luego, las
	 * de los movimientos intermedios del cursor con la herramienta, a través
	 * del método {@code movedTo(int x, int y}. 
	 */
	private int x, y;
	
	/**
	 * La figura sobre la que se ha hecho clic inicialmente con esta herramienta
	 * de selección. Se guarda una referencia en este atributo para distinguir
	 * entre los gestos de mover el cursor y arrastrar. En el segundo caso,
	 * necesariamente ha de haberse pulsado previamente con la herramienta de
	 * selección sobre una figura (nótese que no basta con preguntarle al editor
	 * si hay alguna figura seleccionada para hacer esta distinción: podría
	 * haberla, por ejemplo porque se pulsó sobre ella y se soltó, o porque se
	 * acaba de crear y el editor la selecciona automáticamente, y sin embargo
	 * los eventos {@code moveTo} no harían nada (más que dibujar el cursor de
	 * la herramienta en la posición correspondiente en el caso de un editor
	 * gráfico de verdad) porque no se estaría arrastrando.
	 */
	private Figure selectedFigure;
	
	public SelectionTool(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("La herramienta de selección necesita una referencia al editor");
		this.editor = editor;
	}

	@Override
	public void clickOn(int x, int y)
	{
		editor.trace(String.format("Se hizo clic con la herramienta de selección en (%d, %d)", x, y));
		selectedFigure = editor.getDrawing().findFigureAt(x, y);
		if (selectedFigure != null) {
			editor.trace("Se seleccionó la figura: " + selectedFigure);
			editor.getDrawing().setCurrentSelection(selectedFigure);
		} else {
			editor.trace("No hay ninguna figura en esa posición, se limpia la selección anterior que hubiera");
			editor.getDrawing().clearCurrentSelection();
		}
		setPosition(x, y);
	}
	
	/**
	 * Actualiza la posición actual del cursor a las nuevas coordenadas recibidas.
	 * Este método es llamado cuando se hace clic con el ratón así como cada vez
	 * que se mueve el cursor a una nueva posición. De esta forma, si hay una
	 * figura seleccionada, se sabe qué incremento hay que moverla (la diferencia
	 * entre la nueva posición del cursor recibida en el evento {@code movedTo(int x,
	 * int y)} y la posición anterior previamente guardada a través de este método.
	 * 
	 * @param x la coordenada horizontal de la posición actual del cursor
	 * @param y la coordenada vertical de la posición actual del cursor
	 */
	private void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}

	@Override
	public void moveTo(int x, int y) 
	{
		if (selectedFigure == null) {
			editor.trace(String.format("Se movió el cursor con la herramienta de selección a (%d, %d)", x, y));
			return;
		}
		editor.trace(String.format("Se arrastró con la herramienta de selección hasta (%d, %d)", x, y));
		selectedFigure.moveBy(x - this.x, y - this.y);
		editor.trace("Se movió la figura: " + selectedFigure);
		setPosition(x, y);
	}

	@Override
	public void release() 
	{
		editor.trace(String.format("Se soltó el botón del ratón con la herramienta de selección en (%d, %d)", x, y));
		selectedFigure = null;
	}
	
	@Override
	public void unselect()
	{
		selectedFigure = null;		
	}
	
	@Override
	public String toString()
	{
		return "Herramienta de selección";
	}
}
