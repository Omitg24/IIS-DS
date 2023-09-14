package curiosity.controller;

import java.util.Stack;

public class Memory {
	
	private Stack<Action> actions = new Stack<>();
		
	public Memory() {
	}

	public void goBack() {
		for (Action action : actions) {
			action.undo();
		}
	}
	
	public void goAhead() {
		for (Action action : actions) {
			action.redo();
		}
	}
	
	public void addAction(Action action) {
		this.actions.add(0, action);
	}
}
