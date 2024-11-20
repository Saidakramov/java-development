package com.pluralsight.abstractEx;

public class House extends AbstractAsset {
    private String address;
    private int squareFeet;
    private int lotSize;

    public House(String description, String address,
                 int squareFeet, int lotSize,
                 int yearAcquired, double originalCost) {
        super(description, yearAcquired, originalCost);
        this.address = address;
        this.squareFeet = squareFeet;
        this.lotSize = lotSize;
    }
    public String getAddress() {
        return address;
    }
    public int getYearAcquired() {
        return squareFeet;
    }
    public int getLotSize() {
        return lotSize;
    }
    public double getValue() {
        return (180 * squareFeet) + (0.25 * lotSize);
    }
}
