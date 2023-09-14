package outputs.formatters;

import java.io.IOException;

import outputs.Formatter;
import outputs.Output;

public class SignCalculator extends Formatter {

	private byte signSum = 0;
	
	public SignCalculator(Output output) {
		super(output);
	}

	@Override
	public void send(char c) throws IOException {
		this.signSum += (byte) c;
		this.output.send(c);
	}
	
	public byte getSignSum()  {
		return this.signSum;
	}
}
