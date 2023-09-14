package base.editor.core;

/**
 * Representa un área rectangular en un documento de dibujo, a modo de caja o
 * cuadro delimitador que contiene, o podrá contener, una o varias figuras. La
 * principal funcionalidad en esta versión es que permite crear dicha área a
 * partir de un único punto inicial y sucesivas llamadas al método {@code
 * resizeTo}, sin importar la dirección en que se ha movido el cursor. Es decir,
 * una vez seleccionado el punto inicial el usuario podrá, como en cualquier
 * editor gráfico real, mover el ratón hacia abajo y la derecha, pero también
 * hacia abajo y la izquierda, y así hasta las cuatro combinaciones posibles.
 * Esta clase sabrá al final determinar correctamente cuál es el área rectangular
 * definida.<p>
 *
 * Un uso típico en esta implementación del editor es por ejemplo en el caso de
 * las herramientas de creación de figuras que se crean pulsando en un punto,
 * arrastrando y soltando (en nuestra implementación actual, el rectángulo y el
 * círculo).<p>
 *
 * Pero podría usarse también si quisiéramos permitir, por ejemplo, que la
 * herramienta de selección, además de seleccionar figuras haciendo clic sobre
 * ellas, pudiese funcionar también dibujando un área rectangular y que se
 * seleccionen todas las figuras que queden confinadas en dicha área, y otros
 * casos similares.
 */
public class BoundingBox
{
	// Las coordenadas del punto inicial en el que se hizo clic (éste no debe
	// cambiar: podrá pasar a ser una esquina u otra en función de hacia dónde
	// se mueva el cursor, pero este punto permanecerá siempre fijo por muchas
	// llamadas sucesivas que se hagan a resizeTo)
	private int initialX, initialY;

	// Las coordenadas de la esquina superior izquierda
	private int x1, y1;

	// Las coordenadas de la esquina inferior derecha
	private int x2, y2;

	/**
	 * Crea un área rectangular (caja o cuadro delimitador) con origen en las coordenadas
	 * especificadas y de ancho y alto cero. Es decir, de momento únicamente es un punto.
	 * Se proporciona en caso de que, pensando sobre todo en futuras versiones del editor
	 * en modo gráfico, queramos crear ya inicialmente esta caja rectangular y luego ir
	 * modificando su tamaño y dibujándola continuamente (por ejemplo, mediante una linea
	 * discontinua, como suelen hacer todos los editores gráficos), a medida que se va
	 * moviendo el ratón por la pantalla. En ese caso, soltar el botón del ratón únicamente
	 * implica establecer sus dimensiones a partir de ese punto final, al igual que en cada
	 * uno de los movimientos previos.
	 *
	 * @param x la coordenada horizontal del primer punto en el que se hizo clic
	 * @param y la coordenada vertical del primer punto en el que se hizo clic
	 */
	public BoundingBox(int x, int y)
	{
		initialX = x1 = x2 = x;
		initialY = y1 = y2 = y;
	}

	/**
	 * Crea un área rectangular (caja o cuadro delimitador) a partir de las coordenadas de
	 * los dos puntos especificados. Nótese que no es necesario que dichos puntos vayan en
	 * ningún orden en concreto sino que, como si se tratase de una aplicación real, se
	 * espera que el usuario pueda haber movido el ratón en cualquier dirección a partir del
	 * punto inicial: hacia la derecha y hacia abajo, que seguramente será la opción más común,
	 * pero también hacia la izquierda y hacia abajo, hacia la izquierda y hacia arriba o, por
	 * último, hacia  arriba y la derecha. Hay cuatro posibilidades distintas. En todos los
	 * casos el objeto creado calcula correctamente cuál será el punto de la esquina superior
	 * izquierda así como el ancho y el alto que definen este área rectangular.
	 *
	 * @param x1 la coordenada horizontal del primer punto en el que se hizo clic
	 * @param y1 la coordenada vertical del primer punto en el que se hizo clic
	 * @param x2 la coordenada horizontal del punto en el que se soltó el botón del ratón
	 * @param y2 la coordenada vertical del punto en el que se soltó el botón del ratón
	 */
	public BoundingBox(int x1, int y1, int x2, int y2)
	{
		setDimension(x1, y1, x2, y2);
	}

	public void resizeTo(int x, int y)
	{
		setDimension(initialX, initialY, x, y);
	}

	private void setDimension(int x1, int y1, int x2, int y2)
	{
		this.x1 = (x1 <= x2) ? x1 : x2;
		this.x2 = (x2 >= x1) ? x2 : x1;
		this.y1 = (y1 <= y2) ? y1 : y2;
		this.y2 = (y2 >= y1) ? y2 : y1;
	}

	public int getX()
	{
		return x1;
	}

	public int getY()
	{
		return y1;
	}

	public int getWidth()
	{
		return x2 - x1;
	}

	public int getHeight()
	{
		return y2 - y1;
	}

	@Override
	public String toString()
	{
		return String.format("(%d, %d), (%d, %d)", x1, y1, x2, y2);
	}
}
