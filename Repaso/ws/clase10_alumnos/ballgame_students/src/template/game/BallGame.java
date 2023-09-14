package template.game;

import java.awt.Point;

import template.platform.Image2D;

/* Esta clase (y todo el código que hubiera dentro de este paquete) sería el
 * código del videojuego completo, y es lo que se desea reutilizar en las distintas
 * plataformas.
 */

public abstract class BallGame
{
	public void play()
	{
		Image2D image = loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = getPosition();
			drawBall(image, point);
		}
	}

	public abstract Image2D loadImage(String file);
	
	public abstract Point getPosition();
	
	public abstract void drawBall(Image2D image, Point point);
}
