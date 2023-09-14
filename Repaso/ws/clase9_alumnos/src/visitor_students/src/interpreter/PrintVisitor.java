package interpreter;

import interpreter.ast.nodes.Assignment;
import interpreter.ast.nodes.Division;
import interpreter.ast.nodes.IntegerLiteral;
import interpreter.ast.nodes.Print;
import interpreter.ast.nodes.Product;
import interpreter.ast.nodes.Program;
import interpreter.ast.nodes.Read;
import interpreter.ast.nodes.Statement;
import interpreter.ast.nodes.Sum;
import interpreter.ast.nodes.Variable;

public class PrintVisitor implements Visitor {

	@Override
	public Object visit(Program p, Object o) {
		for (Statement s : p.statements) {
			s.accept(this, o);
		}
		return o;
	}

	@Override
	public Object visit(Print p, Object o) {
		System.out.print("print ");
		p.expression.accept(this, o);
		System.out.println(";");
		return o;
	}

	@Override
	public Object visit(Read r, Object o) {
		System.out.print("read ");
		r.variable.accept(this, o);
		System.out.println(";");
		return o;
	}

	@Override
	public Object visit(Assignment a, Object o) {
		a.variable.accept(this, o);
		System.out.print(" = ");
		a.expression.accept(this, o);
		System.out.println(";");
		return o;
	}

	@Override
	public Object visit(IntegerLiteral il, Object o) {
		System.out.print(il.value);
		return o;
	}

	@Override
	public Object visit(Product p, Object o) {
		p.left.accept(this, o);
		System.out.print(" * ");
		p.right.accept(this, o);
		return o;
	}

	@Override
	public Object visit(Division d, Object o) {
		d.left.accept(this, o);
		System.out.print(" / ");
		d.right.accept(this, o);
		return o;
	}

	@Override
	public Object visit(Sum s, Object o) {
		s.left.accept(this, o);
		System.out.print(" + ");
		s.right.accept(this, o);
		return o;
	}

	@Override
	public Object visit(Variable v, Object o) {
		System.out.print(v.name);
		return o;
	}
}
