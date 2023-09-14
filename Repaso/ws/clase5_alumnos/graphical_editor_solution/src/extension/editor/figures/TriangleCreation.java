package extension.editor.figures;

import java.awt.Point;

import extension.editor.Editor;
import extension.editor.interfaces.Tool;

public class TriangleCreation implements Tool {

	private Editor editor;

	private Point upperCorner, rightCorner, leftCorner;

	private int counter = 0;

	public TriangleCreation(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void click(int x, int y) {
		switch (counter) {
			case 0:
				this.upperCorner = new Point(x, y);
				break;
			case 1:
				this.rightCorner = new Point(x, y);
				break;
			case 2:
				this.leftCorner = new Point(x, y);
				release();
				break;
		}
		counter++;
	}

	@Override
	public void move(int x, int y) { }

	@Override
	public void release() {
		editor.addFigure(new Triangle(upperCorner, rightCorner, leftCorner));
		editor.setDefaultTool();
	}
}
