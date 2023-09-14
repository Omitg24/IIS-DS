package outputs.filters;

import java.io.*;

import outputs.*;

public class SpacesFilter extends AbstractFilter implements Output 
{
	public SpacesFilter(Output output) 
	{
		super(output);
	}

	public void send(char c) throws IOException 
	{
		if (c == ' ' && lastChar == ' ')
			return;

		output.send(c);
		lastChar = c;
	}

	private char lastChar = 0;
}
