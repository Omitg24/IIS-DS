package outputs.formatters;

import java.io.IOException;

import outputs.Formatter;
import outputs.Output;

public class Normalize extends Formatter {	
	
	public Normalize(Output output) {
		super(output);
	}
	
	@Override
	public void send(char c) throws IOException {
		if (c != '\r') {
			this.output.send(c);
		}
	}
}
