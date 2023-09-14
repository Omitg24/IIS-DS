package main;

import java.io.IOException;

import editor.core.Editor;
import editor.ui.Menu;

public class Main 
{
	public static void main(String[] args) throws IOException
	{
		Editor editor = new Editor();
		Menu menu = new Menu(editor);
		menu.run();
	}
}
