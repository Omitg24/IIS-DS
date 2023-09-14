package extension.editor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Editor {

	private StringBuilder text = new StringBuilder("");

	public void open(String str) throws IOException {
		this.text = readFile(str);
	}

	public void insert(String[] line) {
		for (int i = 1; i < line.length; i++) {
			this.text.append(line[i] + " ");
		}
	}

	public void delete() {
		int indexOfLastWord = this.text.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1) {
			this.text = new StringBuilder("");
		} else {
			this.text.setLength(indexOfLastWord + 1);
		}
	}

	public void replace(String cad1, String cad2) {
		this.text = new StringBuilder(text.toString().replaceAll(Pattern.quote(cad1), cad2));
	}

	private StringBuilder readFile(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}

	public StringBuilder getText() {
		return text;
	}
}
