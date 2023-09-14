package extension.editor.tools;

import java.awt.Point;

import extension.editor.Editor;
import extension.editor.actions.CreationAction;
import extension.editor.interfaces.Figure;
import extension.editor.interfaces.Tool;

public abstract class Creation implements Tool {

	private Editor editor;

	private Point first, second;

	public Creation(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void click(int x, int y) {
		this.first = new Point(x, y);
	}

	@Override
	public void move(int x, int y) {
		this.second = new Point(x, y);
	}

	@Override
	public void release() {
		Figure figure = createFigure(first, second);
		editor.addFigure(figure);
		editor.setDefaultTool();
		editor.addUndo(new CreationAction(editor.getDrawing(), figure));
	}

	@Override
	public String toString() {
		return "Creación";
	}

	public abstract Figure createFigure(Point first, Point second);
}
