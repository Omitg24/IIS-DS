package curiosity.rover.data;

import curiosity.rover.Position;

public class Sample {

	private static int number = 0;
	
	public Sample(Position position) {
		this.position = position;
		number++;
		sample = "Sample" + number;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public String getFile() {
		return sample;
	}
	
	@Override
	public String toString() {
		return sample + " taken at " + position;
	}
	
	private Position position;
	private String sample;
}
