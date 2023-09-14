#PATRONES DE DISEÑO

En esta práctica se han utilizado los patrones de diseño:

	COMMAND:
		1 ) Command -> Action
			Métodos:
			- execute() -> execute()
			
		2 ) ConcreteCommand -> Delete, Insert, Open, Replace, Macro
			Métodos:
			- execute() -> execute()		
		
		3 ) Receiver -> Editor
			Métodos:
			- action() -> getText()
			
		4 ) Invoker -> Manager
	
	COMPOSITE:
		1 ) Component -> Action
			Métodos:
			- Operation() -> execute()
			
		2 ) Leaf -> Delete, Insert, Open, Replace
			Métodos:
			- Operation() -> execute()
		
		3) Composite -> Macro
			Métodos:
			- Add(Component) -> addAction(Action)
			- Operation() -> execute()			
		