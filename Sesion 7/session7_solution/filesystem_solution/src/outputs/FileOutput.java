package outputs;

import java.io.*;

public class FileOutput implements Output 
{
	public FileOutput(String fileName) throws IOException 
	{
		file = new FileWriter(fileName);
	}

	public void send(char c) throws IOException 
	{
		file.append(c);
	}

	public void close() throws IOException 
	{
		file.close();
	}

	private FileWriter file;
}
