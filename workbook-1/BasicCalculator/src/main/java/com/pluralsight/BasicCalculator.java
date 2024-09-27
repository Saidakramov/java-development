package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class BasicCalculator {
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        float num1 = num();
        float num2 = num();
        myScanner.nextLine();
        calculation(num1, num2);


        myScanner.close();
    }

    public static float num() {
        System.out.println("Enter the floating number: ");
        return myScanner.nextFloat();
    }

    public static String operation() {
        System.out.println("Would you like to \n" +
                "(A)dd, \n" +
                "(S)ubstract, \n" +
                "(M)ultiply, or (D)ivide? ");
        return myScanner.nextLine();
    }

    public static void calculation(float num1, float num2 ) {
        String answer = operation().toUpperCase();

        if (Objects.equals(answer, "A" )) {
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
