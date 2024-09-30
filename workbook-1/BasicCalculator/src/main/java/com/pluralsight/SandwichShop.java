package com.pluralsight;

import java.io.ObjectStreamException;
import java.util.Objects;
import java.util.Scanner;

public class SandwichShop {
    static Scanner sandwichScanner = new Scanner(System.in);

    public static void main(String[] args) {
        statement();
        sandwichScanner.close();
    }

    public static String choice() {
        System.out.println("Pick a sandwich size: (R)egular = $5.25, (L)arge = &8.95." +
                " Enter R or r for regular, L or l for large");
        return sandwichScanner.nextLine();
    }

    public static float age() {
        System.out.println("Please enter your age: ");
        return sandwichScanner.nextFloat();

    }


    public static void statement() {
        String answer = SandwichShop.choice().toUpperCase();
        float age = SandwichShop.age();
        float regular = 5.45f;
        float large = 8.95f;
        if (Objects.equals(answer, "R") && (age <= 17)) {
            System.out.println("Your total is: " + (regular * 0.9));
        } else if (Objects.equals(answer, "L") && (age <= 17)) {
            System.out.println("Your total is: " + (large * 0.9));
        } else if (Objects.equals(answer, "R") &&  (age>= 65)) {
            System.out.println("Your total is : " + (regular * 0.8));
        } else if (Objects.equals(answer, "L") &&  (age>= 65)) {
            System.out.println("Your total is : " + (large * 0.8));
        } else if (Objects.equals(answer, "R")) {
                System.out.println("Your total is: " + regular);
        } else if (Objects.equals(answer, "L")) {
                System.out.println("Your total is: " + large);
        } else {
            System.out.println("Please enter correct input. ");
        }
    }
}