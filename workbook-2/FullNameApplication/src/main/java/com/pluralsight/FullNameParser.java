package com.pluralsight;

import static com.pluralsight.FullNameApplication.input;
import static com.pluralsight.FullNameApplication.nameScanner;

public class FullNameParser {
    public static void main(String[] args) {
        String user_full_name = input("Please enter your full name: ");
        nameScanner.close();
        String[] parts = user_full_name.split(" ");

        /* for (String part : parts){
            System.out.println(part);
        } */
        String first_name = parts[0];
        String middle_name = "";
        String last_name = "";

        if (!first_name.isEmpty()){
            System.out.println("First name: " + first_name);
        } if (parts.length == 3) {
            middle_name = parts[1];
            System.out.println("Middle name: " + middle_name);
            last_name = parts[2];
        } if (parts.length <= 2){
            System.out.println("Middle name: (none) ");
            last_name = parts[1];
        }
        System.out.println("Last name: " + last_name);
        }

        /*if ((!first_name.isEmpty()) && (!middle_name.isEmpty()) && (!last_name.isEmpty())){
            System.out.println("First name : " + first_name +
                    "\n Middle name : " + middle_name +
                    "\n Last name: " + last_name);
        } else if ((!first_name.isEmpty()) && (middle_name.isEmpty()) && (!last_name.isEmpty())){
            System.out.println(("First name : " + first_name +
                    "\n Middle name : (none) " +
                    "\n Last name: " + last_name));
        } else {
            System.out.println("Please enter the correct format. Ex: John Robert Doe or John Doe");
        } */
    }

