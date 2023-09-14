package ipod.model;

import java.util.List;

import ipod.hardware.Earphone;

public class Player 
{
	private Earphone earphone;
	private List<Song> playlist;
	private int current;
	private boolean isPlaying;

	public Player(Earphone earphone, List<Song> playlist)
	{
		if (earphone == null)
			throw new NullPointerException("El reproductor necesita una referencia no nula al altavoz");
		if (playlist == null)
			throw new NullPointerException("El reproductor necesita una lista de reproducción inicial no nula");
		this.earphone = earphone;
		this.playlist = playlist;
	}	
	
	//-- Reproducir y poner en pausa el reproductor
	
	public void play()
	{
		if (isPlaying)
			throw new IllegalStateException("Ya se estaba reproduciendo");
		if (playlist.isEmpty()) {
			earphone.voiceOver("Utilice iTunes para sincronizar música con este iPod");
			return;
		}			
		isPlaying = true;
	}
	
	public void pause()
	{
		if (!isPlaying)
			throw new IllegalStateException("Ya estaba en pausa");
		isPlaying = false;
	}
	
	/**
	 * Simula lo que sería la ejecución continua del reproductor, en su propio
	 * hilo, de manera concurrente con el resto del sistema. En nuestro caso
	 * es llamado  desde la interfaz de usuario (el controlador), en cada iteración
	 * del bucle, para mostrar qué canción se está ejecutando actualmente (o nada,
	 * si está en pausa).
	 */
	public void run()
	{
		if (isPlaying)
			earphone.playSong(getCurrentSong().getFilename());
	}

	//-- Operaciones para avanzar y retroceder canciones
	
	public Song getCurrentSong()
	{
		return playlist.get(current);
	}
	
	public void nextSong()
	{
		current = (current < playlist.size() - 1) ? current + 1 : 0;
	}
	
	public void previousSong()
	{
		current = (current >= 1) ? current - 1 : playlist.size() - 1;
	}
	
	
	//-- Otros métodos
	
	@Override
	public String toString()
	{
		return isPlaying ?
			String.format("Se está reproduciendo \"%s\"\n", getCurrentSong().getTitle()) :
			String.format("Reproductor en pausa (canción actual: %s)",  getCurrentSong().getTitle());			
	}
}
