package editor.core;

import java.io.*;

import editor.actions.ActionManager;
import editor.tools.SelectionTool;

public class Editor 
{
	/*
	 * Representa el documento de dibujo. Actualmente se considera que el editor sólo
	 * tiene un único documento abierto en cada momento, pero cambiar esto sería trivial.
	 */
	private Drawing drawing = new Drawing();
	
	private PrintWriter output;
		
	/*
	 * La herramienta predeterminada, que en nuestro caso es la de selección.
	 */
	private Tool defaultTool;
	
	/*
	 * La herramienta seleccionada actualmente en el editor. Dependiendo de
	 * cuál sea ésta, el editor responderá de manera diferente ante los eventos
	 * del ratón que le llegan de la interfaz de usuario. Para ello simplemente
	 * delegará en los métodos correspondientes de la herramienta actual.
	 */
	private Tool currentTool;
	
	public Editor()
	{
		this(System.out);
	}
	
	public Editor(PrintStream out)
	{
		output = new PrintWriter(out, true); 
		currentTool = defaultTool = createDefaultTool();
	}
	
	public Drawing getDrawing()
	{
		return drawing;
	}
	
	public void setDrawing(Drawing drawing)
	{
		this.drawing = drawing;
	}
	
	public void drawDocument()
	{
		output.println("Herramienta seleccionada: " + currentTool);
		drawing.draw(output);
	}
	
	//-- Métodos que tratan con las herramientas
	
	/**
	 * Crea la herramienta predeterminada, que en la versión actual del editor
	 * es la de selección. Permite que otras implementaciones del editor redefinan
	 * dicho comportamiento para crear y devolver una herramienta distinta como
	 * la predeterminada.
	 */
	protected Tool createDefaultTool()
	{
		return new SelectionTool(this);
	}
	
	public Tool getDefaultTool()
	{
		return defaultTool;
	}
	
	public void selectTool(Tool tool)
	{
		if (tool == null)
			throw new IllegalArgumentException("¡No se puede seleccionar una herramienta nula!");

		// Antes de cambiar, da la opción a la herramienta activa de inicializar su
		// estado para que cuando vuelva a seleccionarse lo haga partiendo de cero
		currentTool.reset();
		
		currentTool = tool;
	}
	
	/**
	 * Las herramientas deben llamar a este método para avisar al editor de que han
	 * terminado y que éste lleve a cabo las acciones oportunas. En esta versión
	 * esta operación simplemente consiste en, de acuerdo con los requisitos, volver
	 * a seleccionar la herramienta predeterminada (actualmente la de selección)
	 * como la que está activa actualmente.<p>
	 * 
	 * ¿Hace falta que las herramientas llamen a este método para eso? ¿No valdría
	 * con que lo hiciese el propio editor en el método {@code released}? No, porque
	 * puede haber herramientas (y de hecho ya hay, como por ejemplo la de creación
	 * de triángulos) que terminen de otro modo, no con el evento de soltar.<p>
	 * 
	 * Y si bien es cierto que las propias herramientas, dado que guardan una referencia
	 * al editor, podrían cambiar ellas mismas la herramienta actual mediante el método
	 * {@code setTool(Tool)}, esto implicaría que todas las herramientas deberían
	 * conocer a la de selección (mayor acoplamiento), con el problema añadido de que si
	 * en un futuro la de herramienta predeterminada pasase a ser otra habría que cambiar
	 * dicho comportamiento en todas. 
	 */
	public void toolDone()
	{
		selectTool(defaultTool);
	}
	
	//-- Eventos del ratón
	
	public void clickedOn(int x, int y)
	{
		currentTool.clickOn(x, y);
	}
	
	public void movedTo(int x, int y)
	{
		currentTool.moveTo(x, y);
	}
	
	public void released()
	{
		currentTool.release();
	}
	
	//-- Operaciones que manejan las acciones del editor que se pueden deshacer/repetir
	
	public void undo()
	{
		getActionManager().undo();
	}
	
	public void redo()
	{
		getActionManager().redo();		
	}
	
	public ActionManager getActionManager()
	{
		return getDrawing().getActionManager();
	}

}
