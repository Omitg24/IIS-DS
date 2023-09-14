package curiosity.controller.actions;

import curiosity.controller.Action;
import curiosity.rover.Rover;

public class BackwardAction implements Action {

	private Rover rover;	
	
	public BackwardAction(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void undo() {
		this.rover.moveForward();
	}

	@Override
	public void redo() {
		this.rover.moveBackward();
	}

}
