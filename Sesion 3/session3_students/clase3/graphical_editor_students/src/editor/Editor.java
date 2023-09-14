package editor;

public class Editor 
{	
	private Drawing drawing;
	
	public Editor(Drawing drawing)
	{
		setDrawing(drawing);
	}
	
	public Drawing getDrawing()
	{
		return drawing;
	}
	
	public void setDrawing(Drawing drawing)
	{
		this.drawing = drawing;
	}
	
	public void drawDocument()
	{
		drawing.draw();
	}	
}
