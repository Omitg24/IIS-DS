package editor.actions;

import editor.core.Figure;

public class MoveAction implements Action 
{
	private Figure figure;
	private int dx, dy;
	
	public MoveAction(Figure figure, int dx, int dy)
	{
		if (figure == null)
			throw new IllegalArgumentException("¡Se necesita la figura que ha sido movida!");
		this.figure = figure;
		this.dx = dx;
		this.dy = dy;
	}
	
	@Override
	public void execute() 
	{
		figure.moveBy(dx, dy);		
	}

	@Override
	public void undo() 
	{
		figure.moveBy(-dx, -dy);
	}
	
	@Override
	public String toString()
	{
		return String.format("Mover la figura %s %d píxeles en horizontal y %d en vertical",
				figure, dx, dy);
	}
}
