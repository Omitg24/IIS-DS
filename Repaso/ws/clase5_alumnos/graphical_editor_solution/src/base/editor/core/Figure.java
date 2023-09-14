package base.editor.core;

import java.io.PrintWriter;

public interface Figure
{
	void draw(PrintWriter output);
	boolean contains(int x, int y);
	void moveBy(int dx, int dy);
}
