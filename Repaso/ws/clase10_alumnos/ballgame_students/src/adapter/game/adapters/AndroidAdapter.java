package adapter.game.adapters;

import java.awt.Point;

import adapter.platform.Platform;
import adapter.platform.android.AndroidAPI;
import template.platform.Image2D;

public class AndroidAdapter implements Platform{

	private AndroidAPI android;

	public AndroidAdapter() {
		this.android = new AndroidAPI();
	}
	
	public AndroidAdapter(AndroidAPI android) {
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
