package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> vehicles;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> vehicles) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.vehicles = vehicles;
    }
    public Dealership(){
        this.vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByType(String type){
        ArrayList<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                matchingVehicles.add(vehicle);
            }
        }
        return matchingVehicles;
    }

    public ArrayList<Vehicle> getAllVehicles(){
        return new  ArrayList<>(vehicles);
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);

        try(FileWriter writer = new FileWriter("inventory.csv", true)) {
            writer.write(toCSV(vehicle) + "\n");
        } catch (IOException e) {
            System.out.println("Error writing to inventory file : " + e.getMessage());
        }
    }

    public void removeVehicle(ArrayList<Vehicle> vehicle){
        if (!vehicles.remove(vehicle)) {
            System.out.println("Vehicle not found in the inventory. ");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventory.csv"))) {
            File file = new File("inventory.csv");
            if (file.length() == 0) {
                writer.write("vin|year|make|model|vehicleType|color|odometer|price\n");
                for (Vehicle v : vehicles) {
                    writer.write(toCSV(v) + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating inventory file: " + e.getMessage());
        }


    }

    public String toCSV(Vehicle vehicle) {
        return vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" +
                vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
