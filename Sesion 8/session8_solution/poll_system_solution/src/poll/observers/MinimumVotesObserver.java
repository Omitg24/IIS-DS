package poll.observers;

import poll.Poll;
import poll.PollObserver;

/**
 * Decorador.
 */
public class MinimumVotesObserver implements PollObserver 
{
	private int minimumNumberOfVotes;
	private PollObserver observer;
	
	public MinimumVotesObserver(int minimumNumberOfVotes, PollObserver observer)
	{
		this.minimumNumberOfVotes = minimumNumberOfVotes;
		this.observer = observer;
	}
	
	@Override
	public void update(Poll poll) 
	{
		if (poll.getYeses() + poll.getNos() >= minimumNumberOfVotes) {
			observer.update(poll);
		}
	}	
}
