package base;
public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new TextField("Nombre"));
		form.addField(new TextField("Apellido"));
		form.addField(new NumberField("Telefono"));
		form.addField(new PredefinedField("Ciudad", "Santander", "Oviedo", "Cadiz"));

		form.askData();
	}
}
