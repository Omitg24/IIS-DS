package outputs;

import java.io.*;

public class Bluetooth implements Output 
{
	public Bluetooth(String device) 
	{
		stringWriter = new StringWriter();
		stringWriter.append("\n--- START Bluetooth [" + device + "]\n");
	}

	public void send(char c) throws IOException 
	{
		stringWriter.append(c);
	}

	public void close() throws IOException 
	{
		System.out.print(stringWriter.toString());
		System.out.println("\n--- END   Bluetooth");
	}

	private StringWriter stringWriter;
}
