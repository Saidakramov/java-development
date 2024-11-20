package com.pluralsight;

public class Product {
    private String id;
    private int stockQuantity;
    private String name;
    private String description;
    private String productCode;
    private String supplier;

    public Product(int stockQuantity, String name, String id, String description, String productCode, String supplier) {
        this.stockQuantity = stockQuantity;
        this.name = name;
        this.id = id;
        this.description = description;
        this.productCode = productCode;
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getProductCode() {
        return supplier + "-" + name.substring(0,3) + "-" + id;
    }

    public String order(int amount){
        if (amount <= stockQuantity){
            return name + " has been placed";
        } else {
            return name + " is not available in that amount, we only have " + stockQuantity;
        }
    }


}
