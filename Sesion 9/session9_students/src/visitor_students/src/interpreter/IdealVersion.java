package interpreter;

import interpreter.ast.nodes.*;

/*
 * Esto es como nos gustaría poder hacerlo, pero no es posible: no hay despacho múltiple en Java
 */
/*
public class IdealVersion 
{

	public void visit(Program program) 
	{
		for (Statement statement : program.statements)
			visit(statement);
	}

	public void visit(Print print) 
	{
		System.out.print("print ");
		visit(print.expression);
		System.out.println(";");
	}

	public void visit(Assignment assignment) 
	{
		visit(assignment.variable);
		System.out.print(" = ");
		visit(assignment.expression);
		System.out.println(";");
	}

	public void visit(Read read) 
	{
		System.out.print("read ");
		visit(read.variable);
		System.out.println(";");
	}

	public void visit(Sum sum) 
	{
		visit(sum.left);
		System.out.print(" + ");
		visit(sum.right);
	}

	public void visit(Division div) 
	{
		visit(div.left);
		System.out.print(" / ");
		visit(div.right);
	}

	public void visit(Product product) 
	{
		visit(product.left);
		System.out.print(" * ");
		visit(product.right);
	}

	public void visit(Variable variable) 
	{
		System.out.print(variable.name);
	}

	public void visit(IntegerLiteral number) 
	{
		System.out.print(number.value);
	}
}
*/
