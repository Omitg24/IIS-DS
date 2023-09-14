package extension.editor.actions;

import extension.editor.interfaces.Action;
import extension.editor.interfaces.Figure;

public class SelectionAction implements Action {

	private Figure figure;

	private int x, y;

	public SelectionAction(Figure figure, int x, int y) {
		this.figure = figure;
		this.x = x;
		this.y = y;
	}

	@Override
	public void redo() {
		this.figure.move(x, y);
	}

	@Override
	public void undo() {
		this.figure.move(-x, -y);
	}

}
