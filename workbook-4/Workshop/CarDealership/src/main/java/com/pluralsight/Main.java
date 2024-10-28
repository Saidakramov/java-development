package com.pluralsight;




public class Main {
    public static void main(String[] args) {
        Dealership dealership = DealershipFileManager.getDealership();

        UserInterface userInterface = new UserInterface(dealership);

        userInterface.init();
    }


}
