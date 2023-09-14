package poll;

import java.util.ArrayList;
import java.util.List;

/**
 * Titulo: Clase Poll
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class Poll 
{
	/**
	 * Atributos yeses y nos
	 */
	private int yeses, nos;
	/**
	 * Atributo question
	 */
	private String question;
	/**
	 * Atributo managements
	 */
	private List<PollManager> managements = new ArrayList<PollManager>();
	
	/**
	 * Constructor Poll
	 * @param question
	 */
	public Poll(String question) 
	{
		this.question = question;
	}

	/**
	 * Método getQuestion
	 * @return question
	 */
	public String getQuestion() 
	{
		return question;
	}

	/**
	 * Método getYeses
	 * @return yeses
	 */
	public int getYeses() 
	{
		return yeses;
	}

	/**
	 * Método getNos
	 * @return nos
	 */
	public int getNos() 
	{
		return nos;
	}

	/**
	 * Método incrementYeses
	 */
	public void incrementYeses() 
	{
		yeses++;
		informUser();
	}

	/**
	 * Método incrementNos
	 */
	public void incrementNos() 
	{
		nos++;
		informUser();
	}
	
	/**
	 * Método addManagement
	 * @param management
	 */
	public void addManagement(PollManager management) {
		managements.add(management);
	}
	
	/**
	 * Método removeManagement
	 * @param management
	 */
	public void removeManagement(PollManager management) {
		managements.remove(management);
	}
	
	/**
	 * Método informUser
	 */
	private void informUser() {
		for (PollManager management : managements) {
			management.manage(this);
		}
	}
}
