package extension;

import extension.validators.AndValidator;
import extension.validators.GreaterThanValidator;
import extension.validators.LengthValidator;
import extension.validators.LowerThanValidator;
import extension.validators.NumberValidator;
import extension.validators.OrValidator;
import extension.validators.PredefinedValidator;
import extension.validators.TextValidator;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new Field("Nombre",
						new TextValidator()));
		form.addField(new Field("Apellido",
						new TextValidator()));
		form.addField(new Field("Telefono",
						new NumberValidator()));
		form.addField(new Field("Ciudad",
						new PredefinedValidator("Santander", "Oviedo", "Cadiz")));
		form.addField(new Field("Codigo de Producto",
						new LengthValidator(4)));
		form.addField(new Field("Codigo Postal",
						new AndValidator(
								new NumberValidator(),
								new LengthValidator(5))));
		form.addField(new Field("Edad",
						new AndValidator(
								new NumberValidator(),
								new GreaterThanValidator(18))));
		form.addField(new Field("Sueldo",
						new AndValidator(
								new NumberValidator(),
								new GreaterThanValidator(800),
								new LowerThanValidator(1200))));
		form.addField(new Field("Ubicación",
						new OrValidator(
								new PredefinedValidator("Santander", "Oviedo", "Cadiz"),
								new AndValidator(
										new NumberValidator(),
										new LengthValidator(5)))));
		form.addField(new Field("Codigo de Promocion",
						new OrValidator(
								new TextValidator(),
								new AndValidator(
										new NumberValidator(),
										new LengthValidator(3)))));

		form.askData();
	}
}
