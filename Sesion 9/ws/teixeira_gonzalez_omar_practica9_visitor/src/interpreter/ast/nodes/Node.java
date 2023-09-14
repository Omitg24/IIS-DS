package interpreter.ast.nodes;

import interpreter.visitor.Visitor;

/**
 * Titulo: Interfaz Node
 *
 * @author Omar Teixeira González, UO281847
 * @version 14 nov 2022
 */
public interface Node
{
	/**
	 * Método accept
	 * @param v
	 * @param o
	 * @return Object
	 */
	Object accept(Visitor v, Object o);
}
