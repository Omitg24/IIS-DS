package extension.model;

public class Monument
{
	private String name;
	private String author;
	private String address;

	public Monument(String name, String author, String address)
	{
		this.name = name;
		this.author = author;
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	public String getAddress()
	{
		return address;
	}

	public String getAuthor()
	{
		return author;
	}	

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Monument [name=" + name + ", author=" + author + ", address=" + address + "]";
	}	
}
