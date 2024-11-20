package com.pluralsight;

public class Dog extends Mammal{
    @Override
    public void eat() {
        System.out.println("Dog is eating. ");
    }

    @Override
    public void breathe() {
        System.out.println("Do is breathing");
    }
}
