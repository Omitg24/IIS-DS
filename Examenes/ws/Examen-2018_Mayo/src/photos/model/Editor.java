package photos.model;

import java.util.*;


public class Editor 
{	
	private List<Photo> library = new ArrayList<>();	
	// la foto que está actualmente abierta en el editor
	private Photo current;
	
	private Settings settingsCopy;
		
	public void addPhoto(Photo photo)
	{
		library.add(photo);
	}
	
	public void open(int index)
	{
		current = getPhoto(index);
	}
	
	public Photo getCurrentPhoto()
	{
		return current;
	}
	
	public List<Photo> getAllPhotos()
	{
		return Collections.unmodifiableList(library);
	}
	
	public void copyPhoto(Settings settings) {
		this.settingsCopy = settings;
	}
	
	public void pasteSettings() {
		this.current.setSettings(this.settingsCopy);
	}
	

	//-- Métodos auxiliares
	
	private Photo getPhoto(int index)
	{
		checkPhotoIndex(index);
		return library.get(index - 1);
	}

	private void checkPhotoIndex(int index)
	{
		if (index < 1 || index > library.size())
			throw new IllegalArgumentException(String.format(
					"%d no es un número de foto válido: (%d-%d)", index, 1, library.size()));		
	}
	
	@Override
	public String toString()
	{
		return String.format("Editor: %d fotos - foto abierta: %s", library.size(), current);
	}
}
