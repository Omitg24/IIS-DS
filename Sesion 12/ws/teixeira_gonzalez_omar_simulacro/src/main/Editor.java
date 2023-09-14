package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import action.Action;

public class Editor {	

	private StringBuilder texto;
	private String macro;
	private List<Action> actions = new ArrayList<Action>();
	private HashMap<String, List<Action>> macros = new HashMap<String, List<Action>>();
	
	public Editor() {
		this.texto=new StringBuilder("");
	}

	public void abrir(String file) throws IOException {
		this.texto=readFile(file);
	}
	
	public void insertar(String[] line) {
		for (int i = 1; i < line.length; i++) {
			texto.append(line[i] + " ");
		}
	}
	
	public void borrar() {
		int indexOfLastWord = texto.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			texto = new StringBuilder("");
		else
			texto.setLength(indexOfLastWord + 1);
	}
	
	public void reemplazar(String[] line) {
		texto = new StringBuilder(texto.toString().replaceAll(Pattern.quote(line[1]), line[2]));
	}
	
	public void añadirMacro(String macro) {
		this.macro = macro;
	}
	
	public void parar() {
		macros.put(macro, actions);
		this.macro="";
		this.actions= new ArrayList<Action>();
	}
	
	public void añadirAccion(Action action) {
		actions.add(action);
	}
	
	public List<Action> getActions(String key) {
		return macros.get(key);
	}	
	
	public StringBuilder getTexto() {
		return texto;
	}
	
	private StringBuilder readFile(String filename) throws IOException 
	{
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result;
	}	
}
