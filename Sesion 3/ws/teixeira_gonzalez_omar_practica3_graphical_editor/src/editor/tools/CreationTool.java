package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Figure;
import editor.Tool;

/**
 * Título: Clase CreationTool
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public abstract class CreationTool implements Tool {	
	/**
	 * Atributo editor
	 */
	private Editor editor;
	/**
	 * Atributo start
	 */
	private Point start;
	/**
	 * Atributo end
	 */
	private Point end;
		
	/**
	 * Constructor CreationTool
	 * @param editor
	 */
	public CreationTool(Editor editor) {
		this.editor=editor;
	}
	
	/**
	 * Método click
	 * @param x
	 * @param y
	 */
	@Override
	public void click(int x, int y) {
		this.start = new Point(x, y);
	}

	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	@Override
	public void move(int x, int y) {		
		this.end = new Point(x, y);	
	}

	/**
	 * Método release
	 */
	@Override
	public void release() {
		Figure figure = createFigure(start, end);
		editor.getDrawing().addFigure(figure);
		editor.reloadTool();
	}
	
	/**
	 * Método createFigure
	 * @param start
	 * @param end
	 * @return figure
	 */
	public abstract Figure createFigure(Point start, Point end);
	
}