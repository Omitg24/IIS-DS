package curiosity.rover;

import java.util.ArrayList;
import java.util.List;

import curiosity.rover.data.Photo;
import curiosity.rover.data.Sample;
import mars.Terrain;

	// Representa toda la operativa proporcionada por el "rover", y se encarga de
	// interactuar con sus mecanismos y dispositivos físicos (ruedas, sensores, 
	// cámaras...) para llevar a cabo las operaciones solicitadas.
	//
	// Esta clase (al igual que el resto de las del paquete 'rover') NO SE PUEDE
	// MODIFICAR.
	//

public class Rover {

	public static boolean TRACE = true;

	public Rover(Terrain terrain) {
		this.terrain = terrain;
		orientation = Direction.NORTH;
		x = y = 0;
	}
	
	public boolean moveForward() {
		int newX = x, newY = y;

		if (orientation == Direction.NORTH)
			newY++;
		else if (orientation == Direction.EAST)
			newX++;
		else if (orientation == Direction.SOUTH)
			newY--;
		else if (orientation == Direction.WEST)
			newX--;

		if (terrain.isThereObstacle(newX, newY)) {
			trace("There is an obstacle at " + newX + ":" + newY + ": can't move forward");
			return false;
		} else {
			trace("Moving forward to " + newX + ":" + newY);
			x = newX;
			y = newY;
			return true;			
		}
	}

	public boolean moveBackward() {
		int newX = x, newY = y;

		if (orientation == Direction.NORTH)
			newY--;
		else if (orientation == Direction.EAST)
			newX--;
		else if (orientation == Direction.SOUTH)
			newY++;
		else if (orientation == Direction.WEST)
			newX++;

		if (terrain.isThereObstacle(newX, newY)) {
			trace("There is an obstacle at " + newX + ":" + newY + ": can't move backward");
			return false;
		} else {
			trace("Moving backward to " + newX + ":" + newY);
			x = newX;
			y = newY;
			return true;			
		}
	}
	
	public void turnRight() {
		switch (orientation) {
		case NORTH: orientation = Direction.EAST; break;
		case EAST: orientation = Direction.SOUTH; break;
		case SOUTH: orientation = Direction.WEST; break;
		case WEST: orientation = Direction.NORTH; break;
		}

		trace("Turn right. Now I'm facing " + orientation);
	}

	public void turnLeft() {
		switch (orientation) {
		case NORTH: orientation = Direction.WEST; break;
		case EAST: orientation = Direction.NORTH; break;
		case SOUTH: orientation = Direction.EAST; break;
		case WEST: orientation = Direction.SOUTH; break;
		}

		trace("Turn left. Now I'm facing " + orientation);
	}
	
	public void takePhoto() {
		trace("Taking photo");
		photos.add(new Photo(getPosition()));
	}
	
	public void takeSample() {
		trace("Taking sample");
		samples.add(new Sample(getPosition()));		
	}
	
	public Position getPosition() {
		return new Position(x, y);
	}
	
	public void trace(String message) {
		if (TRACE)
			log.append("[" + x + ":" + y + " " + orientation + "]\t" + message + "\n");
	}
	
	public void transmit()
	{
		// posición y orientación actual del rover
		System.out.println("Rover at " + x + ":" + y + " facing " + orientation);
		System.out.println();
		
		System.out.println(log);
		
		// envía las imágenes tomadas
		System.out.println("Photos:");
		for (Photo photo : photos) {
			System.out.println("- " + photo);
		}
		System.out.println();
		
		// envía los resultados de las muestras tomadas
		System.out.println("Samples:");
		for (Sample sample : samples) {
			System.out.println("- " + sample);
		}
		System.out.println();
	}
	
	@Override
	public String toString() {
		return "Rover at " + x + ":" + y + " facing " + orientation;		
	}
	
	// la posición actual del rover en coordenadas de Marte
	private int x, y;
	// la dirección a la que está mirando el rover
	private Direction orientation;
	// simula la información obtenida por los sensores y cámaras para saber si
	// hay o no obstáculos en una determinada posición que impidan moverse a ella
	private Terrain terrain;
	
	private List<Photo> photos = new ArrayList<>();
	private List<Sample> samples = new ArrayList<>();
	
	private StringBuilder log = new StringBuilder();
}
