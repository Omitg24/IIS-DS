package extension.main;
import java.io.IOException;

import extension.poll.Poll;
import extension.poll.observers.*;
import extension.ui.Interviewer;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Interviewer interviewer = new Interviewer();
		
		//EJEMPLO DADO
		Poll pollExample = new Poll("¿Cree que existe vida similar a la humana en otros planetas?");
		pollExample.attachObserver(new BarChart());
		pollExample.attachObserver(new PieChart());
//		interviewer.fill(pollExample);
		
		//MODIFICACION 1
		Poll poll1 = new Poll("¿Le gustaría poder sentarse a conversar con una deidad?");
		poll1.attachObserver(new BarChart());
		poll1.attachObserver(new PieChart());
		poll1.attachObserver(new StateLine());
//		interviewer.fill(poll1);
		
		//MODIFICACION 2
		Poll poll2 = new Poll("¿Le gustaría cambiar alguna parte de su cuerpo?");
		poll2.attachObserver(new PieChart());
		poll2.attachObserver(new StateLine());
//		interviewer.fill(poll2);
		
		//MODIFICACION 3
		Poll poll3 = new Poll("¿Si le ofrecieran convertirse en un robot, aceptaría?");
		poll3.attachObserver(new StartCounter(new PieChart(), 3));
		poll3.attachObserver(new StateLine());
//		interviewer.fill(poll3);
		
		//MODIFICACION 4
		Poll poll4 = new Poll("¿Le gusta la carrera que está estudiando?");
		poll4.attachObserver(new RepeatCounter(new BarChart(), 3));
		poll4.attachObserver(new StartCounter(new PieChart(), 3));
		poll4.attachObserver(new StateLine());
//		interviewer.fill(poll4);
		
		//MODIFICACION 5
		Poll poll5 = new Poll("¿Ha copiado algún trabajo o examen en algún momento de su vida?");
		poll5.attachObserver(new RepeatCounter(new BarChart(), 3));
		poll5.attachObserver(new StartCounter(new PieChart(), 3));
		poll5.attachObserver(new StartCounter(new RepeatCounter(new StateLine(), 2), 4));
		interviewer.fill(poll5);		
	}
}

