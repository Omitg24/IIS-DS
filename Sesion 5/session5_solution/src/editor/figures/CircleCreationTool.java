package editor.figures;

import editor.core.*;
import editor.tools.*;

public class CircleCreationTool extends AbstractCreationTool implements Tool 
{	
	public CircleCreationTool(Editor editor)
	{
		super(editor);
	}
	
	@Override
	protected Figure createFigure(BoundingBox boundingBox) 
	{
		return new Circle(boundingBox);
	}

	@Override
	public String toString()
	{
		return "Herramienta de creación de círculo";
	}
}
