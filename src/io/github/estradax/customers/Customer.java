package io.github.estradax.customers;

import io.github.estradax.products.Sellable;

public abstract class Customer {
	private String name;
	private String major;

	private CustomerType type;

	public Customer(String name, String major, CustomerType type) {
		this.name = name;
		this.major = major;
		this.type = type;
	}

	public abstract void pay(double total);

	public String getName() {
		return name;
	}

	public String getMajor() {
		return major;
	}

	public CustomerType getType() {
		return type;
	}
}
