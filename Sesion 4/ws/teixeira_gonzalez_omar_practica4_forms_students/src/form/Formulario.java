package form;
import java.util.ArrayList;
import java.util.List;

import campos.Campo;

/**
 * Título: Clase Formulario
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class Formulario {
	/**
	 * Atributo campos
	 */
	private List<Campo> campos = new ArrayList<Campo>();
	
	/**
	 * Método addCampo
	 * @param campo
	 */
	public void addCampo(Campo campo) {
		campos.add(campo);
	}

	/**
	 * Método pideDatos
	 */
	public void pideDatos() {
		for (Campo campo : campos) {
			campo.pideDato();
			System.out.println(campo.getValue());
		}
	}	
}