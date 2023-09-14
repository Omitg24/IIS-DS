package editor;

import editor.tools.SelectionTool;

/**
 * Título: Clase Editor
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class Editor {
	/**
	 * Atributo drawing
	 */
	private Drawing drawing;
	/**
	 * Atributo selectedTool
	 */
	private Tool selectedTool;
	
	/**
	 * Constructor Editor
	 * @param drawing
	 */
	public Editor(Drawing drawing) {
		setDrawing(drawing);
	}

	/**
	 * Método getDrawing
	 * @return drawing
	 */
	public Drawing getDrawing() {
		return drawing;
	}

	/**
	 * Método setDrawing
	 * @param drawing
	 */
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	/**
	 * Método drawDocument
	 */
	public void drawDocument() {
		drawing.draw();
		reloadTool();
	}
	
	/**
	 * Método createSelectionTool
	 * @return tool
	 */
	public Tool createSelectionTool() {
		return new SelectionTool(this);
	}
	
	/**
	 * Método setTool
	 * @param tool
	 */
	public void setTool(Tool tool)  {
		if (tool != null) {
			this.selectedTool=tool;
		}
	}
	
	/**
	 * Método click
	 * @param x
	 * @param y
	 */
	public void click(int x, int y) {
		selectedTool.click(x, y);
	}
	
	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	public void move(int x, int y) {
		selectedTool.move(x, y);
	}
	
	/**
	 * Método release
	 */
	public void release() {
		selectedTool.release();
	}

	/**
	 * Método reloadTool
	 */
	public void reloadTool() {
		this.selectedTool = createSelectionTool();
	}	
}
