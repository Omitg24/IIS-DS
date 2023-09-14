package Instructions;

import java.util.InputMismatchException;
import java.util.Scanner;

import VirtualMachine.Instruction;
import VirtualMachine.State;

/**
 * Título: Clase Input
 * 
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Input implements Instruction {

	/**
	 * Método execute
	 */
	@Override
	public void execute(State state) {
		System.out.print("Escriba un entero: ");
		state.push(readValue());
		state.setIp(state.getIp() + 1);
	}
	
	/**
	 * Método readValue
	 * @return value, valor
	 */
	@SuppressWarnings("resource")
	private static int readValue() 
	{
		try {
			return new Scanner(System.in).nextInt();
		} catch (InputMismatchException ime){
			System.out.print("ERROR. Recuerde que debe introducir un número: ");
			return new Scanner(System.in).nextInt();
		}
	}
}
