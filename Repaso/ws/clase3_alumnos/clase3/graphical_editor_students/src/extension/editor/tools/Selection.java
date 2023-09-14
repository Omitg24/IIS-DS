package extension.editor.tools;

import java.awt.Point;

import extension.editor.Editor;
import extension.editor.interfaces.Figure;
import extension.editor.interfaces.Tool;

public class Selection implements Tool {

	private Editor editor;

	private Point clickedPoint;

	private Figure selectedFigure;

	public Selection(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void click(int x, int y) {
		this.clickedPoint = new Point(x, y);
		Figure auxFigure = editor.getFigure(x, y);
		if (auxFigure != null) {
			this.selectedFigure = auxFigure;
		}
	}

	@Override
	public void move(int x, int y) {
		this.selectedFigure.move(x -clickedPoint.x, y -clickedPoint.y);
	}

	@Override
	public void release() {
		this.selectedFigure = null;
	}

	@Override
	public String toString() {
		return "Selección";
	}
}
