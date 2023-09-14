package google.maps;

public class GPS 
{
	// Simula la navegación de Google Maps: dada una dirección nos va dando las
	// indicaciones para llegar a ella
	public void getDirectionsTo(String address) 
	{
		System.out.println("GPS: Gire a la derecha [...] Ha llegado a su destino: " + address);
	}

	// Dada una dirección devuelve sus coordenadas en el mapa
	public Coordinates getCoordinates(String address) 
	{
		// Cálculo de relleno: simplmente devuelve la posición en función de la primera letra
		double number = (address.toLowerCase().charAt(0) - 'a') * 10 + 10;
		return new Coordinates(number, number);
	}

	// Dada unas coordenadas devuelve la dirección correspondiente
	public String getAddress(Coordinates coordinates) 
	{
		return coordinates.toString();
	}
}
