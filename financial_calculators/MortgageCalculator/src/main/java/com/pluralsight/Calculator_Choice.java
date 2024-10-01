package com.pluralsight;


import java.util.Scanner;

public class Calculator_Choice {
    static Scanner pick_calculator = new Scanner(System.in);

    public static void main(String[] args) {
        pickCalculator();
        pick_calculator.close();
    }

    public static void pickCalculator(){
        System.out.println("Hi there, please choose a calculator you would like to use: "
        + "\n Your options: " +
                "\n Mortgage Calculator: press M or m " +
                "\n Future Value Calculator: press F or f " +
                "\n Present Value of Ordinary Annuity Calculator: press P or p");
        String answer = pick_calculator.nextLine();

        switch (answer.toUpperCase()){
            case "M":
                MortgageCalculator.main(new String[0]);
                break;
            case "F":
                Future_Value_Calculator.main(new String[0]);
                break;
            case "P":
                PresentValue.main(new String[0]);
                break;
            default:
                System.out.println("Please provide either M, F, P");
        }
    }
}

