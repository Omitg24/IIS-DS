package action;

import main.Editor;

public class Delete implements Action {
	
	private Editor editor;
	
	public Delete() {
		this.editor = new Editor();
	}

	@Override
	public void execute() {
		editor.borrar();
	}

}
