package part1.adapters;

import part1.model.Book;
import part1.view.Media;

public class BookAdapter implements Media {

	private Book book;
		
	public BookAdapter(Book book) {
		this.book = book;
	}

	@Override
	public String getCad1() {		
		return this.book.getTitle();
	}

	@Override
	public String getCad2() {
		return this.book.getAuthor();
	}

}
