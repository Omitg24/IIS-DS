package extension.editor;

import java.util.Stack;

import extension.editor.interfaces.Action;

public class Memory {

	private Stack<Action> undoActions = new Stack<>();

	private Stack<Action> redoActions = new Stack<>();

	public void undo() {
		if (this.undoActions.isEmpty()) {
			System.out.println("--> No hay acciones que deshacer");
			return;
		}
		Action action = undoActions.pop();
		this.redoActions.push(action);
		action.undo();
	}

	public void redo() {
		if (this.redoActions.isEmpty()) {
			System.out.println("--> No hay acciones que rehacer");
			return;
		}
		Action action = redoActions.pop();
		this.undoActions.push(action);
		action.redo();
	}

	public void add(Action action) {
		this.undoActions.push(action);
	}
}
