package vm;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.*;

import vm.instructions.*;
import vm.parser.*;

import org.junit.*;

public class InterpreterTest 
{
	private VirtualMachine vm;
	private Parser parser;
	
	@Before
	public void setUp()
	{
		vm = new VirtualMachine();
		parser = new Parser();
	}
	
	@Test
	public void testFactorial() throws ProgramException, IOException, ParserException 
	{
		vm.executeProgram(parser.parse("factorial5.txt"));
		assertEquals(120, vm.getContext().pop());
	}
	
	@Test
	public void testEmptyStack() throws ProgramException
	{
		List<Instruction> program = new ArrayList<>();
		program.add(new Add());
		try {
			vm.executeProgram(program);
			fail("Se debería haber obtenido un error de ejecución de pila vacía");
		} catch (ProgramException e) {	
		}
		try {
			program = new ArrayList<>();
			program.add(new Push(5));
			program.add(new Add());
			vm.executeProgram(program);
			fail("Se debería haber obtenido un error de ejecución de pila vacía");
		} catch (ProgramException e) {			
		}
		program = new ArrayList<>();
		program.add(new Push(5));
		program.add(new Push(3));
		program.add(new Add());
		vm.executeProgram(program);
		assertEquals(8, vm.getContext().pop());
	}
	
	@Test
	public void testStackOverflow() throws ProgramException
	{
		List<Instruction> program = new ArrayList<>();
		for (int i = 0; i <= Context.STACK_SIZE; i ++) {
			program.add(new Push(i));			
		}
		try {
			vm.executeProgram(program);
			fail("Se debería haber obtenido un error de desbordamiento de pila");
		} catch (ProgramException e) {	
		}
	}	
}
