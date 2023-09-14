package base.editor.figures;

import java.io.PrintWriter;

import base.editor.core.BoundingBox;
import base.editor.core.Figure;

public class Triangle implements Figure
{
	// las coordenadas de los tres vértices del triángulo
	private int x1, y1, x2, y2, x3, y3;

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	public Triangle(BoundingBox boundingBox)
	{
		// vértice superior
		x1 = boundingBox.getX() + (boundingBox.getWidth() / 2);
		y1 = boundingBox.getY();
		// vértice inferior izquierdo
		x2 = boundingBox.getX();
		y2 = boundingBox.getY() + boundingBox.getHeight();
		// vértice inferior derecho
		x3 = boundingBox.getX() + boundingBox.getWidth();
		y3 = boundingBox.getY() + boundingBox.getHeight();
	}

	public int getX1()	{ return x1; }
	public int getY1()	{ return y1; }
	public int getX2()	{ return x2; }
	public int getY2()	{ return y2; }
	public int getX3()	{ return x3; }
	public int getY3()	{ return y3; }

	@Override
	public void draw(PrintWriter output)
	{
		output.format("Triángulo: (%d, %d), (%d, %d), (%d, %d)", x1, y1, x2, y2, x3, y3);
	}

	/**
	 * Comprueba si el punto especificado pertenece a este triángulo. La
	 * implementación actual, por simplicidad, únicamente comprueba si el punto
	 * recibido coincide <em>exactamente</em> con uno de los vértices del
	 * triángulo (el algoritmo para calcular si un punto está realmente
	 * <em>dentro</em> de un triángulo dista mucho de ser trivial, y no nos
	 * afecta para nada al diseño del editor (podemos hacer ahora
	 * <em>prototipado rápido</em> y luego, en un futuro, ya cambiaremos esta
	 * implementación por una más sofisticada que realmente calcule cuándo el
	 * punto está dentro del triángulo.
	 *
	 * @returns {@code true} si y sólo si el punto especificado coincide con uno
	 *          de los tres vértices del triángulo; {@code false} en caso contrario
	 */
	@Override
	public boolean contains(int x, int y)
	{
		return (x == x1 && y == y1) ||
				   (x == x2 && y == y2) ||
				   (x == x3 && y == y3);
	}

	@Override
	public void moveBy(int dx, int dy)
	{
		x1 += dx; y1 += dy;
		x2 += dx; y2 += dy;
		x3 += dx; y3 += dy;
	}

	@Override
	public String toString()
	{
		return String.format("Triángulo: (%d, %d), (%d, %d), (%d, %d)", x1, y1, x2, y2, x3, y3);
	}
}
