package adapter.platform;

import java.awt.Point;

import template.platform.Image2D;

public interface Platform {
	
	Image2D loadImage(String file);
	Point getPosition();
	void drawBall(Image2D image, Point point);
}
