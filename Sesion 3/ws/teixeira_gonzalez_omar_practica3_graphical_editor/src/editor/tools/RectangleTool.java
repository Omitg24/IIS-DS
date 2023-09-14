package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Figure;
import figures.Rectangle;

/**
 * Título: Clase RectangleTool
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class RectangleTool extends CreationTool {
	/**
	 * Constructor RectangleTool
	 * @param editor
	 */
	public RectangleTool(Editor editor) {
		super(editor);
	}

	/**
	 * Método createFigure
	 * @param start
	 * @param end
	 */
	@Override
	public Figure createFigure(Point start, Point end) {
		int width = end.x - start.x;
		int height = end.y - start.y;
		return new Rectangle(start, width, height);
	}
}
