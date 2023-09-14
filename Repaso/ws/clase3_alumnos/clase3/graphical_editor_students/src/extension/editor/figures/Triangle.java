package extension.editor.figures;

import java.awt.Point;

import extension.editor.interfaces.Figure;

public class Triangle implements Figure {

	private Point upperCorner, rightCorner, leftCorner;


	public Triangle(Point upperCorner, Point rightCorner, Point leftCorner) {
		this.upperCorner = upperCorner;
		this.rightCorner = rightCorner;
		this.leftCorner = leftCorner;
	}

	@Override
	public void move(int x, int y) {
		this.upperCorner.x += x;
		this.upperCorner.y += y;
		this.rightCorner.x += x;
		this.rightCorner.y += y;
		this.leftCorner.x += x;
		this.leftCorner.y += y;
	}

	@Override
	public boolean contains(int x, int y) {
		Point aux = new Point(x, y);
		return upperCorner.equals(aux) ||
				rightCorner.equals(aux) ||
				leftCorner.equals(aux);
	}

	@Override
	public void draw() {
		System.out.println(" - Triángulo: (" +
							this.upperCorner.x +
							"," +
							this.upperCorner.y +
							"), (" +
							this.rightCorner.x +
							"," +
							this.rightCorner.y +
							"), (" +
							this.leftCorner.x +
							"," +
							this.leftCorner.y +
							") (*)");
	}
}
