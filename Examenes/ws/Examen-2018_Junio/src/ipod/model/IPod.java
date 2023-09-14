package ipod.model;

import java.util.List;

import ipod.hardware.*;

public class IPod 
{	
	private static enum Mode { PLAYING, PAUSED }
	
	private Earphone earphone = new Earphone();
	private Light light = new Light();
	private Player player;
	
	private Mode mode = Mode.PAUSED;
	private boolean voiceOver, isBlocked;
		
	public IPod(List<Song> allSongs)
	{
		player = new Player(earphone, allSongs);		
	}
	
	/**
	 * Simula lo que sería la ejecución continua, concurrente, del reproductor.
	 * Muestra qué canción se está ejecutando, o nada, si está en pausa.
	 */
	public void run()
	{
		player.run();
	}
	
				
	//-- Eventos de los botones del iPod
	
	// Se pulsó el botón de reproducción/pausa
	public void play()
	{
		if (isBlocked) {
			light.blink("El iPod está bloqueado");
			return;
		}
		if (isPaused()) {
			// si está en pausa, se pone en reproducción
			light.blink("Comienza la reproducción");
			player.play();
			mode = Mode.PLAYING;
		} else {
			// si está en reproducción, se pone en pausa
			assert isPlaying() : "Si no está en pausa es que está en reproducción";
			light.blink("El iPod está en pausa");
			player.pause();
			mode = Mode.PAUSED;
		}
	}
	
	// Se pulsó el botón siguiente
	public void next()
	{
		if (isBlocked) {
			light.blink("El iPod está bloqueado");
			return;
		}
		player.nextSong();
		light.blink("Siguiente canción (" + player.getCurrentSong().getTitle() + ")");		
		if (voiceOver)
			speak();
	}
	
	// Se pulsó el botón anterior
	public void previous()
	{
		if (isBlocked) {
			light.blink("El iPod está bloqueado");
			return;
		}
		player.previousSong();
		light.blink("Canción anterior (" + player.getCurrentSong().getTitle() + ")");				
		if (voiceOver)
			speak();
	}

	// Se pulsó el botón de subir volumen
	public void up()
	{
		if (isBlocked) {
			light.blink("El iPod está bloqueado");
			return;
		}
		if (earphone.getVolume() < Earphone.MAX_VOLUME) {
			earphone.volumeUp();
			light.blink("Se subió el volumen");
			// si estaba en pausa y se cambió el volumen (sólo si se cambió como resultado
			// de esta acción, no si ya estaba al máximo) se emite además un tono para que 
			// el usuario reciba una indicación audible de cuál es el volumen actual
			if (isPaused())
				earphone.makeTone();
		} else {
			light.blink("El volumen del iPod ya está al máximo");			
		}
	}
	
	// Se pulsó el botón de bajar volumen
	public void down()
	{
		if (isBlocked) {
			light.blink("El iPod está bloqueado");
			return;
		}
		if (earphone.getVolume() > Earphone.MIN_VOLUME) {
			earphone.volumeDown();
			light.blink("Se bajó el volumen");
			// si estaba en pausa y se cambió el volumen (sólo si se cambió como resultado
			// de esta acción, no si ya estaba al mínimo) se emite además un tono para que 
			// el usuario reciba una indicación audible de cuál es el volumen actual
			if (isPaused())
				earphone.makeTone();
		} else {
			light.blink("El volumen del iPod ya está al mínimo");			
		}
	}
	
	// Se pulsó el botón de VoiceOver
	public void voiceOver()
	{
		if (isBlocked) {
			light.blink("El iPod está bloqueado");
			return;
		}
		voiceOver = voiceOver ? false : true;
		if (voiceOver) {
			light.blink("Se activó el modo VoiceOver");
			speak();
		} else
			light.blink("Se desactivó el modo VoiceOver");
	}
	
	// Se mantuvo pulsado el botón de reproducción/pausa
	public void playHeld()
	{
		isBlocked = isBlocked ? false : true;
		if (isBlocked)
			light.blink("El iPod se ha bloqueado");
		else
			light.blink("El iPod se ha desbloqueado");
	}
	
	
	//-- Métodos auxiliares
	
	private boolean isPlaying()
	{
		return mode == Mode.PLAYING;
	}
	
	private boolean isPaused()
	{
		return mode == Mode.PAUSED;
	}
	
	/**
	 * Dice en voz alta, a través de la toma de auriculares del iPod, el título
	 * de la canción actual y el nombre del artista.
	 */
	private void speak()
	{
		Song currentSong = player.getCurrentSong();
		String songInformation = String.format("%s (%s)", 
				currentSong.getTitle(), currentSong.getArtist());
		earphone.voiceOver(songInformation);
	}	
}
