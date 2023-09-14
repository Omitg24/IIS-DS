package part2.model;

public class Mobile 
{
	public Mobile(String brand, String model) 
	{
		setBrand(brand);
		setModel(model);
	}

	public void setBrand(String brand) 
	{
		this.brand = brand;
	}

	public String getBrand() 
	{
		return brand;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public String getModel() 
	{
		return model;
	}
	
	private String brand;
	private String model;	
}
