package game.adapter;

import java.awt.Point;

import game.adapter.adapters.Platform;
import platform.Image2D;

/* Esta clase (y todo el código que hubiera dentro de este paquete) sería el
 * código del videojuego completo, y es lo que se desea reutilizar en las distintas
 * plataformas.
 */
public class BallGameAdapter 
{
	// Decide para qué plataform queremos generar el juego
	private Platform platform;

	public BallGameAdapter(Platform platform) {
		this.platform = platform;
	}
	
	
	public void play() 
	{

		Image2D image = platform.loadImage("ball.png");

		// lógica principal del juego
		for (int i = 0; i < 10; i++) {
			Point point = platform.getPosition();
			platform.drawBall(image, point);
		}
	}
}
