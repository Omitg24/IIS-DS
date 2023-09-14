package slides.layout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import slides.content.Placeholder;
import slides.ui.Canvas;

public class Layout implements MasterLayout
{
    // asocia los marcadores de posición de esta disposición con la posición
    // que ocupan en el mismo (simulada aquí mediante una simple cadena de texto
    // como "CENTER", "TOP", "BOTTOM_LEFT" o similares; en un caso real sería
    // un objeto con toda la información necesaria para cada tipo de layout)
    private Map<Placeholder, String> positions = new LinkedHashMap<>();
    // los marcadores de posición (títulos, listas, imágenes...) de este layout
    private List<Placeholder> placeholders = new ArrayList<>();

    private LayoutType type;
    
    public Layout(LayoutType type)
    {
        this.type = type;
    }
    
    public Layout(Layout layout) {
		this.positions = new LinkedHashMap<Placeholder, String>(layout.positions);
		this.placeholders = new ArrayList<>(layout.placeholders);
		this.type = layout.type;
	}

	public void setType(LayoutType type) {
    	this.type = type;
    }

    public void addPlaceholder(String position, Placeholder placeholder) 
    {
        placeholders.add(placeholder);
        positions.put(placeholder, position);
    }

    public List<Placeholder> getPlaceholders()
    {
        return Collections.unmodifiableList(placeholders);
    }

    public String getPosition(Placeholder placeholder)
    {
        if (!positions.containsKey(placeholder))
            throw new IllegalArgumentException("Este layout no contiene ese marcador: " + placeholder);
        return positions.get(placeholder);
    }

    @Override
    public String toString()
    {
        return type.toString();
    }

	public void draw(Canvas canvas) {
		type.drawLayout(canvas, this);		
	}
	
	@Override
	public MasterLayout clone() {
		return new Layout(this);
	}
}