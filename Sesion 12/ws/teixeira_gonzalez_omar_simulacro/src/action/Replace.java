package action;

import main.Editor;

public class Replace implements Action {

	private String[] line;
	private Editor editor;
	
	public Replace(String[] line) {
		this.line = line;
		this.editor = new Editor();
	}
	
	@Override
	public void execute() {
		editor.reemplazar(line);
	}

}
