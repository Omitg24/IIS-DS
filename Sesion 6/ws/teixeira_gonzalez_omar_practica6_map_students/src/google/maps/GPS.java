package google.maps;

/**
 * Titulo: Clase GPS
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class GPS 
{
	/**
	 * Método getDirectionsTo  
	 * Simula la navegación de Google Maps: dada una dirección nos va dando las
	 * indicaciones para llegar a ella
	 * 
	 * @param address
	 */
	public void getDirectionsTo(String address) 
	{
		System.out.println("GPS: Gire a la derecha [...] Ha llegado a su destino: " + address);
	}

	/**
	 * Método getCoordinates
	 * Dada una dirección devuelve sus coordenadas en el mapa
	 * 
	 * @param address
	 * @return Coordinates
	 */
	public Coordinates getCoordinates(String address) 
	{
		// Cálculo de relleno: simplmente devuelve la posición en función de la primera letra
		double number = (address.toLowerCase().charAt(0) - 'a') * 10 + 10;
		return new Coordinates(number, number);
	}

	/**
	 * Método getAddress
	 * Dada unas coordenadas devuelve la dirección correspondiente
	 *  
	 * @param coordinates
	 * @return String
	 */
	public String getAddress(Coordinates coordinates) 
	{
		return coordinates.toString();
	}
}
