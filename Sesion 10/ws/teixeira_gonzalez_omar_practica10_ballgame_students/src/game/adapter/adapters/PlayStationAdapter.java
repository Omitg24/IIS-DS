package game.adapter.adapters;

import java.awt.Point;

import platform.Image2D;
import platform.playstation.Playstation5API;

public class PlayStationAdapter implements Platform {

	private Playstation5API playStation;
	
	public PlayStationAdapter() {
		this.playStation = new Playstation5API();
	}
	
	@Override
	public Image2D loadImage(String file) {
		return playStation.loadGraphics(file);
	}

	@Override
	public Point getPosition() {
		return playStation.getJoystick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		playStation.render(point.x, point.y, image);;
	}

}
