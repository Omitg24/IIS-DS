package poll.observers;

import poll.Poll;
import poll.PollObserver;

public class FrequencyObserver implements PollObserver
{
	private int counter, frequency;
	private PollObserver otherObserver;

	public FrequencyObserver(int frequency, PollObserver otherObserver) 
	{
		this.otherObserver = otherObserver;
		this.counter = this.frequency = frequency;
	}

	@Override
	public void update(Poll poll) 
	{
		if (counter == frequency) {
			otherObserver.update(poll);
			counter = 1;
		} else
			counter++;
	}
}