package figures;

import java.awt.Point;

import editor.Figure;

/**
 * Título: Clase Triangle
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class Triangle implements Figure {
	/**
	 * Atributo v1
	 */
	private Point v1;
	/**
	 * Atributo v2
	 */
	private Point v2;
	/**
	 * Atributo v3
	 */
	private Point v3;
		
	/**
	 * Constructor Triangle
	 * @param v1
	 * @param v2
	 * @param v3
	 */
	public Triangle(Point v1, Point v2, Point v3) {	
		this.v1 = v1;
		this.v2 = v2;
		this.v3 = v3;
	}

	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	@Override
	public void move(int x, int y) {
		this.v1.x+=x;
		this.v1.y+=y;
		this.v2.x+=x;
		this.v2.y+=y;
		this.v3.x+=x;
		this.v3.y+=y;
	}

	/**
	 * Método draw
	 */
	@Override
	public void draw() {
		System.out.println("Triángulo [Vértice 1: (" + v1.x + ", " + v1.y + "); Vértice 2: (" + v2.x + ", " + v2.y + "); Vértice 3: (" + v3.x + ", " + v3.y + ")]");
	}

	/**
	 * Método contains
	 * @param x
	 * @param y
	 */
	@Override
	public boolean contains(int x, int y) {		
		Point pos = new Point(x,y);
		boolean pressed = pos.equals(v1) || pos.equals(v2) || pos.equals(v3);
		return pressed;
	}

}
