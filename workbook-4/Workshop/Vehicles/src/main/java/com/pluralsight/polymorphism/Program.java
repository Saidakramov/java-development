package com.pluralsight.polymorphism;

public class Program {


    public static void main(String[] args) {
        Shape s1 = new Shape();
        Shape s2 = new Square();
        Shape s3 = new Circle();

        // set the fields and call the methods for calculating on each
        // can you print the radius of the circle? access in here, not in circle
        s1.setColor("Blue");
        System.out.println(s1.getColor());
        ((Circle) s3).setRadius(5.0);
        System.out.println(((Circle) s3).getRadius());
        ((Circle) s3).calculateCircumference(5.0);
        // can you print the side size of the square?
        ((Square) s2).setSize(5);
        System.out.println(((Square) s2).getSize());
        ((Square) s2).calculateArea(5,5);
    }



}
