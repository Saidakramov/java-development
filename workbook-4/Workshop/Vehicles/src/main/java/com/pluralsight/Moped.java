package com.pluralsight;

public class Moped extends Vehicle{

    public Moped(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
    }

    @Override
    public String toString() {
        return "Moped{Color: " + getColor() + ", Number of Passengers: " + getNumberOfPassengers()
                + ", Cargo Capacity: " + getCargoCapacity() + ", Fuel Capacity: " + getFuelCapacity() + "}";
    }


}
