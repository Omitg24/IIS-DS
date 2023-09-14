package editor.core;

public interface Tool 
{
	//-- Eventos del ratón
	void clickOn(int x, int y);
	void moveTo(int x, int y);
	void release();
	//-- Para inicializar su estado
	void reset();
}
