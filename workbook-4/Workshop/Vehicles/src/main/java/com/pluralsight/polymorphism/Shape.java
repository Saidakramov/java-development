package com.pluralsight.polymorphism;

public class Shape {
    private String color;


    public void calculateArea(double l, double w){
        System.out.println("Area is:");
    }

    public void calculateCircumference(double r){
        System.out.println("Circle area:");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
