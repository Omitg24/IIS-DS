package editor;

/**
 * Título: Interfaz Tool
 * 
 * @author Omar Teixeira González, UO281847
 * @version 8 oct 2022
 */
public interface Tool {
	/**
	 * Método click
	 * @param x
	 * @param y
	 */
	public void click(int x, int y);
	
	/**
	 * Método move
	 * @param x
	 * @param y
	 */
	public void move(int x, int y);
	
	/**
	 * Método release
	 */
	public void release();
}
