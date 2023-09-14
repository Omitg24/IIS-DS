package main;

import java.util.ArrayList;
import java.util.List;

import curiosity.controller.RoverController;
import curiosity.controller.strategies.*;
import curiosity.rover.Rover;
import mars.Terrain;

public class Main {
	
	public static void main(String[] args) {
		Rover rover = new Rover(new Terrain());
//		RoverController controller = new RoverController(rover, new ReturnToOrigin());
		RoverController controller = new RoverController(rover, new JumpNext());
//		RoverController controller = new RoverController(rover, new StayIn());
		
		List<String> task = new ArrayList<>();
		
		task.add("forward");	// 0:1
		task.add("sample");
		task.add("backward");	// 0:0
		task.add("left");
		task.add("backward");	// 1:0
		task.add("right");
		task.add("forward");	// obstáculo en 1:1
		task.add("forward");	// obstáculo en 1:1
		task.add("right");
		task.add("forward");
		task.add("left");
		task.add("forward");
		task.add("forward");
		task.add("forward");
		task.add("photo");
		task.add("sample");
		task.add("left");
		task.add("backward");
		task.add("photo");

		controller.executeTask(task);
		
		rover.transmit();
	}
}
