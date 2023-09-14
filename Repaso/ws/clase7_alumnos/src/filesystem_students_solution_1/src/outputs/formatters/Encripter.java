package outputs.formatters;

import java.io.IOException;

import outputs.Formatter;
import outputs.Output;

public class Encripter extends Formatter {

	public Encripter(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		this.output.send((char) (Character.isLetterOrDigit(c) ? c + 1 : c));
	}

}
