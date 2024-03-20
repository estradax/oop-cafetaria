package io.github.estradax;

import java.util.List;

import io.github.estradax.customers.Customer;
import io.github.estradax.customers.CustomerBuilder;
import io.github.estradax.customers.CustomerType;
import io.github.estradax.products.Product;
import io.github.estradax.products.ProductType;
import io.github.estradax.transactions.Transaction;

public class Application {
	public static void main(String[] args) {
		Customer customer = new CustomerBuilder()
				.type(CustomerType.DEFAULT)
				.name("Muhammad Azhari")
				.major("Informatics")
				.build();

		Product food = new Product("Food", 25000, 100, ProductType.FOOD);
		Product drink = new Product("Drink", 25000, 100, ProductType.DRINK);

		List<Product> products = List.of(food, drink);

		System.out.println("Customer info:");
		System.out.printf("Nama : %s\n", customer.getName());
		System.out.printf("Major: %s\n", customer.getMajor());
		System.out.printf("Tipe : %s\n\n\n", customer.getType());

		System.out.println("Cafetaria barang yang dibeli:");
		products.forEach((Product product) -> {
			System.out.printf("Nama : %s\n", product.getName());
			System.out.printf("Harga: %.2f\n", product.getPrice());
			System.out.printf("Qty  : %d\n", product.getQty());
			System.out.printf("Tipe : %s\n\n", product.getType());
		});

		Transaction transaction = new Transaction(customer, products);

		transaction.execute();
	}
}