package poll;

public class Poll 
{
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
		updatePieChart();
		updateBarChart();
		saveResults();
	}

	public void incrementNos() 
	{
		nos++;
		updatePieChart();
		updateBarChart();
		saveResults();
	}

	private void updateBarChart() 
	{
		System.out.println("Dibujando un gráfico de barras...");
	}

	private void updatePieChart() 
	{
		System.out.println("Dibujando un gráfico circular...");
	}

	private void saveResults() 
	{
		System.out.println("Guardando los resultados...");
	}
}
