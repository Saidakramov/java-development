package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {


    public static Dealership getDealership(){
        //create a dealership object
        Dealership dealership = new Dealership();
        //create a buffReader
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"))){
            String line;
            //read the first line to skip headers
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\\|");
                //parse csv data
                int vin = Integer.parseInt(data[0]);
                int year = Integer.parseInt(data[1]);;
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                int odometer = Integer.parseInt(data[6]);;
                double price = Double.parseDouble(data[7]);
                //create a vehicle object
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                //add a vehicle to dealership inventory
                dealership.addVehicle(vehicle);
            }
        } catch (IOException e) {
            System.out.println("Error message :" + e.getMessage());
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){

    }

}
