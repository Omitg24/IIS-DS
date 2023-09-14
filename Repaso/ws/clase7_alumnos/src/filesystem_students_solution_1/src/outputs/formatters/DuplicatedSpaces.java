package outputs.formatters;

import java.io.IOException;

import outputs.Formatter;
import outputs.Output;

public class DuplicatedSpaces extends Formatter {

	private char previousChar;
	
	public DuplicatedSpaces(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		if (previousChar == ' ' && c == ' ') {
			return;
		}
		this.output.send(c);
		previousChar = c;
	}
}
