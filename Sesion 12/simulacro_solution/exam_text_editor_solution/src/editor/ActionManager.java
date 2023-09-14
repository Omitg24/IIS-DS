package editor;

import java.util.HashMap;
import java.util.Map;

import editor.actions.Action;
import editor.actions.Macro;

public class ActionManager 
{
	private Editor editor;
	private boolean recordingMacro;
	private Macro macro;
	private Map<String, Macro> macros = new HashMap<>();
	
	public ActionManager(Editor editor)
	{
		if (editor == null)
			throw new IllegalArgumentException("Se necesita una referencia al editor");
		this.editor = editor;
	}
	
	public void execute(Action action)
	{
		action.execute(editor);
		if (recordingMacro)
			macro.addAction(action);
	}
	
	public void record(String name)
	{
		macro = new Macro(name);
		recordingMacro = true;
	}
	
	public void stop()
	{
		if (!recordingMacro)
			return;
		recordingMacro = false;
		macros.put(macro.getName(), macro);
	}
	
	public void executeMacro(String name)
	{
		Macro macro = macros.get(name);
		if (macro == null) {
			System.out.println("No existe ninguna macro con ese nombre: " + name);
			return;
		}
		execute(macro);
	}
}
