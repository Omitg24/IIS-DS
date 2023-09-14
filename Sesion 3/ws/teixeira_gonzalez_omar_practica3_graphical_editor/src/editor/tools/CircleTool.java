package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Figure;
import figures.Circle;

/**
 * Título: Clase CircleTool
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class CircleTool extends CreationTool {

	/**
	 * Constructor CircleTool
	 * @param editor
	 */
	public CircleTool(Editor editor) {
		super(editor);		
	}

	/**
	 * Método createFigure
	 * @param start
	 * @param end
	 */
	@Override
	public Figure createFigure(Point start, Point end) {
		int centerX = (start.x + end.x)/2;
		int centerY = (start.y + end.y)/2;
		Point center = new Point(centerX, centerY);
		int radius = (end.x + start.x)/2;
		return new Circle(center, radius);
	}
}
