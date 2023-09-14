package machine.hardware;

import java.util.Scanner;

/*
 	Representa el controlador de la ranura para la introducción de billetes de
 	la máquina. Se simula la introducción de billetes preguntando directamente
 	al usuario el valor introducido. Lleva el control del total introducido
 	hasta el momento y también permite devolver el cambio al usuario (si se 
 	canceló la operación o se introdujo más dinero del importe exacto).

 	Nota: COMO CONTROLADOR DE HARDWARE QUE ES, NO PUEDE SER MODIFICADA.
 	      ------------------------------------------------------------
*/
public class BillAcceptor 
{
	private Scanner scanner = new Scanner(System.in);
	
	private int totalAmount;
	
	public void reset()
	{
		totalAmount = 0;
	}
	
	public int getTotalAmount()
	{
		return totalAmount;
	}
	
	public int insertBill()
	{
		do {
			try {
				System.out.print("Introduzca billete (0 para cancelar): ");
				int inserted = Integer.valueOf(scanner.nextLine());
				totalAmount += inserted;
				return inserted;
			} catch (NumberFormatException e) {
				System.out.println("Se esperaba un valor entero");
			}
		} while (true);
	}

	public void returnChange(double change)
	{
		System.out.printf("Devolviendo %.2f euros...%n", change);
	}
	
	@Override
	public String toString()
	{
		return String.format("Ranura para billetes (importe introducido = %d euros)", totalAmount);
	}
}
