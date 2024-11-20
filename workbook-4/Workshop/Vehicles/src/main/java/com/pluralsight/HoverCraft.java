package com.pluralsight;

public class HoverCraft extends Vehicle{

    public HoverCraft(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
    }

    @Override
    public String toString() {
        return "HoverCraft{Color: " + getColor() + ", Number of Passengers: " + getNumberOfPassengers()
                + ", Cargo Capacity: " + getCargoCapacity() + ", Fuel Capacity: " + getFuelCapacity() + "}";
    }
}
