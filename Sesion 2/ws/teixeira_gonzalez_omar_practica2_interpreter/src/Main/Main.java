package Main;

import VirtualMachine.Interpreter;

/**
 * Título: Clase Main
 * 
 * @author Omar Teixeira González, UO281847
 * @version 26 sept 2022
 */
public class Main {
	
	/**
	 * Constante Factorial
	 */
	private static final String FACTORIAL = "factorial.txt";
	/**
	 * Constante Fibonacci
	 */
	//private static final String FIBONACCI = "fibonacci.txt";
	
	/**
	 * Método main
	 * @param args, argumento a analizar
	 */
	public static void main(String[] args) {
		Interpreter.executeProgram(FACTORIAL);
		//Interpreter.executeProgram(FIBONACCI);
	}
}
