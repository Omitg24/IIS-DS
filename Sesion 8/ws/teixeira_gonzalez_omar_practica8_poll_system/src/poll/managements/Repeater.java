package poll.managements;

import poll.Poll;
import poll.PollManager;

/**
 * Titulo: Clase Repeater
 * 
 * @author Omar Teixeira González, UO281847
 * @version 9 nov 2022
 */
public class Repeater implements PollManager {
	/**
	 * Atributo pollManager
	 */
	private PollManager pollManager;
	/**
	 * Atributo repeaterCount
	 */
	private int repeaterCount;	
	/**
	 * Atributo counter
	 */
	private int counter;
	
	/**
	 * Constructor Repeater
	 * @param pollManager
	 * @param repeaterCount
	 */
	public Repeater(PollManager pollManager, int repeaterCount) {
		this.pollManager = pollManager;
		this.repeaterCount = this.counter = repeaterCount;
	}
	
	/**
	 * Método manage
	 */
	@Override
	public void manage(Poll poll) {
		if (counter == repeaterCount) {
			pollManager.manage(poll);
			this.counter = 1;
		} else {
			counter++;
		}

	}
}
