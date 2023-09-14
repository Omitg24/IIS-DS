package vm;

import java.util.List;

public class Context 
{
	public static final int STACK_SIZE = 32;
	public static final int MEMORY_SIZE = 1024;

	private int[] memory = new int[MEMORY_SIZE];
	private int[] stack = new int[STACK_SIZE];	

	private int ip = 0, sp = 0;
	
	/*
	 * Podría estar perfectamente en la propia máquina virtual y no aquí. Si se
	 * ha movido al contexto es simplemente para, en caso de haber algún error,
	 * que se pueda mostrar en qué instrucción concreta se produjo, así como
	 * para controlar que, al modificar el puntero de instrucción, el nuevo valor
	 * sea uno dentro del área de instrucciones del programa actual.
	 */
	private List<Instruction> program;
	
	Context(List<Instruction> program)
	{
		this.program = program;
	}

	// Operaciones que manipulan la pila

	public void push(int value) throws ProgramException
	{
		if (sp == stack.length)
			executionError("La pila está llena, no se ha podido añadir el valor: " + value);
		stack[sp++] = value;
	}
	
	public int pop() throws ProgramException 
	{
		if (sp == 0)
			executionError("La pila está vacía, no se ha podido extraer un valor");
		return stack[--sp];
	}
	
	// Operaciones que manipulan el puntero de instrucciones
	
	public void setIp(int ip) throws ProgramException
	{
		if (ip < 0 || ip >= program.size())
			executionError("Acceso fuera del área de instrucciones: " + ip);
		this.ip = ip;
	}
	
	public void incrementIp()
	{
		ip++;
		assert ip <= program.size() : "¿Cómo ha podido llegar a tener IP un valor inválido al incrementarse?";
	}
	
	int getIp()
	{
		return ip;
	}
	
	// Operaciones que manipulan la memoria
	
	public int read(int address) throws ProgramException
	{
		checkMemoryAddress(address);
		return memory[address];
	}
	
	public void write(int address, int value) throws ProgramException
	{
		checkMemoryAddress(address);
		memory[address] = value;
	}
	
	private void checkMemoryAddress(int address) throws ProgramException
	{
		if (address < 0 || address > memory.length)
			executionError("Dirección de memoria incorrecta: " + address);		
	}
	
	private void executionError(String message) throws ProgramException
	{
		throw new ProgramException(program.get(ip), message);
	}
}
