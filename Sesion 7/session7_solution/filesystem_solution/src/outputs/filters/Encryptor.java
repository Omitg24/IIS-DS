package outputs.filters;

import java.io.*;

import outputs.*;

public class Encryptor extends AbstractFilter implements Output 
{
	public Encryptor(Output output) 
	{
		super(output);
	}

	public void send(char c) throws IOException 
	{
		output.send((char) (Character.isLetterOrDigit(c) ? c + 1 : c));
	}
}
