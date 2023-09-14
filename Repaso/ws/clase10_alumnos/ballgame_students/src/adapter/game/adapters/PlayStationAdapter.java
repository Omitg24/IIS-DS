package adapter.game.adapters;

import java.awt.Point;

import adapter.platform.Platform;
import adapter.platform.playstation.PlayStation5API;
import template.platform.Image2D;

public class PlayStationAdapter implements Platform {

	private PlayStation5API playStation;	
	
	public PlayStationAdapter() {
		this.playStation = new PlayStation5API();
	}
	
	public PlayStationAdapter(PlayStation5API playStation) {
		this.playStation = playStation;
	}

	@Override
	public Image2D loadImage(String file) {
		return this.playStation.loadGraphics(file);
	}

	@Override
	public Point getPosition() {
		return this.playStation.getJoystick();
	}

	@Override
	public void drawBall(Image2D image, Point point) {
		this.playStation.render(point.x, point.y, image);
	}

}
