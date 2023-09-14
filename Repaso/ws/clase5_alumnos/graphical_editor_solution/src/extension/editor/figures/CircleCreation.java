package extension.editor.figures;

import java.awt.Point;

import extension.editor.Editor;
import extension.editor.interfaces.Figure;
import extension.editor.tools.Creation;

public class CircleCreation extends Creation {

	public CircleCreation(Editor editor) {
		super(editor);
	}

	@Override
	public Figure createFigure(Point first, Point second) {
		int x = (second.x + first.x) / 2;
		int y = (second.y + first.y) / 2;
		Point center = new Point(x,y);
		double radius = (second.x - first.x)/2;
		return new Circle(center, radius);
	}
}
