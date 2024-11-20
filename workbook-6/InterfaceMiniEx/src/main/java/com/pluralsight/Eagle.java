package com.pluralsight;

public class Eagle extends Bird implements Flyable{
    @Override
    public void eat() {
        System.out.println("Eagle is eating.");
    }

    @Override
    public void breathe() {
        System.out.println("Eagle is breathing.");
    }

    @Override
    public void fly() {
        System.out.println("Eagle is flying.");
    }
}
