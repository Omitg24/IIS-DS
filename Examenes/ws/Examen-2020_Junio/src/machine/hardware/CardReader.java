package machine.hardware;

import java.util.Scanner;

/*
 	Representa el controlador del lector de tarjetas. Permite simular la lectura
 	de una tarjeta introducida en el lector de la máquina (o acercada a él),
 	simplemente preguntado al usuario por consola los datos que en un caso real
 	se leerían directamente de la tarjeta (y que aquí, de nuevo por simplicidad,
 	se reducen a uno solo: el número de la misma).
 	
 	Nota: COMO CONTROLADOR DE HARDWARE QUE ES, NO PUEDE SER MODIFICADA.
 	      ------------------------------------------------------------
 */
public class CardReader 
{
	private Scanner input = new Scanner(System.in);

	public String readCardNumber()
	{
		System.out.println("Leyendo datos de la tarjeta...");
		// simula la lectura de la tarjeta preguntando su información al usuario
		System.out.print("Número de tarjeta: ");
		return input.nextLine();
	}
}
