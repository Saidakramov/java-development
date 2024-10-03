package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // prompt for user input
        System.out.println("What is the serial number? ");
        double serialNumber = scanner.nextDouble();
        scanner.nextLine();
        String model = input("What model is the phone? ");
        String carrier = input("Who is the carrier? ");
        String phoneNumber = input("What is the phone number? ");
        String owner = input("Who is the owner of the phone?");

        //create a new cellphone
        CellPhone cellPhone = new CellPhone(serialNumber, model, carrier, phoneNumber, owner);
        //set the fields
        /*cellPhone.setSerialNumber(serialNumber);
        cellPhone.setModel(model);
        cellPhone.setCarrier(carrier);
        cellPhone.setPhoneNumber(phoneNumber);
        cellPhone.setOwner(owner);*/

        //display
        System.out.println("Your specifications are: " +
                        "\nSerial number : " + cellPhone.getSerialNumber() +
                        "\nModel : " + cellPhone.getModel() +
                        "\nCarrier : " + cellPhone.getCarrier() +
                        "\nPhone Number: " + cellPhone.getPhoneNumber() +
                        "\nOwner : " + cellPhone.getOwner());


    }

    public static String input(String message){
        System.out.println(message);
        return scanner.nextLine();
    }
}
