package extension.editor;

import java.util.List;

import extension.editor.interfaces.Action;
import extension.editor.interfaces.Figure;
import extension.editor.interfaces.Tool;
import extension.editor.tools.Selection;

public class Editor
{
	private Drawing drawing;

	private Memory memory;

	private Tool currentTool;

	public Editor(Drawing drawing, Memory memory)
	{
		setDrawing(drawing);
		setMemory(memory);
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
		this.drawing.draw();
		System.out.println("Herramienta seleccionada: " + currentTool.toString());
	}

	public void addFigure(Figure figure) {
		this.drawing.add(figure);
	}

	public void setDefaultTool() {
		this.currentTool = new Selection(this);
	}

	public void setSelectionTool() {
		setDefaultTool();
	}

	public void setCreationsTool(Tool tool) {
		this.currentTool = tool;
	}

	public void click(int x, int y) {
		this.currentTool.click(x, y);
	}

	public void move(int x, int y) {
		this.currentTool.move(x, y);
	}

	public void release() {
		this.currentTool.release();
	}

	public Figure getFigure(int x, int y) {
		List<Figure> figures = this.drawing.getFigures();
		for (Figure f : figures) {
			if (f.contains(x, y)) {
				return f;
			}
		}
		return null;
	}

	private void setMemory(Memory memory) {
		this.memory = memory;
	}

	public void undo() {
		this.memory.undo();
	}

	public void redo() {
		this.memory.redo();
	}

	public void addUndo(Action action) {
		this.memory.add(action);
	}
}
