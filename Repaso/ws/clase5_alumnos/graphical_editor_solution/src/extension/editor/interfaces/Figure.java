package extension.editor.interfaces;

public interface Figure {
	void move(int x, int y);
	boolean contains(int x, int y);
	void draw();
}
