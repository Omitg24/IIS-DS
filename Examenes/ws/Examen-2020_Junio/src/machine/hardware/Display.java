package machine.hardware;

/*
 	Representa la pantalla de la máquina expendedora. Por tanto, CUALQUIER
 	INFORMACIÓN QUE EN UN CASO REAL SE MOSTRARÍA EN DICHA PANTALLA DEBERÁ
 	HACERSE NECESARIAMENTE A TRAVÉS DE ESTA CLASE (no se está haciendo así
 	en el caso de mensajes que representan simulaciones de dispositivos físicos
 	u otros procesos y que se imprimen directamente en la salida estándar, ya
 	que son eso, simulaciones: no forman parte de la interfaz de usuario).
 */
public class Display 
{
	// Nótese que no se imprime una nueva línea; si se quiere ese comportamiento
	// hay que pasarle el carácter de nueva línea ("\n") al final de la cadena a
	// mostrar.
	public void show(String message)
	{
		System.out.print(message);
	}
}
