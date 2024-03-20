package io.github.estradax.products;

public class Product implements Sellable {
	private String name;
	private double price;
	private int qty;
	private ProductType type;

	public Product(String name, double price, int qty, ProductType type) {
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public ProductType getType() {
		return type;
	}

	@Override
	public void sell(int qty) {
		
	}
}
