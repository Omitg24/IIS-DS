package outputs.filters;

import java.io.*;

import outputs.*;

public class Counter extends AbstractFilter 
{
	public Counter(Output output) 
	{
		super(output);
	}

	public void send(char c) throws IOException 
	{
		output.send(c);
		counter++;
	}
	
	public int getCounter() 
	{
		return counter;
	}

	private int counter;
}
