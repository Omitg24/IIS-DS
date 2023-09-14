package main;
import java.io.IOException;

import poll.Poll;
import poll.managements.*;
import ui.Interviewer;

/**
 * Titulo: Clase Main
 *
 * @author Omar Teixeira González, UO281847
 * @version 7 nov 2022
 */
public class Main 
{
	/**
	 * Método main
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		Interviewer interviewer = new Interviewer();
		
		//Programa base
		Poll pollBase = new Poll("¿Está a favor de la energia nuclear?");
		pollBase.addManagement(new BarChart());
		pollBase.addManagement(new PieChart());
		pollBase.addManagement(new SaveResults());
		
		interviewer.fill(pollBase);
		
		//Programa 1
		Poll poll1 = new Poll("¿Está a favor de la compra de Twitter por Elon Musk?");
		poll1.addManagement(new BarChart());
		poll1.addManagement(new PieChart());
		poll1.addManagement(new SaveResults());
		poll1.addManagement(new CountResults());
		
		interviewer.fill(poll1);
		
		//Programa 2
		Poll poll2 = new Poll("¿Está a favor del impuesto de sucesión?");
		poll2.addManagement(new PieChart());
		poll2.addManagement(new SaveResults());
		poll2.addManagement(new CountResults());
		
		interviewer.fill(poll2);
		
		//Programa 3
		Poll poll3 = new Poll("¿Está a favor de la eutanasia?");
		poll3.addManagement(new CountResults());
		poll3.addManagement(new Activator(new PieChart(), 3));
		
		interviewer.fill(poll3);
		
		//Programa 4
		Poll poll4 = new Poll("¿Está a favor de la legalización de las drogas?");
		poll4.addManagement(new CountResults());
		poll4.addManagement(new Activator(new PieChart(), 3));
		poll4.addManagement(new Repeater(new BarChart(), 3));
		
		interviewer.fill(poll4);
		
		//Programa 5
		Poll poll5 = new Poll("¿Está a favor del aborto?");		
		poll5.addManagement(new Activator(new PieChart(), 3));
		poll5.addManagement(new Repeater(new BarChart(), 3));
		poll5.addManagement(new Activator(new Repeater(new CountResults(), 2),4));
		
		interviewer.fill(poll5);
	}
}

