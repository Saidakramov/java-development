package com.pluralsight;

public class SemiTruck extends Vehicle{

    public SemiTruck(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity);
    }

    @Override
    public String toString() {
        return "SemiTruck{Color: " + getColor() + ", Number of Passengers: " + getNumberOfPassengers()
                + ", Cargo Capacity: " + getCargoCapacity() + ", Fuel Capacity: " + getFuelCapacity() + "}";
    }
}
