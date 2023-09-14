package model;

/**
 * Titulo: Clase Restaurant
 *
 * @author Omar Teixeira González, UO281847
 * @version 30 oct 2022
 */
public class Restaurant
{	
	/**
	 * Atributo name
	 */
	private String name;
	/**
	 * Atributo address
	 */
	private String address;
	/**
	 * Atributo phone
	 */
	private String phone;
	
	/**
	 * Constructor Restaurant
	 * @param name
	 * @param address
	 * @param phone
	 */
	public Restaurant(String name, String address, String phone) 
	{
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	/**
	 * Método setName
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Método setAddress
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Método setPhone
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * Método getAddress
	 * @return address
	 */
	public String getAddress() 
	{
		return address;
	}
	
	/**
	 * Método getPhone
	 * @return phone
	 */
	public String getPhone() 
	{
		return phone;
	}

	/**
	 * Método call
	 * Marca el número del restaurante en el teléfono.
	 */
	public void call() 
	{
		System.out.printf("Llamando al %s...\n", phone);
	}

	/**
	 * Método toString
	 */
	@Override
	public String toString() {
		return "\nRestaurant [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}	
}
