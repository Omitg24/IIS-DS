package adapter.game.adapters;

import java.awt.Point;

import adapter.platform.Platform;
import adapter.platform.windows.WindowsAPI;
import template.platform.Image2D;

public class WindowsAdapter implements Platform {

	private WindowsAPI windows;
	
	public WindowsAdapter() {
		this.windows = new WindowsAPI();
	}
	
	public WindowsAdapter(WindowsAPI windows) {
		this.windows = windows;
	}

	@Override
	public Image2D loadImage(String file) {
		return this.windows.loadFile(file);
	}

	@Override
	public Point getPosition() {
		return this.windows.getMouseClick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		this.windows.paint(point.x, point.y, image);
	}

}
