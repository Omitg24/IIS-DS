package slides.ui;

import java.io.*;

// ESTA CLASE ES PARTE DE LA BIBLIOTECA GRÁFICA, NO DEBERÍAIS MODFICARLA

/*
    Simula un área de la pantalla en la que la aplicación puede «dibujar» (en
    nuestro caso, escribir un mensaje de texto) o recibir eventos asociados a
    la entrada del usuario (de nuevo, simulado en modo texto leyendo de la
    entrada estándar u cualquier otro flujo de caracteres que se haya indicado
    al crearlo).

    Es, en definitiva, el objeto que utilizarán el resto de clases de la
    aplicación (con excepción de la entrada de usuario en sí, representada por
    el menú) para escribir texto en la pantalla y leer la entrada del usuario.
 */
public class Canvas 
{
    private BufferedReader in;
    private PrintWriter out;
    private boolean interactive = false;

    public Canvas()
    {
        this(new BufferedReader(new InputStreamReader(System.in)), 
        		new OutputStreamWriter(System.out));
        interactive = true;
    }

    public Canvas(BufferedReader input, Writer output)
    {
        this.in = input;
        this.out = new PrintWriter(output, true);
    }

    public String askUser()
    {
        try {
            String userInput = in.readLine();
            // si no se está leyendo de la entrada estándar (normalmente en ese
            // caso será de un fichero) se escribe en el flujo de salida para que
            // aparezca ahí la interacción con el usuario completa (y no sólo la
            // salida sin saber a qué acciones del usuario responde dicha salida)
            if (!interactive)
                out.println(userInput);
            return userInput;
        } catch (IOException e) {
            throw new RuntimeException("¡Ocurrió un error al leer la entrada del usuario!");
        }
    }

    /*
        Como 'drawLine' pero sin imprimir el carácter de nueva línea. Resulta
        útil para cuando por ejemplo queremos preguntar al usuario que introduzca 
        un valor justo a continuación de una cadena de texto, sin que escriba su
        respuesta en otra lína. En general, en cualquier caso en que queramos
        concatenar mensajes en la salida sin que cada uno de ellos vaya en una
        línea aparte. Sería el equivalente del 'print', mientras que 'drawLine'
        es el equivalente de 'println'.
     */
    public void drawText(String message)
    {
        out.print(message);
        out.flush();
    }

    /*
        Imita lo que sería el dibujado por pantalla, en nuestro caso escribiendo
        en la salida que se haya especificado en el constructor una nueva línea
        de texto.
     */
    public void drawLine(String message)
    {
        out.println(message);
    }
}