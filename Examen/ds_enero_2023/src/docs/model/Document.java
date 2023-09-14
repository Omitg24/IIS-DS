package docs.model;

import java.util.*;

public class Document {

	public void setCover(String image) {
		this.cover = image;
	}

	public String getCover() {
		return cover;
	}

	public void insert(String line) {
		contents.add(line);
	}
	
	public List<String> getContents() {
		return Collections.unmodifiableList(contents);
	}
	
	private List<String> contents = new ArrayList<>();
    private String cover = "";
}
