package slides.model;

import java.util.*;

import slides.layout.MasterLayout;

public class Presentation 
{
    private String name;

    // las diapositivas de la presentación
    private List<Slide> slides = new ArrayList<>();
    // índice de la diapositiva actual (-1 si está vacía)
    private int currentSlide = -1;
    
    private Map<String, MasterLayout> masterLayouts = new HashMap<>();

    public Presentation(String name)
    {
        this.name = name;
    }

    public void addSlide(Slide slide)
    {
        currentSlide++;
        slides.add(currentSlide, slide);
    }

    //-- Operaciones de navegación

    public Slide currentSlide()
    {
        checkNotEmpty();
        return slides.get(currentSlide);
    }

    public boolean hasNext()
    {
        return currentSlide < slides.size() - 1;
    }

    public void nextSlide()
    {
        checkNotEmpty();
        if (!hasNext())
            throw new IllegalStateException("No hay más diapositivas");
        currentSlide++;
    }

    public boolean hasPrevious()
    {
        return currentSlide > 0;
    }

    public void previousSlide()
    {
        checkNotEmpty();
        if (!hasPrevious())
            throw new IllegalStateException("Ya estás en la diapositiva inicial");
        currentSlide--;
    }

    private void checkNotEmpty()
    {
        if (slides.isEmpty())
            throw new IllegalStateException("Aún no has añadido diapositivas a la presentación");
    }
    
    public void addMasterLayout(String name, MasterLayout layout) {
    	this.masterLayouts.put(name, layout);
    }
    
    public Map<String, MasterLayout> getMasterLayouts() {
    	return masterLayouts;
    }

    //-- Operaciones de consulta

    public List<Slide> getSlides()
    {
        return Collections.unmodifiableList(slides);
    }

    public int currentSlideNumber()
    {
        return currentSlide + 1;
    }

    public String getName()
    {
        return name;
    }

    public boolean isEmpty()
    {
        return slides.isEmpty();
    }

    @Override
    public String toString()
    {
        return String.format("Presentación de %d diapositivas");
    }
}