package extension.editor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import extension.editor.actions.Macro;

public class Manager {

	private Editor editor;

	private Map<String, Macro> macros = new HashMap<>();

	private Macro macro;

	private boolean isRecording;

	public Manager(Editor editor) {
		this.editor = editor;
	}

	public void execute(Action action) throws IOException {
		if (this.isRecording) {
			this.macro.addAction(action);
		} else {
			action.execute(editor);
		}
	}

	public void recordNewMacro(String macroName) {
		this.macro = new Macro(macroName);
		this.isRecording = true;
		System.out.println(this.macros.keySet());
	}

	public void stopRecording() {
		this.macros.put(this.macro.getMacroName(), this.macro);
		this.isRecording = false;
	}

	public void executeMacro(String macroName) throws IOException {
		if (this.isRecording) {
			this.macro.addAction(this.macros.get(macroName));
		} else {
			Macro currentMacro = this.macros.get(macroName);
			if (currentMacro != null) {
				currentMacro.execute(this.editor);
			} else {
				System.out.println("---> La macro que ha introducido no existe");
			}
		}
	}

	public boolean isRecording() {
		return this.isRecording;
	}
}
