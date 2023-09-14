package base.main;
import java.io.IOException;

import base.poll.Poll;
import base.ui.Interviewer;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}

