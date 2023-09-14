package template.main;

import template.game.methods.AndroidBallGame;
import template.game.methods.PlayStationBallGame;
import template.game.methods.WindowsBallGame;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Versión de Android: ");
		AndroidBallGame androidVersion = new AndroidBallGame();
		androidVersion.play();
		System.out.println("Versión de Windows: ");
		WindowsBallGame windowsVersion = new WindowsBallGame();
		windowsVersion.play();
		System.out.println("Versión de PlayStation: ");
		PlayStationBallGame playStationVersion = new PlayStationBallGame();
		playStationVersion.play();
	}
}
