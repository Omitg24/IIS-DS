package VirtualMachine;

/**
 * Título: Clase State
 * 
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class State {	
	/**
	 * Atributo memory
	 */
	private int[] memory = new int[1024];
	/**
	 * Atributo stack
	 */
	private int[] stack = new int[32];
	/**
	 * Atributo ip
	 */
	private int ip = 0;
	/**
	 * Atributo sp
	 */
	private int sp = 0;
	
	/**
	 * Método getIp
	 * @return ip
	 */
	public int getIp() {
		return ip;
	}

	/**
	 * Método setIp
	 * @param ip
	 */
	public void setIp(int ip) {
		this.ip = ip;
	}
	
	/**
	 * Método getSp
	 * @return sp
	 */
	public int getSp() {
		return sp;
	}

	/**
	 * Método setSp
	 * @param sp
	 */
	public void setSp(int sp) {
		this.sp = sp;
	}

	/**
	 * Método push
	 * @param value, valor
	 */
	public void push(int value) 
	{
		stack[sp] = value;
		sp++;
	}

	/**
	 * Método pop
	 * @return value, valor
	 */
	public int pop() 
	{
		sp--;
		return stack[sp];
	}
	
	/**
	 * Método readMemory
	 * @param address, dirección
	 * @return memory, memoria
	 */
	public int readMemory(int address) {
		return memory[address];
	}
	
	/**
	 * Método writeMemory
	 * @param address, dirección
	 * @param value, valor
	 */
	public void writeMemory(int address, int value) {
		memory[address]=value;
	}
}
