package ligafutbol;

public class Equipo {
	private String nombre;
	private String provincia;
	private boolean masculino;
	private int edad;

	public Equipo(String nombre, String provincia, boolean masculino,
			int edad) {
		this.nombre = nombre;
		this.provincia = provincia;
		this.masculino = masculino;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public boolean isMasculino() {
		return masculino;
	}

	public int getEdad() {
		return edad;
	}

	@Override
	public String toString() {
		String categoriaPorSexo = masculino ? "masculino" : "femenino";
		return String.format("'%s' [%s, %s, %d años]", nombre, provincia,
				categoriaPorSexo, edad);
	}
}
