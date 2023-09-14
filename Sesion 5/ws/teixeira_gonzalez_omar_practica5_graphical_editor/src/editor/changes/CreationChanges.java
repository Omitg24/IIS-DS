package editor.changes;

import editor.Drawing;
import editor.Figure;

/**
 * Título: Clase CreationChanges
 * 
 * @author Omar Teixeira González, UO281847
 * @version 18 oct 2022
 */
public class CreationChanges implements Changes {
	/**
	 * Atributo drawing
	 */
	private Drawing drawing;
	/**
	 * Atributo figure
	 */
	private Figure figure;
	
	/**
	 * Constructor CreationChanges
	 * @param drawing
	 * @param figure
	 */
	public CreationChanges(Drawing drawing, Figure figure) {
		this.drawing=drawing;
		this.figure=figure;
	}
	
	/**
	 * Método undo
	 */
	@Override
	public void undo() {
		drawing.removeFigure(figure);
	}

	/**
	 * Método redo
	 */
	@Override
	public void redo() {
		drawing.addFigure(figure);
	}
}
