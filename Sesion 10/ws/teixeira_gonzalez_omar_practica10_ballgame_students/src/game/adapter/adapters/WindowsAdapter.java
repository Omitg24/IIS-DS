package game.adapter.adapters;

import java.awt.Point;

import platform.Image2D;
import platform.windows.WindowsAPI;

public class WindowsAdapter implements Platform{

	private WindowsAPI windows;
	
	public WindowsAdapter() {
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
