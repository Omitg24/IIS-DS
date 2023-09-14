package editor.tools;

import java.awt.Point;

import editor.Editor;
import editor.Tool;
import figures.Triangle;

/**
 * Título: Clase TriangleTool
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class TriangleTool implements Tool {
	/**
	 * Atributo editor
	 */
	private Editor editor;
	/**
	 * Atributo vertex
	 */
	private Point[] vertex;
	/**
	 * Atributo vertexCounter
	 */
	private int vertexCounter;
	
	/**
	 * Constructor TriangleTool
	 * @param editor
	 */
	public TriangleTool(Editor editor) {
		this.editor=editor;
		this.vertex=new Point[3];
		this.vertexCounter=0;
	}
	
	/**
	 * Método click
	 * @param x
	 * @param y
	 */
	@Override
	public void click(int x, int y) {
		vertex[vertexCounter]=new Point(x, y);
		vertexCounter++;
		if (vertexCounter == 3) {
			editor.getDrawing().addFigure(new Triangle(vertex[0], vertex[1], vertex[2]));
			vertexCounter=0;
			editor.reloadTool();
		}
	}

	/**
	 * Método move
	 */
	@Override
	public void move(int x, int y) {}

	/**
	 * Método release
	 */
	@Override
	public void release() {}
}