package photos.model;

public class Settings {

	// valores de los ajustes predefinidos, inicializados a sus valores por omisión
	private int brightness = 0, contrast = 0;	
	// si se han aplicado o no a la foto
	private boolean isBrightnessEnabled, isContrastEnabled;
	
	
	public String applyAdjustments(String image)
	{
		String result = image;
		if (isBrightnessEnabled)
			result = applyBrightness(result);
		if (isContrastEnabled)
			result = applyContrast(result);
		return result;
	}
	
	public String applyBrightness(String image)
	{
		return image + String.format("\nBrillo: %+d", brightness);
	}
	
	public String applyContrast(String image)
	{
		return image + String.format("\nContraste: %+d", contrast);
	}
	
	public void enableAdjustment(String adjustmentName)
	{
		if (adjustmentName.equalsIgnoreCase("brillo"))
			isBrightnessEnabled = true;
		else if (adjustmentName.equalsIgnoreCase("contraste"))
			isContrastEnabled = true;
		else
			throw new IllegalArgumentException("Nombre de ajuste desconocido");
	}
	
	public void setAdjustment(String adjustmentName, int value)
	{
		if (adjustmentName.equalsIgnoreCase("brillo")) {
			brightness = value;
			isBrightnessEnabled = true;
		} else if (adjustmentName.equalsIgnoreCase("contraste")) {
			contrast = value;
			isContrastEnabled = true;
		} else
			throw new IllegalArgumentException("Nombre de ajuste desconocido");
	}

	public void disableAdjustment(String adjustmentName)
	{
		if (adjustmentName.equalsIgnoreCase("brillo")) {
			isBrightnessEnabled = false;
			brightness = 0;
		} else if (adjustmentName.equalsIgnoreCase("contraste")) {
			isContrastEnabled = false;
			contrast = 0;
		} else
			throw new IllegalArgumentException("Nombre de ajuste desconocido");
	}
}
