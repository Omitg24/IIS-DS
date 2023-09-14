package game.template.methods;

import java.awt.Point;

import game.template.BallGameTemplateMethod;
import platform.Image2D;
import platform.android.AndroidAPI;

public class AndroidMethod extends BallGameTemplateMethod{

	private AndroidAPI android;
	
	public AndroidMethod() {
		this.android = new AndroidAPI();
	}
	
	@Override
	public Image2D loadImage(String file) {
		return android.loadResource(file);
	}

	@Override
	public Point getPosition() {
		return android.getTouch();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		android.draw(point.x, point.y, image);;
	}
}
