package base.editor.tools;

import base.editor.core.Editor;
import base.editor.core.Figure;
import base.editor.core.Tool;

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

	/*
	 * Las coordenadas con la posición actual del cursor. Inicialmente, el
	 * punto donde se pulsó con la herramienta de selección (es decir, las que
	 * se recibieron en la llamada a clickOn(int x, int y); luego, las de los
	 * movimientos intermedios del cursor con la herramienta, a través del
	 * método movedTo(int x, int y).
	 */
	private int x, y;

	/*
	 * La figura sobre la que se ha hecho clic inicialmente con esta herramienta
	 * de selección. Se guarda una referencia en este atributo para distinguir
	 * entre los gestos de simplemente mover el cursor o arrastrar tras haber
	 * pulsando previamente sobre una figura, en cuyo caso la estaríamos moviendo.
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
		selectedFigure = editor.getDrawing().findFigureAt(x, y);
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
		// Si no se pulsó previamente en una figura no hay que hacer nada
		if (selectedFigure == null) {
			return;
		}
		selectedFigure.moveBy(x - this.x, y - this.y);
		setPosition(x, y);
	}

	@Override
	public void release()
	{
		editor.toolDone();
	}

	@Override
	public void reset()
	{
		selectedFigure = null;
	}

	@Override
	public String toString()
	{
		return "Herramienta de selección";
	}
}
