package model;

public class Restaurant 
{
	private String name;
	private String address;
	private String phone;

	public Restaurant(String name, String address, String phone) 
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getName() 
	{
		return name;
	}

	public String getAddress() 
	{
		return address;
	}

	public String getPhone() 
	{
		return phone;
	}

	/**
	 * Marca el número del restaurante en el teléfono.
	 */
	public void call() 
	{
		System.out.printf("Llamando al %s...\n", phone);
	}
}
