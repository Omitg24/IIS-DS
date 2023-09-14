package extension.interpreter;

public class Memory {

	private int ip = 0;

	private int[] memory = new int[1024];

	private int[] stack = new int[32];

	private int sp = 0;

	public void push(int value)
	{
		stack[sp] = value;
		sp++;
	}

	public int pop()
	{
		sp--;
		return stack[sp];
	}

	public void incrementIp() {
		this.ip++;
	}

	public void jumpTo(int value) {
		this.ip = value;
	}

	public int getIp() {
		return ip;
	}

	public int getMemory(int address) {
		return memory[address];
	}

	public void updateMemory(int address, int value) {
		this.memory[address] = value;
	}
}