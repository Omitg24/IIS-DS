package curiosity.controller.actions;

import curiosity.controller.Action;
import curiosity.rover.Rover;

public class LeftAction implements Action {

	private Rover rover;	
	
	public LeftAction(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void undo() {
		this.rover.turnRight();
	}

	@Override
	public void redo() {
		this.rover.turnLeft();
	}

}
