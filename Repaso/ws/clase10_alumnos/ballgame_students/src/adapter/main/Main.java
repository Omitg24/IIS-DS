package adapter.main;

import adapter.game.adapters.*;
import adapter.game.BallGame;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Versión de Android:");
		BallGame androidVersion = new BallGame(new AndroidAdapter());
		androidVersion.play();
		System.out.println("Versión de Windows:");
		BallGame windowsVersion = new BallGame(new WindowsAdapter());
		windowsVersion.play();
		System.out.println("Versión de PlayStation:");
		BallGame playStationVersion = new BallGame(new PlayStationAdapter());
		playStationVersion.play();
	}
}
