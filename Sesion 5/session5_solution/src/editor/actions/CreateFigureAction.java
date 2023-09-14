package editor.actions;

import editor.core.Drawing;
import editor.core.Figure;

public class CreateFigureAction implements Action
{
	private Drawing drawing;
	private Figure figure;
	
	public CreateFigureAction(Figure figure, Drawing drawing)
	{
		if (figure == null)
			throw new IllegalArgumentException("La acción de crear figura necesita la nueva figura a añadir al documento");
		if (drawing == null)
			throw new IllegalArgumentException("Se necesita una referencia no nula al documento de dibujo");
		this.figure = figure;
		this.drawing = drawing;
	}

	@Override
	public void execute() 
	{
		drawing.addFigure(figure);
	}

	@Override
	public void undo() 
	{
		drawing.removeFigure(figure);
	}
	
	@Override
	public String toString()
	{
		return "Añadir figura: " + figure;
	}
}
