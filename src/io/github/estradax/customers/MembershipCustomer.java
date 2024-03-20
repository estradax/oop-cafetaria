package io.github.estradax.customers;

import io.github.estradax.products.Sellable;

public class MembershipCustomer extends Customer {
	public MembershipCustomer(CustomerBuilder builder) {
		super(builder.name, builder.major, CustomerType.MEMBERSHIP);
	}

	@Override
	public void pay(double total) {
		double discount = total * 0.20;
		double discounted = total - discount;

		System.out.println(discounted);
	}
}
