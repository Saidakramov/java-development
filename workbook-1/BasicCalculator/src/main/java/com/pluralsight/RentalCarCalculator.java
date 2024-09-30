package com.pluralsight;

import java.util.Scanner;

public class RentalCarCalculator {
    static Scanner rentalCalculator = new Scanner(System.in);

    public static void main(String[] args) {
        String pickUpDate = pickUpDate();
        int days = days();
        rentalCalculator.nextLine();
        double tag = options(days, "Would you like to add electronic tag for $ 3.95 a day?(Y/N) ", 3.95);
        double gps = options(days, "Would you like to add gps for $ 3.95 a day?(Y/N) ", 2.95);
        double roadside = options(days, "Would you like to add roadside assistance for $ 3.95 a day?(Y/N) ", 3.95);
        int age = age();
        //rentalCalculator.nextLine();
        double rate = 29.99;


        if (age > 25) {
        System.out.printf(" Your basic rental price is: $%.2f " +
                "\n Your electronic tag total is: $%.2f " +
                "\n Your gps total is: $%.2f " +
                "\n Your roadside assistance total is: $%.2f " +
                "\n Your grand total is: $%.2f ", (days * rate), tag, gps, roadside, ((days * rate) + tag + gps + roadside)
        );
        } else {
            System.out.printf(" Your basic rental price is: $%.2f " +
                    "\n Your electronic tag total is: $%.2f " +
                    "\n Your gps total is: $%.2f " +
                    "\n Your roadside assistance total is: $%.2f " +
                    "\n Your underage surcharge total is: $%.2f " +
                    "\n Your grand total is $%.2f ",(days * rate), tag, gps, roadside, ((days * rate) * .30), ((days * rate) + tag + gps + roadside));
        }
        rentalCalculator.close();
    }

    public static String pickUpDate() {
        System.out.println("When do you want to pick up your rental?(mm/dd/yyyy) ");
        return rentalCalculator.nextLine();
    }

    public static int days() {
        System.out.println("How many days are you planning to have a rental car? ");
        return rentalCalculator.nextInt();
    }

    public static double options (int days, String message, double price) {
        while (true) {
            System.out.println("Would you like to add electronic tag for $ 3.95 a day?(Y/N) ");
            String input  = rentalCalculator.nextLine().toUpperCase();
            if(input.equals("Y")){
                return price * days;
            } else if (input.equals("N")) {
                return 0;
            } else {
                System.out.println("Please input the correct answer y/n or Y/N. ");
            }
        }
    }


    public static int age() {
        System.out.println("How old are you ?");
        return rentalCalculator.nextInt();
    }
}
