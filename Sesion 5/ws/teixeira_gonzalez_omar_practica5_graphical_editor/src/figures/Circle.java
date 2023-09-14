package figures;

import java.awt.Point;

import editor.Figure;

/**
 * Título: Clase Circle
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class Circle implements Figure {
	/**
	 * Atributo center
	 */
	private Point center;
	/**
	 * Atributo radius
	 */
	private int radius;
	
	/**
	 * Constructor Circle
	 * @param center
	 * @param radius
	 */
	public Circle(Point center, int radius) {
		this.center=center;
		this.radius=radius;
	}

	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	@Override
	public void move(int x, int y) {
		this.center.x+=x;
		this.center.y+=y;
	}

	/**
	 * Método draw
	 */
	@Override
	public void draw() {
		System.out.println("Círculo [Centro: (" + center.x + ", " + center.y + "); Radius: " + radius + "]");
	}

	/**
	 * Método contains
	 * @param x
	 * @param y
	 * @return true o false
	 */
	@Override
	public boolean contains(int x, int y) {
		double distance = Math.sqrt(Math.pow(x - center.x, 2) + Math.pow(y - center.y, 2));
		boolean pressed = distance < radius;
		return pressed;
	}
}
