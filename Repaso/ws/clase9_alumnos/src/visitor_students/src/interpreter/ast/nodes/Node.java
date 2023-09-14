package interpreter.ast.nodes;

import interpreter.Visitor;

public interface Node
{
	Object accept(Visitor v, Object o);
}
