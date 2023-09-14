package extension.editor.actions;

import java.io.IOException;

import extension.editor.Action;
import extension.editor.Editor;

public class Delete implements Action {

	@Override
	public void execute(Editor editor) throws IOException {
		editor.delete();
	}

}
