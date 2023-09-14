package extension.poll.observers;

import extension.poll.Observer;
import extension.poll.Poll;

public class RepeatCounter implements Observer {
	
	private Observer observer;
	
	private int counter, repeatCounter;
	
	public RepeatCounter(Observer observer, int repeatCounter) {
		this.observer = observer;
		this.repeatCounter = this.counter = repeatCounter;		
	}

	@Override
	public void update(Poll poll) {		
		if (this.repeatCounter == this.counter) {
			this.counter = 0;
			this.observer.update(poll);
		} 
		this.counter++;
	}

}
