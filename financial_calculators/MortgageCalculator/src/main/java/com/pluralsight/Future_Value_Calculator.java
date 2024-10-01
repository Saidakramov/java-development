package com.pluralsight;

import java.util.Scanner;

public class Future_Value_Calculator {
    static Scanner investmentScanner = new Scanner(System.in);

    public static void main (String[] args) {
        //deposit
        double deposit = input("Please enter the desired deposit amount without any space or comma Ex(1000): ");
        //interest rate
        double interest_rate = input("Please enter the interest rate Ex(1.75): ");
        //n_years
        double term = input("Please enter how long would you like to keep your deposit in years Ex(5): ");
        // close the scanner
        investmentScanner.close();
        // r = annual rate
        double r = interest_rate / 100 / 12;
        // n = number of compounding periods per unit of time
        double n = term * 12;
        // compound interest formula A = P(1 + r/n)nt
        double formula = deposit*Math.pow((1+r/365),(365 * n));

        // display total value and interest earned
        System.out.printf("For your deposit of $" + deposit + " at interest rate of " + interest_rate + "%% for " + term + " years you will have the total value of $%.2f" + " and your earned interest will be $%.2f", formula, (formula - deposit));
        //investmentScanner.close();
    }

    public static double input(String message) {
        System.out.println(message);
        return investmentScanner.nextDouble();
    }


}
