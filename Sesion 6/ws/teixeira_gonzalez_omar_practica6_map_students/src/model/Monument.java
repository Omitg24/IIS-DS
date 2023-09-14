package model;

/**
 * Titulo: Clase Monument
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class Monument
{
	/**
	 * Atributo name
	 */
	private String name;
	/**
	 * Atributo author
	 */
	private String author;
	/**
	 * Atributo address
	 */
	private String address;

	/**
	 * Constructor Monument
	 * @param name
	 * @param author
	 * @param address
	 */
	public Monument(String name, String author, String address) 
	{
		this.name = name;
		this.author = author;
		this.address = address;
	}
	
	/**
	 * Método getName
	 * @return name
	 */
	public String getName() 
	{
		return name;
	}
	
	/**
	 * Método setName
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Método getAddress
	 * @return address
	 */
	public String getAddress() 
	{
		return address;
	}
	
	/**
	 * Método setAddress
	 * @param address
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	/**
	 * Método getAuthor
	 * @return author
	 */
	public String getAuthor() 
	{
		return author;
	}
	
	/**
	 * Método setAuthor
	 * @param author
	 */
	public void setAuthor(String author)
	{
		this.author = author;
	}

	/**
	 * Método toString
	 * @return String
	 */
	@Override
	public String toString() {
		return "\nMonument [name=" + name + ", author=" + author + ", address=" + address + "]";
	}	
}
