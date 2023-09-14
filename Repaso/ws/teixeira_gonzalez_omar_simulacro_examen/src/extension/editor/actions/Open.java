package extension.editor.actions;

import java.io.IOException;

import extension.editor.Action;
import extension.editor.Editor;

public class Open implements Action {

	private String fileName;	
	
	public Open(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void execute(Editor editor) throws IOException {
		editor.open(this.fileName);
	}

}
