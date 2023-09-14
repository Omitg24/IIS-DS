package poll.managements;

import poll.Poll;
import poll.PollManager;

/**
 * Titulo: Clase BarChart
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class BarChart implements PollManager {

	/**
	 * Método manage
	 */
	@Override
	public void manage(Poll poll) {
		System.out.println("Dibujando un gráfico de barras...");
	}
}
