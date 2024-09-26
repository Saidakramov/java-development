package com.pluralsight;

import java.util.Scanner;

public class PayrollCalculator {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scannerObject.nextLine();

        System.out.println("Enter hours worked(float format): ");
        float hours = scannerObject.nextFloat();
        scannerObject.nextLine();

        System.out.println("Enter your pay rate(float format: ");
        float payRate = scannerObject.nextFloat();
        scannerObject.nextLine();

        System.out.println("Hi " + name + " your gross pay is " + (hours * payRate));

    }
}
