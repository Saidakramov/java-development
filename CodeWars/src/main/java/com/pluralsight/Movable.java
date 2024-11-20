package com.pluralsight;

public interface Movable {
    default void Move() {
        System.out.println("I am moving");
    }
}
