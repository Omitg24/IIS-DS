package extension.form.editors;

import extension.form.Editor;
import extension.model.Monument;

public class MonumentEditor extends Editor {

	private Monument monument;	
	
	public MonumentEditor(Monument monument) {
		this.monument = monument;
	}
	
	@Override
	protected void editFields() {
		System.out.print(" - Autor: ");
		String value = readLine();
		if (value.length() > 0) {
			this.monument.setAuthor(value);
		}

		System.out.print(" - Dirección: ");
		value = readLine();
		if (value.length() > 0) {
			this.monument.setAddress(value);
		}
	}

	@Override
	protected void printFields() {
		System.out.println(" - Autor: " + this.monument.getAuthor());
		System.out.println(" - Dirección: " + this.monument.getAddress());
	}
	
	@Override
	protected void showInfo() {
		System.out.println("Editando el monumento...");
	}
}
