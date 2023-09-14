package extension.editor.actions;

import extension.editor.Drawing;
import extension.editor.interfaces.Action;
import extension.editor.interfaces.Figure;

public class CreationAction implements Action {

	private Drawing drawing;

	private Figure figure;

	public CreationAction(Drawing drawing, Figure figure) {
		this.drawing = drawing;
		this.figure = figure;
	}

	@Override
	public void redo() {
		this.drawing.add(figure);
	}

	@Override
	public void undo() {
		this.drawing.remove(figure);
	}

}
