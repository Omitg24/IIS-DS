package extension.editor.actions;

import java.io.IOException;

import extension.editor.Action;
import extension.editor.Editor;

public class Insert implements Action {
	private String[] line;
		
	public Insert(String[] line) {
		this.line = line;
	}
	
	@Override
	public void execute(Editor editor) throws IOException {
		editor.insert(line);
	}

}
