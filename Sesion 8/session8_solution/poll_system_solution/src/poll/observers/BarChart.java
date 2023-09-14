package poll.observers;

import poll.*;

public class BarChart implements PollObserver
{
	@Override
	public void update(Poll poll) 
	{
		System.out.println("Dibujando gráfico de barras...");
	}
}
