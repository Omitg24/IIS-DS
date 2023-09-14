package outputs.formatters;

import java.io.IOException;

import outputs.Formatter;
import outputs.Output;

public class CharCounter extends Formatter {

	private int charCounter = 0;
	
	public CharCounter(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		this.output.send(c);
		charCounter++;
	}
	
	public int getCharCounter() {
		return charCounter;
	}
}
