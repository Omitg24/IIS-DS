package machine.hardware;

import java.util.Scanner;

/*
 	Representa el teclado físico de la máquina de venta de entradas. Toda la
 	interacción que ésta tenga que hacer CON EL USUARIO PIDIÉNDOLE DATOS DEBERÁ
 	HACERSE OBLIGATORIAMENTE A TRAVÉS DE ESTA CLASE (salvo en aquellos casos en
 	donde estos datos se están pidiendo como consecuencia de estar simulando el
 	funcionamiento de algún dispositivo físico, es decir, que no haría falta en
 	un caso real, en cuyo caso se hace leyendo de la entrada estándar directamente).
 */
public class Keyboard 
{
	private Scanner input = new Scanner(System.in);
	
	public int readInt()
	{
		do {
			try {
				return Integer.valueOf(input.nextLine());			
			} catch (NumberFormatException e) {
				System.out.print("Se espera un valor entero: ");
			}
		} while (true);
	}
	
	public String readString()
	{
		return input.nextLine();
	}
	
	/*
	 	Permite seleccionar una opción de entre varias. Para ello el usuario
	 	debe introducir un número entre 1 y el número de opciones especificado.
	 	¡Ojo!, que si se quiere utilizarlo como índice para seleccionar de una
	 	lista, que será lo habitual, habrá que restar uno al valor devuelto. 
	 */
	public int readOption(int numberOfOptions)
	{
		do {
			int option = readInt();
			if (option >= 1 && option <= numberOfOptions)
				return option;
			System.out.print("Debe escoger una opción entre 1 y " + numberOfOptions + ": ");
		} while (true);
	}
}