package part1.model;

public class Mobile {
	
	private String brand;
	private String model;

	public Mobile(String brand, String model) {
		setBrand(brand);
		setModel(model);
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

}
