package interpreter.visitor;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

/**
 * Titulo: Interfaz Visitor
 *
 * @author Omar Teixeira González, UO281847
 * @version 14 nov 2022
 */
public interface Visitor {
	/**
	 * Método visitProgram
	 * @param p
	 * @param o
	 * @return Object
	 */
	Object visit(Program p, Object o);
	/**
	 * Método visitPrint
	 * @param p
	 * @param o
	 * @return Object
	 */
	Object visit(Print p, Object o);
	/**
	 * Método visitAssignment
	 * @param a
	 * @param o
	 * @return Object
	 */
	Object visit(Assignment a, Object o);
	/**
	 * Método visitRead
	 * @param r
	 * @param o
	 * @return Object
	 */
	Object visit(Read r, Object o);
	/**
	 * Método visitSum
	 * @param s
	 * @param o
	 * @return Object
	 */
	Object visit(Sum s, Object o);
	/**
	 * Método visitDivision
	 * @param d
	 * @param o
	 * @return Object
	 */
	Object visit(Division d, Object o);
	/**
	 * Metodo visitProduct
	 * @param p
	 * @param o
	 * @return Object
	 */
	Object visit(Product p, Object o);
	/**
	 * Método visitVariable
	 * @param v
	 * @param o
	 * @return Object
	 */
	Object visit(Variable v, Object o);
	/**
	 * Método visitIntegerLiteral
	 * @param il
	 * @param o
	 * @return Object
	 */
	Object visit(IntegerLiteral il, Object o);
}
