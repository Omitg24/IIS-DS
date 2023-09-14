package main;
import java.io.*;

import poll.*;
import ui.Interviewer;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Poll poll = new Poll("¿Está a favor de la energia nuclear?");

		Interviewer interviewer = new Interviewer();
		interviewer.fill(poll);
	}
}

