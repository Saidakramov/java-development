package com.pluralsight.polymorphism;

public class Square extends Shape{
    private double size;

    @Override
    public void calculateArea(double l, double w){
         l = size;
         w = size;
        System.out.println("Area is : " + (l*w));
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
