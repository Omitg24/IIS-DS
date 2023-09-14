package slides.content;

import slides.ui.Canvas;

public class Title implements Placeholder
{
    private String text = "";

    public Title()
    {
    }

    public Title(String text) 
    {
        this.text = text;
    }

    @Override
    public void edit(Canvas canvas)
    {
        canvas.drawText("Introduce el texto del título: ");
        setText(canvas.askUser());
    }

    @Override
    public void paint(Canvas canvas) 
    {
       canvas.drawLine(text.toUpperCase());
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public String toString()
    {
        return "Título";
    }
}