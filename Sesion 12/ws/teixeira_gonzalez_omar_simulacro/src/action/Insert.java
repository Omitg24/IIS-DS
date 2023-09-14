package action;

import main.Editor;

public class Insert implements Action {

	private String[] line;
	private Editor editor;
	
	public Insert(String[] line) {
		this.line = line;
		this.editor = new Editor();
	}
	
	@Override
	public void execute() {
		editor.insertar(line);
	}

}
