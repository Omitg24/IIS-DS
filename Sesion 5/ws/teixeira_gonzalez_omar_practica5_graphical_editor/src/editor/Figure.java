package editor;

/**
 * Título: Interfaz Figure
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public interface Figure {
	/**
	 * Método draw
	 */
	public void draw();

	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	public void move(int x, int y);

	/**
	 * Método contains
	 * @param x
	 * @param y
	 * @return true o false
	 */
	public boolean contains(int x, int y);
}
