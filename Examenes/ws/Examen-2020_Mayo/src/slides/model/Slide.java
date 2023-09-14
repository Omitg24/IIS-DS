package slides.model;

import slides.content.Placeholder;
import slides.layout.Layout;
import slides.ui.Canvas;

public class Slide 
{
    private Layout layout;

    public Slide(Layout layout)
    {
        if (layout == null)
            throw new NullPointerException("¡Se necesita un layout para crear la diapositiva!");
        this.layout = layout;
    }
    
    public Layout getLayout()
    {
    	return layout;
    }
 
    public void show(Canvas canvas)
    {
    	this.layout.draw(canvas);        
    }

    public void edit(Canvas canvas)
    {
        for (Placeholder each : layout.getPlaceholders()) {
            each.edit(canvas);
        }
    }
    
    @Override
    public String toString()
    {
        return String.format("Diapositiva con %d marcadores de posición%n  => %s",
                layout.getPlaceholders().size(), layout);
    }
}