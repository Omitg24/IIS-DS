package photos.ui;

import java.io.*;

import photos.model.*;

public class Menu 
{
	private Editor editor;
	private BufferedReader input;
	private PrintWriter output;
	private boolean exit;
	private boolean interactive;
	
	/**
	 * Crea una versión interactiva de la interfaz en modo texto del editor (una que
	 * usa la entrada y salida estándar para mostrar el menú al usuario, pedirle que 
	 * seleccione una opción y mostrar los resultados de la ejecución).
	 */
	public Menu(Editor editor)
	{
		this(editor, new InputStreamReader(System.in), new PrintWriter(System.out, true));
		interactive = true;
	}
	
	/**
	 * En vez de ejecutar el menú en modo interactivo esta versión lee las
	 * acciones a ejecutar del fichero de entrada especificado y muestra los
	 * resultados de la ejecución en el fichero de salida que recibe como
	 * segundo parámetro.
	 */
	public Menu(Editor editor, String inputFileName, String outputFileName) 
			throws FileNotFoundException, IOException
	{
		this(editor, new FileReader(inputFileName), new FileWriter(outputFileName));
	}
	
	public Menu(Editor editor, Reader input, Writer output)
	{
		if (editor == null)
			throw new NullPointerException("Se necesita una referencia no nula al editor");
		this.input = new BufferedReader(input);
		this.output = new PrintWriter(output, true);
		this.editor = editor;
	}	
		
	
	//-- Operaciones auxiliares
	
	/**
	 * Muestra la foto actualmente abierta en el editor en la pantalla. Es llamado
	 * por las distintas opciones del menú cada vez que se realizan acciones que
	 * implican cambios en la foto abierta, para que se vean las modificaciones (o,
	 * como es lógico, también cada vez que se abre una nueva foto).
	 */
	private void showCurrentPhoto()
	{
		output.println(editor.getCurrentPhoto().outputImage());
	}

	public void run()
	{
		showHelp();
		while (!exit) {
			try {
				menu(askUser());
			} catch (Exception e) {
				output.println(e.getMessage());
			}
		}
		output.println("¡Adios!");
	}		
	
	//-- Menú principal
		
	// En el parámetro userInput este método recibe un array de cadenas de uno o
	// dos elementos dependiendo de si la opción introducida previamente por el
	// usuario en el método askUser tenía o no parámetros:
	//
	// 		userInput[0] => nombre de la opción escogida
	// 		userInput[1] (opcional) => parámetros, si los hubiera
	//
	// Por ejemplo, para las siguientes entradas de usuario, este método recibiría:
	//
	//		"abrir 1" 			=> 	["abrir", "1"]
	//		"copiar_ajustes" 	=> 	["copiar_ajustes"]
	//		
	private void menu(String[] userInput) throws UserInputException
	{		
		String option = userInput[0];
		if (option.equals("salir")) {
			exit = true;
		} else if (option.equals("ayuda")) {
			showHelp();
		} else if (option.equals("todas")) {
			showAll();
		} else if (option.equals("abrir")) {
			checkHasArguments(userInput, "Se debe indicar el número de la foto a abrir");
			open(userInput[1]);
		} else if (option.equals("copiar_ajustes")) {
			editor.copyPhoto(editor.getCurrentPhoto().getSettings());				
		} else if (option.equals("pegar_ajustes")) {
			// ...
			editor.pasteSettings();	
			showCurrentPhoto();
		} else if (option.equals("activar")) {
			checkHasArguments(userInput, "Se necesita el nombre del ajuste a añadir a la foto");
			String adjustmentName = userInput[1];
			editor.getCurrentPhoto().enableAdjustment(adjustmentName);
			showCurrentPhoto();
		} else if (option.equals("desactivar")) {
			checkHasArguments(userInput, "Se necesita el nombre del ajuste a eliminar de la foto");
			String adjustmentName = userInput[1];
			editor.getCurrentPhoto().disableAdjustment(adjustmentName);
			showCurrentPhoto();
		} else if (option.equals("restablecer")) {
			editor.getCurrentPhoto().disableAdjustment("brillo");
			editor.getCurrentPhoto().disableAdjustment("contraste");
			showCurrentPhoto();
		} else {
			// si no es ninguna otra acción del menú tiene que ser el nombre de un ajuste
			if (!isAdjustment(option))
				throw new UserInputException("Acción o nombre de ajuste desconocido: " + option);
			checkHasArguments(userInput, "Se necesita el valor a aplicar al ajuste");
			setAdjustment(option, userInput[1]);
		}		
	}
	
	/**
	 * Comprueba que la opción introducida por el usuario contenga parámetros y,
	 * de no ser así, lanza una excepción.
	 */
	private void checkHasArguments(String userInput[], String message) throws UserInputException
	{
		if (userInput.length < 2)
			throw new UserInputException(message);
	}

	
		
	//-- Métodos que tratan con las opciones de ajustes
	//-------------------------------------------------
		
	/**
	 * Comprueba si se trata de uno de los ajustes existentes.
	 */
	private boolean isAdjustment(String name)
	{
		return name.equals("brillo") || name.equals("contraste");
	}

	/**
	 * Se llama cuando se aplica un valor a un ajuste sobre la foto abierta en ese
	 * momento en el editor mediante la acción del menú {@code <nombre del ajuste> <valor>}
	 * (como por ejemplo, {@code "Brillo 18"}). Comprueba que recibe un parámetro de tipo
	 * entero, aplica dicho valor al ajuste correspondiente y muestra la imagen actualizada
	 * de la foto abierta tras aplicar el ajuste. 
	 */
	private void setAdjustment(String name, String args) throws UserInputException
	{
		try {
			int value = Integer.valueOf(args);
			editor.getCurrentPhoto().setAdjustment(name, value);
			showCurrentPhoto();
		} catch (NumberFormatException e) {
			throw new UserInputException("Se esperaba un valor numérico para el ajuste: " + args);
		}		
	}
	
	
	
	
	
	//---------------------------------------------------------------------------------------------
	
	// LOS MÉTODOS RESTANTES (PARA LAS OPCIONES DE "ayuda", "todas" y "abrir") YA
	// ESTÁN IMPLEMENTADOS Y FUNCIONAN CORRECTAMENTE. NO TENÉIS QUE HACER NADA CON
	// ELLOS (son métodos auxiliares que están siendo llamados desde las opciones 
	// correspondientes en el if anidado del menú). Lo mismo con el método askUser
	// de bajo nivel para leer y analizar la entrada de usuario que aparece más
	// abajo).
		
	private void showHelp()
	{
		output.println("General: todas - abrir <nº de foto>");
		output.println("Ajustes: <ajuste> <valor> - activar <ajuste> - desactivar <ajuste> - restablecer");
		output.println("         copiar_ajustes - pegar_ajustes");
		output.println("Otras acciones: salir - ayuda");
		output.println("--------------------------------------------------------------------------------");
	}
	
	/*
	 * Simula la operación de mostrar las miniaturas de todas las fotos de la
	 * biblioteca. Lo hace escribiendo en la salida una línea por cada foto con
	 * el siguiente formato: "nº de foto - nombre del fichero de imagen". 
	 */
	private void showAll()
	{
		int index = 1;
		for (Photo each : editor.getAllPhotos()) {
			output.printf("%2d - %s\n", index, each);
			index = index + 1;
		}
	}
	
	/*
	 * Abre la foto especificada en el editor. Como resultado de esta acción la
	 * foto pasa a ser la foto actual del editor y además se aplican los ajustes
	 * correspondientes, si los tuviera, y se muestra la imagen resultante generada
	 * en la interfaz de una usuario. Al abrir una foto también se limpia la selección
	 * actual, si la hubiera.
	 */
	private void open(String args) throws UserInputException
	{
		try {
			int index = Integer.valueOf(args);
			editor.open(index);
			showCurrentPhoto();
		} catch (NumberFormatException e) {
			throw new UserInputException("Se esperaba un número de foto: " + args);
		}
	}
	
	
	/**
	 * Lee una línea (ya sea por pantalla o del fichero de entrada especificado en el
	 * constructor, en su caso) que contiene la entrada de usuario y devuelve un array
	 * de cadenas de texto de al menos un elemento y como máximo dos, donde el primer
	 * elemento es el nombre de la opción elegida y el segundo, de haberlo, contiene
	 * sus parámetros. Por ejemplo:
	 * 
	 *		"abrir 1" => ["abrir", "1"]
	 *		"copiar_ajustes" => ["copiar_ajustes"]
	 *		"" => [""]
	 *		"  esto     es   una prueba" => ["esto", "    es   una prueba"]
	 * 
	 * @return un array de cadenas de texto de como mucho dos elementos, consistente
	 *         en el nombre de la opción introducida por el usuario y, opcionalmente,
	 *         el resto de parámetros que se introdujeron para esa opción, como una
	 *         única cadena de texto
	 */
	private String[] askUser()
	{
		output.print("> ");
		output.flush();
		try {
			String userInput = input.readLine();			
			// si no está en modo interactivo, sino leyendo la entrada de usuario de un
			// fichero y escribiendo la salida en otro, escribe la supuesta entrada de
			// usuario (lo que se acaba de leer del fichero de entrada) en la salida
			if (!interactive) {
				output.println(userInput);
			}
			return userInput.trim().toLowerCase().split("[ ]", 2);			
		} catch (IOException e) {
			System.out.println("No se pudo leer la entrada del usuario: el programa debe finalizar");
			System.exit(1);
			throw new AssertionError("No debería estar aquí, el programa ya ha finalizado");
		}
	}	
}
