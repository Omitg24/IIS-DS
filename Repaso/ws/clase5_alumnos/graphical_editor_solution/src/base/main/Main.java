package base.main;

import java.io.IOException;

import base.editor.core.Editor;
import base.editor.figures.CircleCreationTool;
import base.editor.figures.RectangleCreationTool;
import base.editor.figures.TriangleCreationTool;
import base.editor.ui.Menu;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Editor editor = new Editor();
		Menu menu = new Menu(editor);

		//-- Se registran las distintas herramientas
		menu.addTool("seleccion", editor.getDefaultTool());
		menu.addTool("rectangulo", new RectangleCreationTool(editor));
		menu.addTool("circulo", new CircleCreationTool(editor));
		menu.addTool("triangulo", new TriangleCreationTool(editor));

		menu.run();
	}
}
