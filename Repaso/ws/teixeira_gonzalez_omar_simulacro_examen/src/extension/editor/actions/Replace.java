package extension.editor.actions;

import java.io.IOException;

import extension.editor.Action;
import extension.editor.Editor;

public class Replace implements Action {

	private String cad1, cad2;
		
	public Replace(String cad1, String cad2) {
		this.cad1 = cad1;
		this.cad2 = cad2;
	}

	@Override
	public void execute(Editor editor) throws IOException {
		editor.replace(cad1, cad2);
	}
}
