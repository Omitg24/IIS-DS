package interpreter;

import interpreter.ast.nodes.*;

public interface Visitor {
	Object visit(Program p, Object o);
	Object visit(Print p, Object o);
	Object visit(Read r, Object o);
	Object visit(Assignment a, Object o);
	Object visit(IntegerLiteral il, Object o);
	Object visit(Product p, Object o);
	Object visit(Division d, Object o);
	Object visit(Sum s, Object o);
	Object visit(Variable v, Object o);
}
