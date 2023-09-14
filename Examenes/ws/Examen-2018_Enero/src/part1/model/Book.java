package part1.model;

public class Book {
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	private String title;
	private String author;
}
