package curiosity.controller.actions;

import curiosity.controller.Action;
import curiosity.rover.Rover;

public class RightAction implements Action {

	private Rover rover;	
	
	public RightAction(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void undo() {
		this.rover.turnLeft();
	}

	@Override
	public void redo() {
		this.rover.turnRight();
	}

}
