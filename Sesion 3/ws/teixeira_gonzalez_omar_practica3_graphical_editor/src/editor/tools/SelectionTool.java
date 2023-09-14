package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Figure;
import editor.Tool;

/**
 * Título: Clase SelectionTool
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class SelectionTool implements Tool {	
	/**
	 * Atributo editor
	 */
	private Editor editor;
	/**
	 * Atributo selectedFigure
	 */
	private Figure selectedFigure;
	/**
	 * Atributo selectedPoint
	 */
	private Point selectedPoint;
	
	/**
	 * Constructor SelectionTool
	 * @param editor
	 */
	public SelectionTool(Editor editor) {
		this.editor=editor;
	}
	
	/**
	 * Método click
	 * @param x
	 * @param y
	 */
	@Override
	public void click(int x, int y) {
		this.selectedFigure = editor.getDrawing().getFigure(x, y);
		this.selectedPoint = new Point(x, y);
	}

	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	@Override
	public void move(int x, int y) {
		if (selectedFigure != null) {
			selectedFigure.move(x - selectedPoint.x, y - selectedPoint.y);
			this.selectedPoint = new Point(x, y);
		}
	}

	/**
	 * Método release
	 */
	@Override
	public void release() {		
		selectedFigure=null;
	}
}