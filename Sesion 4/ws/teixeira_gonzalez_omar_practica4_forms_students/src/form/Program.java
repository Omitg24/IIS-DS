package form;

import campos.Campo;
import campos.validation.AndValidation;
import campos.validation.OrValidation;
import campos.validation.single.DigitValidation;
import campos.validation.single.GreaterValidation;
import campos.validation.single.LengthValidation;
import campos.validation.single.LowerValidation;
import campos.validation.single.PredefinedValidation;
import campos.validation.single.TextValidation;

/**
 * Título: Clase Program
 * 
 * @author Omar Teixeira González, UO281847
 * @version 12 oct 2022
 */
public class Program {
	/**
	 * Método run
	 */
	public void run() {
		Formulario formulario = new Formulario();

		formulario.addCampo(new Campo("Nombre", new TextValidation()));
		formulario.addCampo(new Campo("Apellido", new TextValidation()));
		formulario.addCampo(new Campo("Telefono", new DigitValidation()));
		formulario.addCampo(new Campo("Ciudad", new PredefinedValidation("Santander", "Oviedo", "Cadiz")));
		formulario.addCampo(new Campo("Codigo de Producto", new LengthValidation(4)));
		formulario.addCampo(new Campo("Codigo Postal", new AndValidation(new DigitValidation(), 
							new LengthValidation(5))));
		formulario.addCampo(new Campo("Edad", new AndValidation(new DigitValidation(), 
							new GreaterValidation(18))));
		formulario.addCampo(new Campo("Sueldo", new AndValidation(new DigitValidation(), 
							new GreaterValidation(800), new LowerValidation(1200))));
		formulario.addCampo(new Campo("Ubicación", new OrValidation(new PredefinedValidation("Santander", "Oviedo", "Cadiz"), 
							new DigitValidation(), new LengthValidation(5))));
		formulario.addCampo(new Campo("Codigo de Promocion", new OrValidation(new TextValidation(),
							new AndValidation(new DigitValidation(), new LengthValidation(3)))));
		
		formulario.pideDatos();
	}
	
}
