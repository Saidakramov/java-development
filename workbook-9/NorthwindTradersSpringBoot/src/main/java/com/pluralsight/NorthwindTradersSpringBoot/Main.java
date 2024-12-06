package com.pluralsight.NorthwindTradersSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Main.class, args);
        ProductDao productDao = ac.getBean(ProductDao.class);

        int input;

        do {
            System.out.println("""
                Please pick one of the following options\
                
                (1) - List Products\
                
                (2) - Add a Product\
                
                (0) - Exit.\
                
                 Your choice:\s""");

            input = scanner.nextInt();
            scanner.nextLine();

            switch (input) {
                case 1:
                    System.out.println("Product list: ");
                    for (Product p : productDao.getAll()) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.println("Please enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter Product Name: ");
                    String name = scanner.nextLine().trim();

                    System.out.println("Enter Product Category: ");
                    String category = scanner.nextLine();

                    System.out.println("Enter Product Price: ");
                    double price = scanner.nextDouble();

                    Product newProduct = new Product(id, name, category, price);
                    productDao.add(newProduct);
                    break;
                case 0:
                    System.out.println("Exiting....");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please enter 1, 2 or 0.");

            }
        } while (input != 0);

        scanner.close();
    }

}
