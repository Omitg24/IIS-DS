package action;

import java.util.List;

import main.Editor;

public class Execute implements Action {

	private String key;
	private Editor editor;
	
	public Execute(String key) {
		this.key = key;
		this.editor = new Editor();
	}
	
	@Override
	public void execute() {
		List<Action> actions = editor.getActions(key);
		for (Action action : actions) {
			action.execute();
		}
	}

}
