package photos.model;

public class Photo 
{
	private String image;

	private Settings settings;
	
	public Photo(String filename)
	{
		image = new String(filename);
		this.settings = new Settings();
	}
	
	/**
	 * Devuelve una copia de la imagen que representa esta fotografía a la que
	 * se le han aplicado todos los ajustes realizados en la foto. Nótese que
	 * este método no modifica la imagen original, sino que crea una copia de
	 * la misma que es sobre la que se aplican los ajustes y la que finalmente
	 * se devuelve.
	 *  
	 * @return un objeto {@code String} que representa la imagen generada
	 *         resultante de aplicar los ajustes realizados a esta fotografía 
	 */
	public String outputImage()
	{
		String result = new String(image);
		result = settings.applyAdjustments(result);
		return result;
	}	
	
	public void enableAdjustment(String adjustmentName)
	{
		this.settings.enableAdjustment(adjustmentName);
	}
	
	public void setAdjustment(String adjustmentName, int value)
	{
		this.settings.setAdjustment(adjustmentName, value);
	}

	public void disableAdjustment(String adjustmentName)
	{
		this.settings.disableAdjustment(adjustmentName);
	}	
	
	//-- Otros métodos	
	@Override
	public String toString()
	{
		return String.format(image);
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	public Settings getSettings() {
		return settings;
	}	
}
