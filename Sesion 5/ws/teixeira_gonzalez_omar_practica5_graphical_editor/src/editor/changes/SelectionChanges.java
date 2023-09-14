package editor.changes;

import editor.Figure;

/**
 * Título: Clase SelectionChanges
 * 
 * @author Omar Teixeira González, UO281847
 * @version 18 oct 2022
 */
public class SelectionChanges implements Changes {
	/**
	 * Atributo figure
	 */
	private Figure figure;
	/**
	 * Atributo x
	 */
	private int x;
	/**
	 * Atributo y
	 */
	private int y;
	
	/**
	 * Constructor SelectionChanges
	 * @param figure
	 * @param x
	 * @param y
	 */
	public SelectionChanges(Figure figure, int x, int y) {
		this.figure=figure;
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Método undo
	 */
	@Override
	public void undo() {
		figure.move(-x, -y);
	}

	/**
	 * Método redo
	 */
	@Override
	public void redo() {
		figure.move(x, y);
	}

}
