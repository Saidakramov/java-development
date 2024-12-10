package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("categories")
public class CategoriesController {
    List<Category> categories = List.of(
            new Category(1, "Electronics"),
            new Category(2, "Accessories"),
            new Category(3, "Cables & Audio"),
            new Category(4, "Storage Devices"),
            new Category(5, "Furniture")
    );

    @GetMapping
    public List<Category> getAllCategories() {
        return categories;
    }

    @GetMapping("/{id}")
    public Category getProductById(@PathVariable int id) {
        return categories.stream()
                .filter(category -> category.getCategoryId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category not found with Id: " + id));
    }

    @GetMapping("/name/{categoryName}")
    public Category getProductByName(@PathVariable String categoryName) {
        return categories.stream()
                .filter(category -> Objects.equals(category.getCategoryName(), categoryName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Category name not found : " + categoryName));
    }

}
