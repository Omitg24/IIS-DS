package platform.playstation;

import java.awt.Point;

import platform.*;


public class Playstation5API 
{
	public Image2D loadGraphics(String name) 
	{
		System.out.println("(PS5) Cargada imagen '" + name + "' del DVD.");
		return new Image2D(name, 10, 10);
	}

	public void render(int x, int y, Image2D image) 
	{
		System.out.println("(PS5) Dibujando '" + image.getName() + "' en [" + x + "," + y + "]");
	}

	/**
	 * Devuelve el punto donde el usuario ha pulsado el botón "X" del mando.
	 * @return un objeto punto (Point) con las coordenadas donde se ha pulsado
	 *         el botón "X".
	 */
	public Point getJoystick() 
	{
		point.translate(10, 10);
		return new Point(point);
	}

	private Point point = new Point(0, 0);
}
