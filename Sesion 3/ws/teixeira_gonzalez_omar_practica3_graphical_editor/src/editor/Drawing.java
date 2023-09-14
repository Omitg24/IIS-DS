package editor;

import java.util.ArrayList;
import java.util.List;

/**
 * Título: Clase Drawing
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public class Drawing {	
	/**
	 * Atributo figures
	 */
	private List<Figure> figures = new ArrayList<Figure>();
	
	/**
	 * Método addFigure
	 * @param figure
	 */
	public void addFigure(Figure figure) {
		figures.add(figure);
	}
	
	/**
	 * Método draw
	 */
	public void draw() {
		if (figures.isEmpty()) {
			System.out.println("Estoy vacío (por ahora)");
		} else {
			for (Figure f : figures) {
				f.draw();
			}
		}				
	}
	
	/**
	 * Método getFigure
	 * @param x
	 * @param y
	 * @return figure
	 */
	public Figure getFigure(int x, int y) {
		for (Figure f : figures) {
			if (f.contains(x, y)) {
				return f;
			}
		}
		return null;
	}
}