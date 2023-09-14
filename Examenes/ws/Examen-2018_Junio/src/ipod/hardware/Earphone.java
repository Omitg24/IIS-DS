package ipod.hardware;

/**
 * Representa una abstracción del sistema de audio del iPod (la toma de auriculares). 
 * Se encarga de interactuar con el hardware y permite reproducir un sonido (ya sea
 * un fichero de audio con una canción, los mensajes de voz del iPod o un tono en
 * respuesta a algunas acciones del usuario, además de controlar el volumen del iPod.
 */
public class Earphone 
{
	private static final int DEFAULT_VOLUME = 3;
	public static final int MIN_VOLUME = 0;
	public static final int MAX_VOLUME = 10;
	
	private int volume;
	
	//-- Constructores
	
	public Earphone()
	{
		this(DEFAULT_VOLUME);
	}
	
	public Earphone(int initialVolume)
	{
		if (initialVolume < MIN_VOLUME || initialVolume > MAX_VOLUME)
			throw new IllegalArgumentException(String.format(
					"El valor del volumen inicial está fuera de los límites (%d-%d): %d\n",
					MIN_VOLUME, MAX_VOLUME, initialVolume));
		volume = initialVolume;
	}
	
	
	//-- Métodos que reproducen sonidos, ya sea una canción, un mensaje de voz o un tono
	
	public void playSong(String audioFile)
	{
		System.out.printf("Reproduciendo \"%s\" con un volumen de %d...\n", audioFile, volume);
	}
	
	public void voiceOver(String message)
	{
		System.out.println("Voz: " + message + " (volumen: " + volume + ")");
	}
	
	public void makeTone()
	{
		System.out.println("Se emitió un tono con un volumen de " + volume);
	}
	
	
	//-- Operaciones que controlan el volumen
	
	public void volumeUp()
	{
		if (volume < MAX_VOLUME)
			volume++;
	}
	
	public void volumeDown()
	{
		if (volume > MIN_VOLUME)
			volume--;
	}
	
	public int getVolume()
	{
		return volume;
	}
	
	//-- Otros métodos
	
	@Override
	public String toString()
	{
		return "Volumen: " + volume;
	}
}
