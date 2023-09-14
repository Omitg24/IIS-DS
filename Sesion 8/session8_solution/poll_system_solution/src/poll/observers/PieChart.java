package poll.observers;

import poll.*;

public class PieChart implements PollObserver
{
	@Override
	public void update(Poll poll) 
	{
		System.out.println("Dibujando gráfico circular...");
	}
}
