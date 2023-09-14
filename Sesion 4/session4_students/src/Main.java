public class Main {

	public static void main(String[] args) {
		Formulario formulario = new Formulario();

		formulario.addCampo(new CampoTexto("Nombre"));
		formulario.addCampo(new CampoTexto("Apellido"));
		formulario.addCampo(new CampoNumero("Telefono"));
		formulario.addCampo(new CampoPredefinido("Ciudad", "Santander", "Oviedo", "Cadiz"));

		formulario.PideDatos();
	}
}
