package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Store {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//    tryCatcher();
//    loadInventory();
//    userOptions();
        loop();

    scanner.close();
    }

    public static void loop() {

        String answer;
        do {
            userOptions();

            do {
                System.out.println("\nWould you like to see another product? (Select y/n) ");
                answer = scanner.nextLine().toUpperCase();
                if (!answer.equals("Y") && !answer.equals("N")) {
                    System.out.println("Invalid input. Please input 'y' or 'n' .");
                }
            }while (!answer.equals("Y") && !answer.equals("N")) ;

        }while (answer.equals("Y"));
    }

    public static Map<String, Product> loadInventory() {
        Map<String, Product> inventory = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));


            System.out.println("We carry the following inventory: ");

            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] inventoryData = line.split("\\|");
                Product p = new Product(Integer.parseInt(inventoryData[0]), inventoryData[1], Float.parseFloat(inventoryData[2]));
                inventory.put(inventoryData[1].toLowerCase(), p);
                index++;
            }
            for(String key : inventory.keySet()){
                System.out.println(key);
            }

            br.close();

        }catch (IOException e){
            e.getMessage();
        }
        return inventory;
    }

    public static void userOptions() {
        Map<String, Product> inventory = loadInventory();

        String answer = input("\nPlease enter the name of the product you would like to look up? ").toLowerCase();

        while (true) {
            if (inventory.containsKey(answer.toLowerCase())){
                System.out.println(inventory.get(answer).getAll());
                break;
            } else {
                System.out.println("Please enter the correct inventory name! ");
                answer = scanner.nextLine();
            }
        }
    }



        public static List<Product> tryCatcher(){
            List<Product> inventory = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));

            System.out.println("We carry the following inventory: ");

            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] inventoryData = line.split("\\|");
                inventory.add(new Product(Integer.parseInt(inventoryData[0]), inventoryData[1], Float.parseFloat(inventoryData[2])));
                index++;
            }
            Collections.sort(inventory, Comparator.comparing(Product::getName));
            for (int i = 0; i < inventory.size(); i++){
                Product p = inventory.get(i);
                System.out.printf("id: %d %s - Price: $%.2f\n",
                        p.getId(), p.getName(), p.getPrice());
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            return inventory;
        }

    public static String input(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void options(){
        String answer = input("What do you want to do?" +
        "\n(1)- List all products " +
        "\n(2)- Lookup a product by its id " +
        "\n(3)- Find all products within a price range " +
        "\n(4)- Add a new product " +
        "\n(5)- Quit the application " +
        "\nEnter command: Ex: 1 or 5");

    }

    public static List<Product> getInventory(){
        List<Product> inventory = new ArrayList<>();

        inventory.add(new Product(1,"Banana", 1.0f));
        inventory.add(new Product(2,"Apple", 3.99f));
        inventory.add(new Product(3,"Peach", 4.99f));
        inventory.add(new Product(4, "Strawberry", 6.99f));
        inventory.add(new Product(5, "Pineapple", 2.99f));
        return inventory;
    }

}
