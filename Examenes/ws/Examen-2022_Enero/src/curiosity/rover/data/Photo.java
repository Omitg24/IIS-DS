package curiosity.rover.data;

import curiosity.rover.Position;

public class Photo {

	private static int number = 0;
	
	public Photo(Position position) {
		this.position = position;
		number++;
		image = "Image" + number;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public String getImage() {
		return image;
	}
	
	@Override
	public String toString() {
		return image + " taken at " + position;
	}
	
	private Position position;
	private String image;
}
