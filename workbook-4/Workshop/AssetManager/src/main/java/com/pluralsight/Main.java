package com.pluralsight;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Asset> assets = new ArrayList<>();

        assets.add(new House("Duplex", "2024", 1000000, "1 San Francisco St", 1, 1400, 6000));
        assets.add(new House("Duplex", "2015", 800000, "5 Francisco St", 1, 1000, 3000));
        assets.add(new Vehicle("Sedan","2023", 55000,"Toyota Mirai", 2023,8));
        assets.add(new Vehicle("SUV","2022", 40000,"Toyota Venza", 2022,5));

        for (Asset a : assets) {
            String message = "";
            if (a instanceof House) {
                House house = (House) a;
                message = "House at " + house.getAddress();
            }
            else if (a instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) a;
                message = "Vehicle: " +
                        vehicle.getYear() + " " + vehicle.getMakeModel();
            }
            System.out.println(message);
        }

    }


}
