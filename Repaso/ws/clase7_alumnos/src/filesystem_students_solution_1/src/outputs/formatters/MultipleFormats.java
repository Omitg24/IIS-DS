package outputs.formatters;

import java.io.IOException;

import outputs.Output;

public class MultipleFormats implements Output {

	private Output[] outputs;
	
	public MultipleFormats(Output... outputs) {
		this.outputs = outputs;
	}

	@Override
	public void send(char c) throws IOException {
		for (Output output : outputs) {
			output.send(c);
		}
	}

	@Override
	public void close() throws IOException {
		for (Output output : outputs) {
			output.close();
		}
	}

}
