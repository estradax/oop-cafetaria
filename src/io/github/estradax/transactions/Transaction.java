package io.github.estradax.transactions;

import java.util.List;

import io.github.estradax.customers.Customer;
import io.github.estradax.products.Product;
import io.github.estradax.products.ProductType;

public class Transaction {
	private Customer customer;
	private List<Product> products;

	public Transaction(Customer customer, List<Product> products) {
		this.customer = customer;
		this.products = products;
	}

	private boolean isBuyFoodAndDrink() {
		boolean isFood = products.stream().anyMatch((Product product) -> {
			return product.getType() == ProductType.FOOD;
		});

		boolean isDrink = products.stream().anyMatch((Product product) -> {
			return product.getType() == ProductType.DRINK;
		});

		return isFood && isDrink;
	}

	private double getDiscountedDrinks() {
		return products.stream().filter((Product product) -> {
			return product.getType() == ProductType.DRINK;
		}).map((Product p) -> {
			double price = p.getPrice() - (p.getPrice() * 0.15);
			p.setPrice(price);
			return p;
		}).mapToDouble(Product::getPrice).sum();
	}

	public void execute() {
		double totalPrice = products.stream().mapToDouble(Product::getPrice).sum();

		double discountValue = 0;

		if (isBuyFoodAndDrink()) {
			discountValue = 0.20;
		}

		boolean isDiscountedDrinks = false;
		if (totalPrice >= 100_000) {
			isDiscountedDrinks = true;
		}

		double foodsTotalPrice = products.stream().filter((Product product) -> {
			return product.getType() == ProductType.FOOD;
		}).mapToDouble(Product::getPrice).sum();

		if (isDiscountedDrinks) {
			totalPrice = foodsTotalPrice + getDiscountedDrinks();
		}

		totalPrice = totalPrice - (totalPrice * discountValue);

		customer.pay(totalPrice);
	}
}
