package slides.layout.layouttypes;

import slides.content.Placeholder;
import slides.layout.Layout;
import slides.layout.LayoutType;
import slides.ui.Canvas;

public class ColumnsLayout implements LayoutType {

	@Override
	public void drawLayout(Canvas canvas, Layout layout) {
        canvas.drawLine("┌────┬────┬─   ───┐");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("│    │    │  ...  │");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("│    │    │       │");
        canvas.drawLine("└────┴────┴─   ───┘");        
        for (Placeholder each : layout.getPlaceholders()) {
            canvas.drawLine("Dibujando en: " + layout.getPosition(each) + "...");
            each.paint(canvas);
        }
	}

	@Override
	public String toString() {
		return "Layout en columnas";
	}
}
