package extension.interpreter;
import java.io.IOException;
import java.util.List;

public class Interpreter
{
	private List<Instruction> instructions;
	private Memory memory = new Memory();

	public Interpreter(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public void run() throws IOException {
		while (memory.getIp() < instructions.size()) {
			instructions.get(memory.getIp()).execute(memory);
		}
	}
}
