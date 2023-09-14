package interpreter.ast.nodes;

import java.util.*;

public class Program implements Node 
{
    public List<Statement> statements;
    
    public Program(List<Statement> program) 
    {
        this.statements = program;
    }
}
