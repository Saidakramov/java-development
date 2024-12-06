package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> products;

    public SimpleProductDao(List<Product> products) {
        this.products = products;

        // Adding some sample products
        products.add(new Product(1, "Laptop", "Electronics", 999.99));
        products.add(new Product(2, "Chair", "Furniture", 49.99));
        products.add(new Product(3, "Notebook", "Stationery", 2.99));
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }
}
