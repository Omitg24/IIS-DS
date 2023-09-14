package slides.content;

import slides.ui.Canvas;

public class Image implements Placeholder 
{
    private String url = "";
    private String alt = "";

    public Image()
    {
    }

    public Image(String url, String alt)
    {
        this.url = url;
        this.alt = alt;
    }

    public String getUrl()
    {
        return url;
    }

    public String getAlt()
    {
        return alt;
    }

    @Override
    public void edit(Canvas canvas)
    {
        canvas.drawText("Ubicación de la imagen: ");
        url = canvas.askUser();
        canvas.drawText("Texto alternativo: ");
        alt = canvas.askUser();
    }

    @Override
    public void paint(Canvas canvas)
    {
        canvas.drawText(String.format("Imagen: %s (%s)%n", url, alt));
    }

    @Override
    public String toString()
    {
        return "Imagen";
    }
}