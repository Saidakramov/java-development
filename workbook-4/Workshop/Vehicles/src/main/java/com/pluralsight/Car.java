package com.pluralsight;

public class Car extends Vehicle{

    public Car(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
    }

    @Override
    public String toString() {
        return "Car{Color: " + getColor() + ", Number of Passengers: " + getNumberOfPassengers()
                + ", Cargo Capacity: " + getCargoCapacity() + ", Fuel Capacity: " + getFuelCapacity() + "}";
    }
}
