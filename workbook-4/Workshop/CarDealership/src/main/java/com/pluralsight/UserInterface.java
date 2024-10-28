package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    public UserInterface(Dealership dealership) {
        this.dealership = dealership;
    }

    public void init(){
        this.dealership = DealershipFileManager.getDealership();
        display();


    }

    public void display(){
        String answer;
        do {
            answer = input("""
                Please select options below :\
               
                1 - Find vehicles within price range\
                2 - Find vehicles by make / model\
                3 - Find vehicles by year range\
                4 - Find vehicles by color\
                5 - Find vehicles by mileage range\
                6 - Find vehicles by type(car, truck, SUV, van)\
                7 - List all vehicles\
                8 - Add a vehicle\
                9 - Remove a vehicle\
                99 - Quit.\s""");

            switch (answer) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> processQuit();
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (!answer.equals("99"));

    }

    public void displayVehicles(ArrayList<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    public void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("We don't have this vehicle in our inventory.");
        } else {
            displayVehicles(vehicles);
        }
    }

    public void processGetByPriceRequest() {
        try {
            double minPrice = Double.parseDouble(input("Enter minimum price: "));
            double maxPrice = Double.parseDouble(input("Enter maximum price: "));

            ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);

            if (vehicles.isEmpty()) {
                System.out.println("No vehicles found within the specified price range.");
            } else {
                displayVehicles(vehicles);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number for the price. ");
        }
    }

    public void processGetByMakeModelRequest() {
        String make = input("Enter the vehicle make: ");
        String model = input("enter the vehicle model: ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified make and model");
        } else {
            displayVehicles(vehicles);
        }
    }

    public void processGetByYearRequest(){
        try {
            int minYear = Integer.parseInt(input("Enter the minimum year for the vehicle. "));
            int maxYear = Integer.parseInt(input("Enter the maximum year for the vehicle. "));

            ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
            if (vehicles.isEmpty()) {
                System.out.println("No vehicles found within the specified year range. ");
            } else {
                displayVehicles(vehicles);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter the a valid year. ");
        }

    }

    public void processGetByColorRequest(){
        String color = input("Enter the color of the vehicle. ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found with specified color. ");
        } else {
            displayVehicles(vehicles);
        }
    }

    public void processGetByMileageRequest(){
        try {
            int minMileage = Integer.parseInt(input("Enter the minimum mileage for the vehicle. "));
            int maxMileage = Integer.parseInt(input("Enter the maximum mileage for the vehicle. "));

            ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
            if(vehicles.isEmpty()) {
                System.out.println("No vehicles found withing the specified mileage range. ");
            } else {
                displayVehicles(vehicles);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid mileage. ");
        }

    }

    public void processGetByVehicleTypeRequest(){
        String type = input("Enter the vehicle type. Ex(car, truck, SUV, van). ");

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(type);
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found with the specified type. ");
        } else {
            displayVehicles(vehicles);
        }
    }

    public void processAddVehicleRequest(){
        try {
            int vin = Integer.parseInt(input("Enter VIN: "));
            int year = Integer.parseInt(input("Enter year: "));
            String make = input("Enter make: ");
            String model = input("Enter model: ");
            String vehicleType = input("Enter vehicle type (e.g., car, truck, SUV, van): ");
            String color = input("Enter color: ");
            int odometer = Integer.parseInt(input("Enter odometer reading: "));
            double price = Double.parseDouble(input("Enter price: "));

            Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            dealership.addVehicle(vehicle);

            System.out.println("Vehicle added successfully. ");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter the correct format for each field. ");
        }
    }

    public void processRemoveVehicleRequest(){
        try {
            int vin = Integer.parseInt(input("Enter VIN of the vehicle to remove: "));

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle : dealership.getVehicles()) {
                if (vehicle.getVin() == vin) {
                    vehicles.add(vehicle);
                }
            }

            if (vehicles.isEmpty()) {
                System.out.println("Vehicle with specified VIN not found. ");
            } else {
                dealership.removeVehicle(vehicles);
                System.out.println("Vehicle removed successfully. ");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a correct VIN number. ");
        }
    }

    public void processQuit(){
        System.out.println("Exiting the applications ...");
        System.exit(0);
    }

    public String input(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }


}
