package com.pluralsight;

import java.util.Scanner;

public class PresentValue {
    static Scanner present_value = new Scanner(System.in);

    public static void main(String[] args) {
        // monthly payout
        double monthly_payout = cust_input("Please enter your desired monthly payment amount Ex(500.65): ");
        //expected interest rate
        double interest_rate = cust_input("Please enter the expected interest rate Ex(2.5): ");
        //years to pay out the loan
        double term = cust_input("Please enter the duration of the annuity in years Ex(20): ");
        // close the scanner
        present_value.close();
        //n = number of periods in months
        double n = term * 12;
        //r= rate per period
        double r = interest_rate / 100 / 12;
        // formula
        double present_value = monthly_payout * (((1 - Math.pow((1 + r), -n)))/r);
        //display present value of the annuity
        System.out.printf("Present value for the annuity is: $%,.2f", present_value);
    }
    public static double cust_input(String message) {
        System.out.println(message);
        return present_value.nextDouble();
    }
}
