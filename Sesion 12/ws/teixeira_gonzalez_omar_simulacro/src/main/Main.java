package main;

import java.io.IOException;

import gui.UserInterface;

public class Main 
{
	

	public static void main(String[] args) throws IOException 
	{
		Editor editor = new Editor();
		UserInterface ui = new UserInterface(editor);
		ui.run();
	}
}
