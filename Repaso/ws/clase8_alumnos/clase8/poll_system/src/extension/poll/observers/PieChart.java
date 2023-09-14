package extension.poll.observers;

import extension.poll.Observer;
import extension.poll.Poll;

public class PieChart implements Observer {

	@Override
	public void update(Poll poll) {
		System.out.println("Dibujando un gráfico circular...");
	}

}
