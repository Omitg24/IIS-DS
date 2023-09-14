package template.game.methods;

import java.awt.Point;

import template.platform.android.AndroidAPI;
import template.game.BallGame;
import template.platform.Image2D;

public class AndroidBallGame extends BallGame{

	private AndroidAPI android;

	public AndroidBallGame() {
		this.android = new AndroidAPI();
	}
	
	public AndroidBallGame(AndroidAPI android) {
		this.android = android;
	}

	@Override
	public Image2D loadImage(String file) {		
		return this.android.loadResource(file);
	}

	@Override
	public Point getPosition() {
		return this.android.getTouch();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		this.android.draw(point.x, point.y, image);
	}	
}
