package editor;

import editor.actions.*;

public class Editor 
{
	private StringBuilder text = new StringBuilder();
	private ActionManager actionManager = new ActionManager(this);
	
	public StringBuilder getText()
	{
		return text;
	}
	
	public void setText(StringBuilder text)
	{
		this.text = text;
	}
	
	public void open(String filename)
	{
		actionManager.execute(new Open(filename));
	}
	
	public void insert(String[] wordsToBeInserted)
	{
		actionManager.execute(new Insert(wordsToBeInserted));
	}
	
	public void removeLastWord()
	{
		actionManager.execute(new RemoveLastWord());
	}
	
	public void replace(String source, String destination)
	{
		actionManager.execute(new Replace(source, destination));
	}
	
	public void recordMacro(String name)
	{
		actionManager.record(name);
	}
	
	public void stop()
	{
		actionManager.stop();
	}
	
	public void executeMacro(String name)
	{
		actionManager.executeMacro(name);
	}
}
