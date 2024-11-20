package com.pluralsight.polymorphism;

public class Circle extends Shape{
    private double radius;

    @Override
    public void calculateCircumference(double r){
        System.out.println("Circumference is: " + (2 * Math.PI * r));
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
