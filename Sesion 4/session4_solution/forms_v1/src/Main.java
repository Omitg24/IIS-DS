import form.Field;
import form.Form;
import form.validation.PredefinedValidator;

public class Main 
{
	public static void main(String[] args)
	{
		Form form = new Form();

		form.addField(new Field("Nombre", Field.TEXT));
		form.addField(new Field("Apellidos", Field.TEXT));
		form.addField(new Field("Teléfono", Field.NUMBER));
		form.addField(new Field("Ciudad", new PredefinedValidator("Santander", "Oviedo", "Cádiz")));
		
		form.askUser();
	}
}
