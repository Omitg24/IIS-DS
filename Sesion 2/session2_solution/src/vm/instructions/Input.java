package vm.instructions;

import java.util.Scanner;

import vm.Context;
import vm.Instruction;
import vm.ProgramException;

public class Input extends AbstractInstruction implements Instruction
{
	@Override
	protected void run(Context context) throws ProgramException 
	{
		System.out.print("Escriba un entero: ");
		context.push(readValue());			
	}
	
	private int readValue() 
	{
		Scanner scanner = new Scanner(System.in);
		int result;
		while (!scanner.hasNextInt()) {
			System.out.println("¡Debe ser un valor entero!");
			System.out.print("Escriba un entero: ");
			scanner.next();
		}
		result = scanner.nextInt();
		scanner.close();
		return result;
	}
	
	@Override
	public String toString()
	{
		return "INPUT";
	}
}
