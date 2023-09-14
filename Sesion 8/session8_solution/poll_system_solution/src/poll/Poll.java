package poll;

import java.util.ArrayList;
import java.util.List;

public class Poll 
{
	private int yeses, nos;
	private String question;
	private List<PollObserver> observers = new ArrayList<>();
	
	public Poll(String question) 
	{
		this.question = question;
	}

	public String getQuestion() 
	{
		return question;
	}

	public int getYeses() 
	{
		return yeses;
	}

	public int getNos() 
	{
		return nos;
	}

	public void incrementYeses() 
	{
		yeses++;
		notifyObservers();
	}

	public void incrementNos() 
	{
		nos++;
		notifyObservers();
	}
	
	public void addObserver(PollObserver observer)
	{
		observers.add(observer);
	}
	
	public void removeObserver(PollObserver observer)
	{
		observers.remove(observer);
	}

	private void notifyObservers() 
	{
		for (PollObserver each : observers) {
			each.update(this);
		}
	}
}
