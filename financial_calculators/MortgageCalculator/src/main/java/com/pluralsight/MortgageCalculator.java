package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    static Scanner mortgageCal = new Scanner(System.in);

    public static void main(String[] args) {
        //need to create a mortgage calculator that calculates monthly payments (- tax,insurance)
        // it will accept: principal, interest rate, loan length
        //display: expected monthly payment, total interest paid
        // ex: 53k at 7.625% interest for 15 years = 495.09 month, 36,115.99 total interest
        // use compounded interest formula
        // The compound interest formula is ((P*(1+i)^n) - P),
        // where P is the principal, i is the annual interest rate, and n is the number of periods.

        //user's principal input will be saved to principal
        double principal = userInput("Please enter your principal amount without any space or comma Ex(53000): ");
        //user/s interest rate input will be save to interest_rate
        double interest_rate = userInput("Please enter your annual interest rate Ex(7.625): ");
        //user's loan length input will be save to loan_length
        double loan_length = userInput("Please enter desired loan length in years Ex(15): ");
        // r = monthly interest rate
        double r = interest_rate / 100 / 12;
        // n = total n of monthly payments
        double n = loan_length * 12;
        // loan calculator
        double monthly_rate = principal * ((r * (Math.pow((1 + r), n))) / ((Math.pow((1 + r), n)) - 1));
        // print out final result
        System.out.printf("Your monthly payment for $" + principal + " principal " + " at " + interest_rate + "%% interest rate for " + n + " months is: $%.2f",  monthly_rate);
        mortgageCal.close();
    }

    // Asking user to input a principal, interest rate, loan length.
    public static double userInput(String message) {
        System.out.println(message);
        return mortgageCal.nextDouble();
    }

}