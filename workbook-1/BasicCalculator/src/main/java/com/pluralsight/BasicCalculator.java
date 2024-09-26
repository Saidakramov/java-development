package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter the first floating number: ");
        float num1 = myScanner.nextFloat();

        System.out.println("Enter the second floating number: ");
        float num2 = myScanner.nextFloat();
        myScanner.nextLine();

        System.out.println("Would you like to (A)dd, (S)ubstract, (M)ultiply, or (D)ivide? Please type in just a cappital letter. Ex:A");
        String answer = myScanner.nextLine();
        myScanner.close();

        if (Objects.equals(answer, "A")) {
            System.out.println("Addition of first number and second number is: " + (num1 + num2));
        } else if (Objects.equals(answer, "S")) {
            System.out.println("Subtraction of first number from second number is: " + (num1 - num2));

        } else if (Objects.equals(answer, "M")) {
            System.out.println("Multiplication of first number from second number is: " + (num1 * num2));

        } else if (Objects.equals(answer, "D")) {
            System.out.println("Division of first number from second number is: " + (num1 / num2));
        }
    }
}