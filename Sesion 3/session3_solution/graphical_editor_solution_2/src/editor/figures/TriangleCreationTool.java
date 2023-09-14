package editor.figures;

import editor.core.*;

// El triángulo se crea a partir de tres puntos en vez de mediante una selección
// rectangular; de ese modo se ve mejor cómo las herramientas pueden implementar
// directamente la interfaz para proporcionar comportamientos muy diferentes e 
// imposibles de prever a priori. Además, demuestra que no se puede presuponer
// que las herramientas terminan cuando se suelta el botón del ratón, sino que 
// cada una puede hacerlo de formas muy distintas (en este caso, al efectuar el 
// tercer clic del ratón, pero podrían aparecer herramientas nuevas y terminar,
// a su vez, cada una a su manera).
//
public class TriangleCreationTool implements Tool 
{	
	private Editor editor;
	private int x1, y1, x2, y2, x3, y3; // las coordenadas de los tres vértices del triángulo
	private int vertices; // número de puntos creados
	
	public TriangleCreationTool(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("Se necesita una referencia al editor");
		this.editor = editor;		
	}

	@Override
	public void clickOn(int x, int y) 
	{
		vertices++;
		if (vertices == 1) {
			editor.getDrawing().clearCurrentSelection();
			x1 = x;
			y1 = y;
		} else if (vertices == 2) {
			x2 = x;
			y2 = y;
		} else if (vertices == 3) {
			x3 = x;
			y3 = y;
			editor.getDrawing().addFigure(new Triangle(x1, y1, x2, y2, x3, y3));
			vertices = 0;
			editor.toolDone();
		}		
	}

	@Override
	public void moveTo(int x, int y) 
	{
	}

	@Override
	public void release() 
	{
	}
	
	@Override
	public void unselect()
	{
		vertices = 0;		
	}
	
	@Override
	public String toString()
	{
		return "Herramienta de creación de triángulo";
	}
}
