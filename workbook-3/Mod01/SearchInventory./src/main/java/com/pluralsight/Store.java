package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Store {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    tryCatcher();

    }

    public static void tryCatcher(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("inventory.csv"));

            List<Product> inventory = new ArrayList<>();

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
