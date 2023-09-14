package main;

import java.io.*;

import outputs.*;

public class FileSystem
{
	public void copyFile(String name, Output output) 
	{
		try {
			FileReader reader = new FileReader(name);

			int c;
			while ((c = reader.read()) != -1)
				output.send((char) c);

			reader.close();
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
