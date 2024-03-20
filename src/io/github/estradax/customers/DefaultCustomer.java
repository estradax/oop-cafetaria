package io.github.estradax.customers;

import io.github.estradax.products.Sellable;

public class DefaultCustomer extends Customer {
	private int points;

	public DefaultCustomer(CustomerBuilder builder) {
		super(builder.name, builder.major, CustomerType.DEFAULT);

		points = 0;
	}

	public int getPoints() {
		return points;
	}

	public double getConvertedPoints() {
		return points * 5000;
	}

	@Override
	public void pay(double total) {
		if (total >= 50_000) {
			points += 5;
		}

		if (total >= 300_000) {
			double discount = total * 0.10;
			total = total - discount;
		}

		System.out.println(points);
		System.out.println(total);
	}
}
