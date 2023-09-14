package poll.managements;

import poll.Poll;
import poll.PollManager;

/**
 * Titulo: Clase SaveResults
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class SaveResults implements PollManager {

	/**
	 * Método manage
	 */
	@Override
	public void manage(Poll poll) {
		System.out.println("Guardando los resultados...");
	}

}
