package com.pluralsight.NorthwindTradersAPI;

import com.pluralsight.NorthwindTradersAPI.models.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAll();
    Category getById(int id);
    Category getByName(String productName);
}
