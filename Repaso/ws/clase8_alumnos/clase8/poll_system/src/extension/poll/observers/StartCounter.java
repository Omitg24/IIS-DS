package extension.poll.observers;

import extension.poll.Observer;
import extension.poll.Poll;

public class StartCounter implements Observer {
	
	private Observer observer;
	
	private int counter, startCounter;
	
	public StartCounter(Observer observer, int startCounter) {
		this.observer = observer;
		this.startCounter = startCounter;		
	}

	@Override
	public void update(Poll poll) {
		this.counter++;
		if (this.counter >= this.startCounter) {
			this.observer.update(poll);
		}		
	}

}
