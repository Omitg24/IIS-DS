import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class FileSystem
{
	public void copyFile(String name, String newName) throws IOException
	{
		FileWriter writer = new FileWriter(newName);

		try {
			FileReader reader = new FileReader(name);

			int c;
			while ((c = reader.read()) != -1)
				writer.append((char) c);

			reader.close();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendToInternet(String name, String url)
	{
		try {
			StringWriter stringWriter = new StringWriter();
			stringWriter.append("\n--- START Internet [" + url + "]\n");

			FileReader reader = new FileReader(name);

			int c;
			while ((c = reader.read()) != -1)
				stringWriter.append((char) c);

			reader.close();

			System.out.println(stringWriter.toString());
			System.out.println("--- END   Internet");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendWithBluetooth(String name, String device)
	{
		try {
			StringWriter stringWriter = new StringWriter();
			stringWriter.append("\n--- START Bluetooth [" + device + "]\n");

			FileReader reader = new FileReader(name);

			int c;
			while ((c = reader.read()) != -1)
				stringWriter.append((char) c);

			reader.close();

			System.out.println(stringWriter.toString());
			System.out.println("--- END   Bluetooth");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
