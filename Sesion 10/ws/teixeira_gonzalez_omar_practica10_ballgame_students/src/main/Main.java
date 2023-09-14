package main;

import game.adapter.BallGameAdapter;
import game.adapter.adapters.AndroidAdapter;
import game.adapter.adapters.PlayStationAdapter;
import game.adapter.adapters.WindowsAdapter;
import game.template.methods.AndroidMethod;
import game.template.methods.PlayStationMethod;
import game.template.methods.WindowsMethod;

public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("ADAPTER");
		BallGameAdapter game = new BallGameAdapter(new AndroidAdapter());
		game.play();
		game = new BallGameAdapter(new PlayStationAdapter());
		game.play();
		game = new BallGameAdapter(new WindowsAdapter());
		game.play();
		
		System.out.println("\nTEMPLATE METHOD");		
		AndroidMethod android = new AndroidMethod();
		android.play();
		PlayStationMethod playStation = new PlayStationMethod();
		playStation.play();
		WindowsMethod windows = new WindowsMethod();
		windows.play();
	}
}
