package com.bramli.inventoryservice;

import com.bramli.inventoryservice.entities.Product;
import com.bramli.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository repo) {
		return args -> {
		repo.save(new Product(null,"Coca",1500.0,2.0));
		repo.save(new Product(null,"Fanta",2100.0,2.0));
		repo.save(new Product(null,"Boga",5100.0,2.0));
		repo.findAll().forEach(product -> System.out.println(product.toString()));
		};

	}
}
