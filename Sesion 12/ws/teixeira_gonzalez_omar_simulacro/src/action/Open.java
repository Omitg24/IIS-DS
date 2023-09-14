package action;

import java.io.IOException;

import main.Editor;

public class Open implements Action {
	
	private String file;
	private Editor editor;
	
	public Open(String string) {
		this.file = string;
		this.editor = new Editor();
	}

	@Override
	public void execute() {
		try {
			editor.abrir(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
