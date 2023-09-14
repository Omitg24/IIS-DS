package vm;

import java.util.List;

public class VirtualMachine 
{	
	private Context context;

	public void executeProgram(List<Instruction> program) throws ProgramException 
	{
		if (program == null)
			throw new IllegalArgumentException("¡Se necesita un programa que ejecutar!");		
		context = new Context(program);
		while (context.getIp() < program.size()) {
			program.get(context.getIp()).execute(context);
		}
	}
	
	/*
	 * Este método se proporciona (con visibilidad de paquete) únicamente para
	 * que esté accesible para las pruebas. Aparte de eso, no sería necesario
	 * en absoluto (las instrucciones no hacen uso de él, porque ya reciben
	 * el contexto de ejecución como parámetro). Se podría eliminar el método
	 * (eliminando las pruebas unitarias), manteniendo así la ocultación de la
	 * información del intérprete.  
	 */
	Context getContext()
	{
		if (context == null)
			throw new IllegalStateException("El contexto sólo se crea al ejecutar un programa");
		return context;
	}
}
