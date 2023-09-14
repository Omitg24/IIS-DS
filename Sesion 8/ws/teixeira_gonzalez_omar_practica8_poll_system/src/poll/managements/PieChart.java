package poll.managements;

import poll.Poll;
import poll.PollManager;

/**
 * Titulo: Clase PieChart
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class PieChart implements PollManager {

	/**
	 * Método manage
	 */
	@Override
	public void manage(Poll poll) {
		System.out.println("Dibujando un gráfico circular...");
	}

}
