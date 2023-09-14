package interpreter;

import java.io.BufferedReader;
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

public class InterpreterVisitor implements Visitor {
	
    private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    private Map<String, Integer> memory = new HashMap<String, Integer>();

	@Override
	public Object visit(Program p, Object o) {
		for (Statement s : p.statements) {
			s.accept(this, o);
		}
		return o;
	}

	@Override
	public Object visit(Print p, Object o) {
		System.out.println("print " + p.expression.accept(this, null) + ";");
		return o;
	}

	@Override
	public Object visit(Read r, Object o) {
		int value;
		System.out.print("Introduzca el valor de la variable " + r.variable.name + ": ");
		try {
			value = Integer.parseInt(console.readLine());
		} catch (Exception e) {
			value = 0;
		}
		memory.put(r.variable.name, value);
		return o;
	}

	@Override
	public Object visit(Assignment a, Object o) {
		int value = (int) a.expression.accept(this, o);
		memory.put(a.variable.name, value);
		return o;
	}

	@Override
	public Object visit(IntegerLiteral il, Object o) {
		return Integer.parseInt(il.value);
	}

	@Override
	public Object visit(Product p, Object o) {
		int first = (int) p.left.accept(this, o);
		int second = (int) p.right.accept(this, o);
		return first * second;
	}

	@Override
	public Object visit(Division d, Object o) {
		int first = (int) d.left.accept(this, o);
		int second = (int) d.right.accept(this, o);
		return first / second;
	}

	@Override
	public Object visit(Sum s, Object o) {
		int first = (int) s.left.accept(this, o);
		int second = (int) s.right.accept(this, o);
		return first + second;
	}

	@Override
	public Object visit(Variable v, Object o) {
		Integer value = memory.get(v.name);
		if (value == null) {
			value = 0;
		}
		return value;
	}

}
