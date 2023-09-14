package editor;

import java.util.Stack;

import editor.changes.Changes;

/**
 * Título: Clase History
 * 
 * @author Omar Teixeira González, UO281847
 * @version 18 oct 2022
 */
public class History {
	/**
	 * Atributo undoStack
	 */
	private Stack<Changes> undoStack;
	/**
	 * Atributo redoStack
	 */
	private Stack<Changes> redoStack;
	
	/**
	 * Constructor History
	 */
	public History() {
		undoStack = new Stack<Changes>();
		redoStack = new Stack<Changes>();
	}
	
	/**
	 * Método addChange
	 * @param changes
	 */
	public void addChange(Changes changes) {
		undoStack.push(changes);
		redoStack.clear();
	}		
	/**
	 * Método undo
	 */
	public void undo() {
		if (undoStack.isEmpty()) {
			System.out.println("----> No se puede deshacer si no se ha hecho nada.");
			return;
		}
		Changes change = undoStack.pop();
		change.undo();
		redoStack.push(change);		
	}
	
	/**
	 * Método redo
	 */
	public void redo() {
		if (redoStack.isEmpty()) {
			System.out.println("----> No se puede rehacer si no se ha deshecho nada.");
			return;
		}
		Changes change = redoStack.pop();
		change.redo();
		undoStack.push(change);		
	}
}
