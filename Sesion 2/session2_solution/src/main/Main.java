package main;

import vm.VirtualMachine;
import vm.parser.*;

public class Main 
{
	public static void main(String[] args)
	{
		Parser parser = new Parser();
		VirtualMachine vm = new VirtualMachine();
		
		try {			
			vm.executeProgram(parser.parse("factorial.txt"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
