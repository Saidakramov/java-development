package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.CategoryDAO;
import com.pluralsight.NorthwindTradersAPI.models.Category;
import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("categories")
public class CategoriesController {
    private CategoryDAO dao;
//    List<Category> categories = List.of(
//            new Category(1, "Electronics"),
//            new Category(2, "Accessories"),
//            new Category(3, "Cables & Audio"),
//            new Category(4, "Storage Devices"),
//            new Category(5, "Furniture"));


    public CategoriesController(CategoryDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return dao.getAll();
    }

    @GetMapping("/{id}")
    public Category getProductById(@PathVariable int id) {
        return dao.getById(id);
//        return categories.stream()
//                .filter(category -> category.getCategoryId() == id)
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Category not found with Id: " + id));
    }

    @GetMapping("/name/{categoryName}")
    public Category getProductByName(@PathVariable String categoryName) {
        return dao.getByName(categoryName);
//        return categories.stream()
//                .filter(category -> Objects.equals(category.getCategoryName(), categoryName))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Category name not found : " + categoryName));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category category) {
        Category newCategory = dao.addCategory(category);

        return category;
    }

}
