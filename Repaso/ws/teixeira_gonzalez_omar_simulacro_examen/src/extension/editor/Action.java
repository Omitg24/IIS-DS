package extension.editor;

import java.io.IOException;

public interface Action {
	void execute(Editor editor) throws IOException;
}
