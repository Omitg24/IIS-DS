package extension.editor.figures;

import java.awt.Point;

import extension.editor.interfaces.Figure;

public class Circle implements Figure {

	private Point center;
	private double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	@Override
	public void move(int x, int y) {
		this.center.x += x;
		this.center.y += y;
	}

	@Override
	public boolean contains(int x, int y) {
		return (Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2)) < Math.pow(radius, 2);
	}

	@Override
	public void draw() {
		System.out.println(" - Círculo: (" +
							this.center.x +
							"," +
							this.center.y +
							"), radio = " +
							this.radius + " (*)");
	}
}
