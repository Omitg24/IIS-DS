package curiosity.controller.actions;

import curiosity.controller.Action;
import curiosity.rover.Rover;

public class ForwardAction implements Action {

	private Rover rover;	
	
	public ForwardAction(Rover rover) {
		this.rover = rover;
	}

	@Override
	public void undo() {
		this.rover.moveBackward();
	}

	@Override
	public void redo() {
		this.rover.moveForward();
	}
}
