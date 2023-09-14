package poll.managements;

import poll.Poll;
import poll.PollManager;

/**
 * Titulo: Clase CountResults
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class CountResults implements PollManager {
	
	/**
	 * Método manage
	 */
	@Override
	public void manage(Poll poll) {
		System.out.println("nº de votos SI=" + poll.getYeses() + ". nº de votos NO=" + poll.getNos());
	}
}
