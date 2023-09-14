package extension.editor;

import java.util.ArrayList;
import java.util.List;

import extension.editor.interfaces.Figure;

public class Drawing
{
	private List<Figure> figures = new ArrayList<>();

	public void draw()
	{
		if (figures.isEmpty()) {
			System.out.println("Estoy vacío (por ahora)");
			return;
		}
		System.out.println("Figuras: ");
		for (Figure f : figures) {
			f.draw();
		}
	}

	public List<Figure> getFigures() {
		return figures;
	}

	public void add(Figure figure) {
		this.figures.add(figure);
	}

	public void remove(Figure figure) {
		this.figures.remove(figure);
	}
}
