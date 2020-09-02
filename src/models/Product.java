package models;

public class Product {
	
	private String name;
	private double price;
	private String size;
	private double timeToCook;
	
	public Product(String name, double price, String size, double timeToCook) {
		this.name = name;
		this.price = price;
		this.size = size;
		this.timeToCook = timeToCook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getTimeToCook() {
		return timeToCook;
	}

	public void setTimeToCook(double timeToCook) {
		this.timeToCook = timeToCook;
	}

	@Override
	public String toString() {
		return "Producto: " + name + " $" + price + size + ", tiempo : " + timeToCook + "\n";
	}
	
	
}
