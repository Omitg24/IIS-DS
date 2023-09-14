package google.maps;

import java.awt.Rectangle;
import java.util.*;

public class Map 
{
	private List<MapElement> elements = new ArrayList<MapElement>();

	public void add(MapElement element) 
	{
		elements.add(element);
	}

	public void draw() 
	{
		// Aquí, en un caso real, se dibujaría el mapa
		// ...
		
		// Y a continuación se dibujan los marcadores
		for (MapElement element : elements)
			System.out.println(element.getTitle() + " at " + element.getCoordinates());
	}

	public void userTouch(int x, int y) 
	{
		MapElement element = getElementAt(x, y);
		if (element != null)
			System.out.println("Se abre una ventana flotante: " + element.getHTMLInfo());
	}

	public void userLongTouch(int x, int y) 
	{
		MapElement element = getElementAt(x, y);
		if (element != null)
			element.open();
	}

	private MapElement getElementAt(int x, int y) 
	{
		for (MapElement element : elements) {
			Coordinates coordinates = element.getCoordinates();
			Rectangle elementArea = new Rectangle((int) coordinates.getLongitude() - 5, (int) coordinates.getLatitude() - 5, 10, 10);
			if (elementArea.contains(x, y))
				return element;
		}
		return null;
	}
}
