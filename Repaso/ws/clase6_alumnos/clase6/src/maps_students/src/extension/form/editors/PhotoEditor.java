package extension.form.editors;

import extension.form.Editor;
import extension.model.Photo;

public class PhotoEditor extends Editor {

	private Photo photo;
	
	public PhotoEditor(Photo photo) {
		this.photo = photo;
	}

	@Override
	protected void editFields() {
		System.out.print(" - Usuario: ");
		String value = readLine();
		if (value.length() > 0) {
			this.photo.setUser(value);
		}

		System.out.print(" - Descripcion: ");
		value = readLine();
		if (value.length() > 0) {
			this.photo.setDescription(value);
		}
	}

	@Override
	protected void printFields() {
		System.out.println(" - Usuario: " + this.photo.getUser());
		System.out.println(" - Descripcion: " + this.photo.getDescription());
	}

	@Override
	protected void showInfo() {
		System.out.println("Editando la foto...");
	}
}
