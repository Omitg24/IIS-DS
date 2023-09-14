package outputs;

import java.io.IOException;

public abstract class Formatter implements Output {
	
	protected Output output;
	
	public Formatter(Output output) {
		this.output = output;
	}

	@Override
	public void close() throws IOException {
		this.output.close();
	}
}
