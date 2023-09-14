package poll.managements;

import poll.Poll;
import poll.PollManager;

/**
 * Titulo: Clase Activator
 * 
 * @author Omar Teixeira González, UO281847
 * @version 9 nov 2022
 */
public class Activator implements PollManager {
	/**
	 * Atributo poll
	 */
	private PollManager pollManager;	
	/**
	 * Atributo startCount
	 */
	private int startCount;	
	/**
	 * Atributo counter
	 */
	private int counter = 1;
	
	/**
	 * Constructor Activator
	 * @param pollManager
	 * @param startCount
	 */
	public Activator(PollManager pollManager, int startCount) {
		this.pollManager = pollManager;
		this.startCount = startCount;
	}
	
	/**
	 * Método manage
	 */
	@Override
	public void manage(Poll poll) {
		if (counter >= startCount) {
			pollManager.manage(poll);
		} else {
			counter++;
		}
	}
}
