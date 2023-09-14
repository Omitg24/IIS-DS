package editor.actions;

import editor.Editor;

public class RemoveLastWord implements Action
{
	@Override
	public void execute(Editor editor) 
	{
		int indexOfLastWord = editor.getText().toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			editor.setText(new StringBuilder(""));
		else
			editor.getText().setLength(indexOfLastWord + 1);
	}
	
	@Override
	public String toString()
	{
		return "Borrar";
	}
}
