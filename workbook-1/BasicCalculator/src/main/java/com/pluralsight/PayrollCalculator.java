package com.pluralsight;

import java.util.Scanner;

public class  PayrollCalculator {

    static Scanner scannerObject = new Scanner(System.in);
    public static void main(String[] args) {
        String name = Name();
        float hours = Hours();
        float payRate= PayRate();
        scannerObject.close();
        System.out.println( "Hi " + name + " your gross pay is $" + (hours * payRate));
    }

    public static String Name() {

        System.out.println("Enter your name: ");
        return scannerObject.nextLine();
    }

    public static float Hours() {
        System.out.println("Enter hours worked(float format): ");
        //scannerObject.nextLine();
        return scannerObject.nextFloat();
    }

    public static float PayRate() {
        System.out.println("Enter your pay rate(float format): ");
        //scannerObject.nextLine();
        return scannerObject.nextFloat();
    }

}
