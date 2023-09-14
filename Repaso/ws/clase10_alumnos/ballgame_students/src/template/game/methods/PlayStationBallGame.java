package template.game.methods;

import java.awt.Point;

import template.platform.playstation.PlayStation5API;
import template.game.BallGame;
import template.platform.Image2D;

public class PlayStationBallGame extends BallGame {

	private PlayStation5API playStation;	
	
	public PlayStationBallGame() {
		this.playStation = new PlayStation5API();
	}
	
	public PlayStationBallGame(PlayStation5API playStation) {
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
