package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {
    List<Product> products = List.of(
            new Product(101, "Wireless Mouse", 1, 25.99),
            new Product(102, "Mechanical Keyboard", 1, 79.49),
            new Product(103, "Gaming Monitor", 2, 299.99),
            new Product(104, "USB-C Cable", 3, 12.49),
            new Product(105, "External Hard Drive", 4, 89.99),
            new Product(106, "Laptop Stand", 2, 34.99),
            new Product(107, "Webcam", 1, 59.99),
            new Product(108, "Portable Speaker", 3, 49.99),
            new Product(109, "Ergonomic Chair", 5, 199.99),
            new Product(110, "Noise Cancelling Headphones", 1, 199.49)
    );

    @GetMapping
    public List<Product> getAllProducts() {
         return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return products.stream()
                .filter(product -> product.getProductId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with Id: " + id));
    }

    @GetMapping("/name/{productName}")
    public Product getProductByName(@PathVariable String productName) {
        return products.stream()
                .filter(product -> Objects.equals(product.getProductName(), productName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product name not found with name: " + productName));
    }
}
