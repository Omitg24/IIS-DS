package outputs.filters;

import java.io.*;

import outputs.*;

public class LinesFilter extends AbstractFilter implements Output 
{
	public LinesFilter(Output output) 
	{
		super(output);
	}

	public void send(char c) throws IOException 
	{
		if (c != '\r')
			output.send(c);
	}
}
