package com.pluralsight;

public class Vehicle {
    private String color;
    private int numberOfPassengers;
    private int cargoCapacity;
    private int fuelCapacity;


    public Vehicle(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity) {
        this.color = color;
        this.numberOfPassengers = numberOfPassengers;
        this.cargoCapacity = cargoCapacity;
        this.fuelCapacity = fuelCapacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(int cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public static void main(String[] args) {
        Moped slowRide = new Moped("Red", 2, 5, 5);
        slowRide.setColor("Red");
        slowRide.setFuelCapacity(5);
        System.out.println(slowRide);

        Car car = new Car("Black", 5,45,15);
        car.setColor("Black");
        car.setCargoCapacity(45);
        car.setFuelCapacity(13);
        System.out.println(car);

        SemiTruck semiTruck = new SemiTruck("White", 2,100, 100);
        semiTruck.setColor("White");
        semiTruck.setFuelCapacity(100);
        System.out.println(semiTruck);

        HoverCraft hoverCraft = new HoverCraft("Silver", 10, 5,20);
        hoverCraft.setColor("Silver");
        hoverCraft.setFuelCapacity(50);
        System.out.println(hoverCraft);
    }
}
