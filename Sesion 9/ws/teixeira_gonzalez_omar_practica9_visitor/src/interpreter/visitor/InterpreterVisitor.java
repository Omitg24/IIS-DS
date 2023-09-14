package interpreter.visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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

public class InterpreterVisitor implements Visitor{

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Map<String, Integer> map = new HashMap<String, Integer>();
	
	@Override
	public Object visit(Program p, Object o) {
		for (Statement s : p.statements) {
			s.accept(this, null);
		}
		return null;
	}

	@Override
	public Object visit(Print p, Object o) {
		System.out.println("print " + p.expression.accept(this, null) + ";");
		return null;
	}

	@Override
	public Object visit(Assignment a, Object o) {
		Integer value = (Integer) a.expression.accept(this, o);
		map.put(a.variable.name, value);
		return null;
	}

	@Override
	public Object visit(Read r, Object o) {
		int value;
		System.out.print("Introduca el valor de la variable a leer: " + r.variable.name + "= ");
		try {
			value = Integer.valueOf(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			value = 0;
		}
		map.put(r.variable.name, value);
		return null;
	}

	@Override
	public Object visit(Sum s, Object o) {
		return (Integer) s.left.accept(this, null) + (Integer) s.right.accept(this, null);
	}

	@Override
	public Object visit(Division d, Object o) {
		return (Integer) d.left.accept(this, null) / (Integer) d.right.accept(this, null);
	}

	@Override
	public Object visit(Product p, Object o) {
		return (Integer) p.left.accept(this, null) * (Integer) p.right.accept(this, null);
	}

	@Override
	public Object visit(Variable v, Object o) {
		Integer value = map.get(v.name); 
		return value == null ? 0 : value;
	}

	@Override
	public Object visit(IntegerLiteral il, Object o) {
		return Integer.valueOf(il.value);
	}
}
