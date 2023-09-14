package slides.content;

import java.util.*;

import slides.ui.Canvas;

public class Bullets implements Placeholder 
{
    private List<String> elements = new ArrayList<>();

    public Bullets() 
    {
    }

    public Bullets(String... elements) 
    {
        this(Arrays.asList(elements));
    }

    public Bullets(List<String> elements) 
    {
        if (elements == null)
            throw new NullPointerException("¡Lista de elementos nula!");
        this.elements = elements;
    }

    public List<String> getElements() 
    {
        return Collections.unmodifiableList(elements);
    }

    @Override
    public void edit(Canvas canvas) 
    {
        canvas.drawLine("Introduce los elementos de la lista, uno a uno (en blanco para terminar):");
        elements = new ArrayList<>();
        do {
            canvas.drawText(" - ");
            String element = canvas.askUser();
            if (element.isEmpty())
                return;
            elements.add(element);
        } while (true);
    }

    @Override
    public void paint(Canvas canvas) 
    {
        for (String each : elements) {
            canvas.drawLine(" - " + each);
        }
    }

    @Override
    public String toString() 
    {
        return "Lista de viñetas";
    }
}