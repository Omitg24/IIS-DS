package ipod.ui;

import java.io.*;

import ipod.model.IPod;

// NO NECESITÁIS HACER NADA CON ESTA CLASE

/**
 * Simula las interacciones del usuario con los controles del iPod. En concreto
 * son éstos todos los posibles eventos que consideraremos: pulsar el botón +
 * (subir), pulsar el botón - (bajar), pulsar el botón siguiente, pulsar el
 * botón anterior, pulsar el botón central (reproducir), mantener pulsado el
 * botón central (reproducir_pulsado) y pulsar el botón superior VoiceOver (voz).<p>
 * 
 * A su vez, para cada uno de los posibles eventos anteriores se llama al método
 * correspondiente del iPod:<p>
 * 
 * <li>{@code up()}
 * <li>{@code down()}
 * <li>{@code next()}
 * <li>{@code previous()}
 * <li>{@code play()}
 * <li>{@code playHeld()}
 * 
 * Por otro lado, en cada iteración del bucle se llama al método {@code run} del
 * iPod (que a su vez llama al método {@code run} del reproductor ({@code Player},
 * que simula lo que sería la ejecución continua del reproductor en un caso real,
 * y muestra por pantalla que canción se está ejecutando, o nada si el iPod está
 * en pausa.
 */
public class Controller 
{
	private IPod ipod;
	private BufferedReader input;
	private PrintStream output = System.out;
	private boolean exit;
	
	public Controller(IPod ipod)
	{
		this.ipod = ipod;
		input = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Controller(IPod ipod, String filename) throws FileNotFoundException
	{
		this.ipod = ipod;
		input = new BufferedReader(new FileReader(filename));
	}
	
	public void run()
	{
		showHelp();
		while (!exit) {
			try {
				askUser();								
			} catch (IOException e) {
				System.out.println("Se produjo un error de entrada/salida)");
				return;
			}
		}
		output.println("¡Adios!");
		return;
	}	
	
	private void askUser() throws IOException
	{
		output.print("> ");
		output.flush();
		String action = input.readLine();
		if (action.equals("salir")) {
			exit = true;
			return;
		} else if (action.equals("ayuda")) {
			showHelp();
		} else if (action.equals("subir")) {
			ipod.up(); 
		} else if (action.equals("bajar")) {
			ipod.down();
		} else if (action.equals("siguiente")) {
			ipod.next();
		} else if (action.equals("anterior")) {
			ipod.previous();
		} else if (action.equals("voz")) {
			ipod.voiceOver();
		} else if (action.equals("reproducir")) {
			ipod.play();
		} else if (action.equals("reproducir_pulsado")) {
			ipod.playHeld();
		} else if (action.equals("")) {
			;	// para mostrar información de traza sin ejecutar ninguna acción
		} else {
			output.println("Acción desconocida: " + action);
			showHelp();			
		}
		// simula la ejecución continua del iPod
		ipod.run();
	}
	
	private void showHelp()
	{
		output.println("");
		output.println("Reproducción: reproducir - anterior - siguiente");
		output.println("Volumen: subir - bajar");
		output.println("Otras acciones: voz - reproducir_pulsado - ayuda - salir");
		output.println("--------------------------------------------------------");		
	}
}
