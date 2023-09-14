package editor.tools;

import editor.actions.MoveAction;
import editor.core.Editor;
import editor.core.Figure;
import editor.core.Tool;

/**
 * Permite mover figuras de un documento de dibujo del editor. Para ello
 * es necesario pulsar previamente sobre una figura existente y, sin soltar
 * el botón del ratón (esto es, arrastrando), mover el cursor a otra
 * posición. La figura irá desplazándose dicho incremento con cada evento
 * de mover recibido.<p>
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
	 * El total acumulado de desplazamiento horizontal y vertical que se aplicó
	 * a la figura. Se han añadido respecto a la versión anterior del editor
	 * para poder crear una acción que registre sólo el movimiento total acumulado,
	 * y que luego pueda ser deshecha. 
	 */
	private int dX, dY;

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
		// No se crea una acción porque estos movimientos intermedios no hay que
		// deshacerlos, sino todo de una vez (desde que se pulsa la primera vez
		// hasta que se suelta el botón del ratón)
		selectedFigure.moveBy(x - this.x, y - this.y);
		// Se incrementa el desplazamiento total acumulado
		this.dX += (x - this.x);
		this.dY += (y - this.y);
		// Se actualiza la nueva posición del cursor
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
		if (selectedFigure != null) {
			editor.getActionManager().addUndoableAction(new MoveAction(selectedFigure, dX, dY));
		}
		selectedFigure = null;			
		dX = 0; 
		dY = 0;		
	}
	
	@Override
	public String toString()
	{
		return "Herramienta de selección";
	}
}
