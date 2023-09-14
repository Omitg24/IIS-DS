package extension.poll.observers;

import extension.poll.Observer;
import extension.poll.Poll;

public class StateLine implements Observer {

	@Override
	public void update(Poll poll) {
		System.out.println("nº de votos SI = <" + poll.getYeses() + ">. nº de votos NO = <" + poll.getNos() + ">");
	}
}
