package outputs;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutput implements Output
{
	public FileOutput(String fileName) throws IOException
	{
		file = new FileWriter(fileName);
	}

	@Override
	public void send(char c) throws IOException
	{
		file.append(c);
	}

	@Override
	public void close() throws IOException
	{
		file.close();
	}

	private FileWriter file;
}
