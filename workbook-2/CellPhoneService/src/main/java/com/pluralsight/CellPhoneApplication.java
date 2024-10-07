package com.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


        CellPhone cellPhone = inputs();
        CellPhone cellPhone1 = inputs();

        CellPhone cellPhone3 = new CellPhone();
        cellPhone3.setSerialNumber(123456);
        cellPhone3.setModel("Motorola");
        cellPhone3.setCarrier("At&t");
        cellPhone3.setPhoneNumber("415-888-8888");
        cellPhone3.setOwner("Akbar");

        display(cellPhone);

        display(cellPhone1);

        display((cellPhone3));

        cellPhone1.dial(cellPhone.getPhoneNumber());
        cellPhone.dial(cellPhone1.getPhoneNumber());
        cellPhone3.dial(cellPhone.getPhoneNumber());

        scanner.close();
    }

    public static String input(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static CellPhone inputs(){
        System.out.println("What is the serial number? ");
        int serialNumber = scanner.nextInt();
        scanner.nextLine();
        String model = input("What model is the phone? ");
        String carrier = input("Who is the carrier? ");
        String phoneNumber = input("What is the phone number? ");
        String owner = input("Who is the owner of the phone?");

        CellPhone cellPhone = new CellPhone(serialNumber, model, carrier, phoneNumber, owner);

        return cellPhone;
    }

    public static void display(CellPhone cellPhone){
        System.out.println("Your specifications are: " +
                "\nSerial number : " + cellPhone.getSerialNumber() +
                "\nModel : " + cellPhone.getModel() +
                "\nCarrier : " + cellPhone.getCarrier() +
                "\nPhone Number: " + cellPhone.getPhoneNumber() +
                "\nOwner : " + cellPhone.getOwner() +
                "\n\n");
    }
}
