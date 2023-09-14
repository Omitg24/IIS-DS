package extension;

public class Temperature {

	private double value;

	public Temperature(double value) {
		this.value = value;
	}

	public double getCelsius() {
		return value;
	}

	public double getFahrenheit() {
		return value * 9 / 5 + 32;
	}

	public void setCelsius(double value) {
		this.value = value;
	}

	public void setFahrenheit(double value) {
		this.value = value * 9 / 5 + 32;
	}

}
