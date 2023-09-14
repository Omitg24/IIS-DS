package extension.editor.figures;

import java.awt.Point;

import extension.editor.Editor;
import extension.editor.interfaces.Figure;
import extension.editor.tools.Creation;

public class RectangleCreation extends Creation {

	public RectangleCreation(Editor editor) {
		super(editor);
	}

	@Override
	public Figure createFigure(Point first, Point second) {
		int width = second.x - first.x;
		int height = second.y - first.y;
		return new Rectangle(first, width, height);
	}
}
