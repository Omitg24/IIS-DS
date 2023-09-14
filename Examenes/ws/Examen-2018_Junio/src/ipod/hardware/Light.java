package ipod.hardware;

/**
 * Controla la luz del iPod. En el caso del iPod real esta luz proporciona una
 * indicación visual, parpadeando de distintos modos y en diferentes colores, en
 * respuesta a ciertas acciones del usuario; por ejemplo:
 * 
 * <li>Una vez en verde en respuesta a la mayoría de acciones del usuario (reproducir,
 *     poner en pausa, avanzar y retroceder canción, activar VoiceOver, cambiar el 
 *     volumen, etcétera)
 * <li>Parpadea en naranja tres veces cuando se alcanza el límite superior o inferior
 *     del nivel de volumen permitidos; también cuando se bloquea o desbloquea el iPod
 * <li>Parpadea una vez en naranja cuando se pulsa cualquier botón estando el iPod
 *     bloqueado
 * <li>Etcétera 
 *     
 * En nuestra implementación, puesto que lo simulamos con una interfaz en modo texto,
 * en lugar de establecer una correspondencia exacta entre esos modos de iluminación
 * y operaciones de esta clase, emplearemos un único método {@blink} que recibe un
 * mensaje descriptivo de la acción llevada a cabo (<i>Comienza la reproducción<i>,
 * <i>Se ha pausado el iPod</i>, <i>Siguiente canción</i>, <i>Se subió el volumen</i>,
 * <i>El iPod se ha bloqueado</i>...). 
 */
public class Light 
{
	public void blink(String message)
	{
		System.out.println("La luz parpadea: " + message);
	}
}
