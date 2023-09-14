package extension.editor.figures;

import java.awt.Point;

import extension.editor.interfaces.Figure;

public class Rectangle implements Figure {

	private Point corner;
	private int width, height;

	public Rectangle(Point corner, int width, int height) {
		this.corner = corner;
		this.width = width;
		this.height = height;
	}

	@Override
	public void move(int x, int y) {
		this.corner.x += x;
		this.corner.y += y;
	}

	@Override
	public boolean contains(int x, int y) {
		return (corner.x <= x && corner.x + width >= x) &&
				(corner.y <= y && corner.y + height >= y);
	}

	@Override
	public void draw() {
		System.out.println(" - Rectángulo: (" +
							this.corner.x +
							"," +
							this.corner.y +
							"), ancho = " +
							this.width +
							", alto = " +
							this.height + " (*)");
	}
}
