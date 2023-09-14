package part2.model;

public class Book 
{
	public Book(String title, String author, String editorial, String language) 
	{
		this.title = title;
		this.author = author;
		this.editorial = editorial;
		this.language = language;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setAuthor(String author) 
	{		
		this.author = author;
	}

	public String getAuthor() 
	{
		return author;
	}

	public String getEditorial() 
	{
		return editorial;
	}

	public void setEditorial(String editorial) 
	{
		this.editorial = editorial;
	}

	public String getLanguage() 
	{
		return language;
	}

	public void setLanguage(String language) 
	{
		this.language = language;
	}
	
	private String title;
	private String author;
	private String editorial;
	private String language;
}
