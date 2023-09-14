package extension.editor.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import extension.editor.Action;
import extension.editor.Editor;

public class Macro implements Action{
	
	private String macroName;
	
	private List<Action> actions = new ArrayList<Action>();

	public Macro(String macroName) {
		this.macroName = macroName;
	}
	
	@Override
	public void execute(Editor editor) throws IOException {
		for(Action action : actions) {
			action.execute(editor);
		}
	}	
	
	public String getMacroName() {
		return this.macroName;
	}

	public void addAction(Action action) {
		this.actions.add(action);		
	}
}
