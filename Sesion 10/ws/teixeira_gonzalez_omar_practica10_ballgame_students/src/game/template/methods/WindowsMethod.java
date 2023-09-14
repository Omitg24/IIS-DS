package game.template.methods;

import java.awt.Point;

import game.template.BallGameTemplateMethod;
import platform.Image2D;
import platform.windows.WindowsAPI;

public class WindowsMethod extends BallGameTemplateMethod{
	
	private WindowsAPI windows;
	
	public WindowsMethod() {
		this.windows = new WindowsAPI();
	}	
	
	@Override
	public Image2D loadImage(String file) {
		return windows.loadFile(file);
	}

	@Override
	public Point getPosition() {
		return windows.getMouseClick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		windows.paint(point.x, point.y, image);
	}
}
