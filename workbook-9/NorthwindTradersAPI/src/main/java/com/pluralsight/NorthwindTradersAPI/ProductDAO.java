package com.pluralsight.NorthwindTradersAPI;

import com.pluralsight.NorthwindTradersAPI.models.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductsById (int id);
    Product getproductByName(String name);
}
