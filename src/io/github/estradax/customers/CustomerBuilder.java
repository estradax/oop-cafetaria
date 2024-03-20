package io.github.estradax.customers;

public class CustomerBuilder {
	String name;
	String major;

	private CustomerType type;

	public CustomerBuilder name(String name) {
		this.name = name;
		return this;
	}

	public CustomerBuilder major(String major) {
		this.major = major;
		return this;
	}

	public CustomerBuilder type(CustomerType type) {
		this.type = type;
		return this;
	}

	public Customer build() {
		switch (type) {
		case DEFAULT:
			return new DefaultCustomer(this);
		case MEMBERSHIP:
			return new MembershipCustomer(this);
		default:
			throw new IllegalStateException(String.format("This should not be reached %s", type.name()));
		}
	}
}
