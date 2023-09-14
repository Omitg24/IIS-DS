package curiosity.controller;

import java.util.List;

import curiosity.controller.actions.BackwardAction;
import curiosity.controller.actions.ForwardAction;
import curiosity.controller.actions.LeftAction;
import curiosity.controller.actions.RightAction;
import curiosity.rover.Rover;

public class RoverController {

	private Rover rover;
	private int ip;
	private Memory memory = new Memory();
	private ObstacleStrategy strategy;

	public RoverController(Rover rover, ObstacleStrategy strategy) {
		this.rover = rover;
		this.strategy = strategy;
	}

	public boolean executeTask(List<String> task) {
		
		boolean success = true;
		
		while (ip < task.size() && success) {
			String instruction = task.get(ip);
			
			Action action = null;
			if (instruction.equals("forward")) {
				// se mueve una posición hacia delante salvo que se encuentre con un obstáculo
				success = rover.moveForward();
				action = new ForwardAction(rover);
			} else if (instruction.equals("backward")) {
				// se mueve una posición hacia atrás salvo que se encuentre con un obstáculo
				success = rover.moveBackward();
				action = new BackwardAction(rover);
			} else if (instruction.equals("left")) {
				rover.turnLeft();
				action = new LeftAction(rover);
			} else if (instruction.equals("right")) {
				rover.turnRight();
				action = new RightAction(rover);
			} else if (instruction.equals("sample")) {
				rover.takeSample();
			} else if (instruction.equals("photo")) {
				rover.takePhoto();
			} else {
				rover.trace("Unknown instruction!");				
			}		
			
			if (success) {
				ip++;
				if (action != null) {
					this.memory.addAction(action);
				}				
			} else {
				success = this.strategy.execute(this);
			}
		}
		
		if (success)
			rover.trace("Task finished");
		else
			rover.trace("Task couldn't have been completed");

		return success;
	}
	
	public void incrementIp() {		
		ip++;
	}
	
	public Memory getMemory() {
		return memory;
	}	
}
