package template.game.methods;

import java.awt.Point;

import template.platform.windows.WindowsAPI;
import template.game.BallGame;
import template.platform.Image2D;

public class WindowsBallGame extends BallGame {

	private WindowsAPI windows;
	
	public WindowsBallGame() {
		this.windows = new WindowsAPI();
	}
	
	public WindowsBallGame(WindowsAPI windows) {
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
