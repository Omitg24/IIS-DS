package figures;

import java.awt.Point;

import editor.Figure;

/**
 * Título: Clase Rectangle
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class Rectangle implements Figure {
	/**
	 * Atributo width
	 */
	private int width;
	/**
	 * Atributo height
	 */
	private int height;
	/**
	 * Atributo corner
	 */
	private Point corner;	
	
	/**
	 * Constructor Rectangle
	 * @param corner
	 * @param width
	 * @param height
	 */
	public Rectangle(Point corner, int width, int height) {
		this.width = width;
		this.height = height;
		this.corner = corner;
	}
	
	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	@Override
	public void move(int x, int y) {
		this.corner.x+=x;
		this.corner.y+=y;
	}

	/**
	 * Método draw
	 */
	@Override
	public void draw() {
		System.out.println("Rectángulo [Esquina superior: (" + corner.x + ", " + corner.y + "); Ancho: " + width  + "; Alto: " + height+ "]");
	}

	/**
	 * Método contains
	 * @param x
	 * @param y
	 */
	@Override
	public boolean contains(int x, int y) {
		boolean pressed = (corner.x <= x && x <= corner.x + height) && (corner.y <= y && y <= corner.y + width);
		return pressed;
	}

}
