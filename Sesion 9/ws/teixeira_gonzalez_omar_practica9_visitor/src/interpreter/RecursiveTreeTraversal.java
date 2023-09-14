package interpreter;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Node;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Statement;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

/*
 * Así, haciendo un recorrido recursivo del árbol, a la manera tradicional, sí funciona.
 * ¿Inconveniente? Que todo el código de todos los nodos está en un solo metodo.
 */
public class RecursiveTreeTraversal 
{
	public void visit(Node node) 
	{
		if (node instanceof Program) {
			for (Statement sent : ((Program) node).statements)
				visit(sent);
		} else if (node instanceof Print) {
			System.out.print("print ");
			visit(((Print) node).expression);
			System.out.println(";");
		} else if (node instanceof Read) {
			System.out.print("read ");
			visit(((Read) node).variable);
			System.out.println(";");
		} else if (node instanceof Assignment) {
			visit(((Assignment) node).variable);
			System.out.print(" = ");
			visit(((Assignment) node).expression);
			System.out.println(";");
		} else if (node instanceof IntegerLiteral) {
			System.out.print(((IntegerLiteral) node).value);
		} else if (node instanceof Product) {
			visit(((Product) node).left);
			System.out.print(" * ");
			visit(((Product) node).right);
		} else if (node instanceof Division) {
			visit(((Division) node).left);
			System.out.print(" / ");
			visit(((Division) node).right);
		} else if (node instanceof Sum) {
			visit(((Sum) node).left);
			System.out.print(" + ");
			visit(((Sum) node).right);
		} else if (node instanceof Variable) {
			System.out.print(((Variable) node).name);
		}
	}
}
