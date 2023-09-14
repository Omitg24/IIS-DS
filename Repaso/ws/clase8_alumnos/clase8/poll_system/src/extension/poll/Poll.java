package extension.poll;

import java.util.ArrayList;
import java.util.List;

public class Poll
{
	private List<Observer> observers = new ArrayList<Observer>(); 	
	private int yeses, nos;
	private String question;

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
		saveResults();
		notifyObservers();		
	}

	public void incrementNos()
	{
		nos++;
		saveResults();
		notifyObservers();		
	}
	
	private void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}			
	}
	
	public void attachObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void detachObserver(Observer observer) {
		observers.remove(observer);
	}

	private void saveResults()
	{
		System.out.println("Guardando los resultados...");
	}
}
