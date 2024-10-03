package com.pluralsight;

import java.util.Scanner;

import static com.pluralsight.HighScoreWins.input;

public class AddressBuilder {
    private static Scanner builder = new Scanner(System.in);
    private static StringBuilder address = new StringBuilder();
    public static void main(String[] args) {
        user_inputs();
        builder.close();
    }

    public static void user_inputs(){

        address.append(input("What is your full name? "));
        address.append("\n\n");
        repetitive("billing");
        address.append("\n\n");
        repetitive("shipping");

        String cust_address = address.toString();
        System.out.println(cust_address);
    }

    public static void repetitive(String billingShipping){
        address.append(input("Please enter your " + billingShipping + " Street: "));
        address.append("\n");
        address.append(input("Please enter your " + billingShipping + " City: "));
        address.append(", ");
        address.append(input("Please enter your " + billingShipping + "  State: "));
        address.append(" ");
        address.append(input("Please enter your " + billingShipping + "  Zip: "));
    }

}
