package base;
import java.io.*;
import java.util.regex.*;

public class Main 
{
	private static BufferedReader in;
	private static StringBuilder texto;

	public static void main(String[] args) throws IOException 
	{
		in = new BufferedReader(new InputStreamReader(System.in));
		texto = new StringBuilder("");

		System.out.println("Acciones");
		System.out.println("--------");
		System.out.println("abre <fichero>");
		System.out.println("inserta <texto>\t\t// inserta las palabras al final del texto");
		System.out.println("borra\t\t\t// borra la última palabra");
		System.out.println("reemplaza <a> <b>\t// reemplaza la cadena <a> por la <b> en todo el texto");
		System.out.println("salir");
		System.out.println();
		System.out.println("Tareas");
		System.out.println("------");
		System.out.println("graba <macro>\t\t// comienza la grabación de una macro");
		System.out.println("para\t\t\t// finaliza la grabación");
		System.out.println("ejecuta <macro>\t\t// ejecuta la macro cuyo nombre se indique");
		System.out.println();

		do {
			System.out.print("> ");

			String[] line = in.readLine().split(" ");
			
			// No se comprueba que el número de palabras sea el adecuado

			if (line[0].equals("salir"))
				return;

			if (line[0].equals("abre")) {
				texto = readFile(line[1]);
			} else if (line[0].startsWith("ins")) {
				for (int i = 1; i < line.length; i++) {
					texto.append(line[i] + " ");
				}
			} else if (line[0].startsWith("borr")) {
				int indexOfLastWord = texto.toString().trim().lastIndexOf(" ");
				if (indexOfLastWord == -1)
					texto = new StringBuilder("");
				else
					texto.setLength(indexOfLastWord + 1);
			} else if (line[0].startsWith("reem")) {
				texto = new StringBuilder(texto.toString().replaceAll(Pattern.quote(line[1]), line[2]));
			} else if (line[0].startsWith("graba")) {
				;
			} else if (line[0].startsWith("para")) {
				;
			} else if (line[0].startsWith("ejecuta")) {
				;
			} else {
				System.out.println("Instrucción desconocida");
			}

			System.out.println(texto);
			
		} while (true);
	}

	static StringBuilder readFile(String filename) throws IOException 
	{
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}
}
