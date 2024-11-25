package com.pluralsight;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DatabaseConnection {
    public static void main(String[] args) {
        userInput();

    }

    public static void displayProducts() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");

            // Establish database connection
            try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT productID, productName, unitPrice, unitsInStock FROM Products")) {


                // print header
                System.out.printf("%-10s %-35s %-10s %-10s%n", "productID", "productName", "unitPrice", "unitsInStock");
                System.out.println("------------------------------------------------------------------------");
                while (resultSet.next()) {
                    System.out.printf("%-10d %-35s %-10.2f %-10d%n",
                            resultSet.getInt("productID"),
                            resultSet.getString("productName"),
                            resultSet.getDouble("unitPrice"),
                            resultSet.getInt("unitsInStock"));
                }
            }

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void displayCustomers() {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");

            // Establish database connection
            try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT contactName, companyName, city, country, phone FROM Customers ORDER BY country")) {


                // print header
                System.out.printf("%-30s %-40s %-15s %-15s %-24s%n", "contactName", "companyName", "city,", "country", "phone");
                System.out.println("------------------------------------------------------------------------");
                while (resultSet.next()) {
                    System.out.printf("%-30s %-40s %-15s %-15s %-24s%n",
                            resultSet.getString("contactName"),
                            resultSet.getString("companyName"),
                            resultSet.getString("city"),
                            resultSet.getString("country"),
                            resultSet.getString("phone"));
                }
            }

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void displayAllCategories() {

    }

    public static void userInput() {
        int choice;
        Scanner scanner = new Scanner(System.in); // Create the scanner once
        do {
            System.out.println("""
                    What would you like to do?
                   \s
                     (1) - Display all products
                     (2) - Display all customers
                     (0) - Exit
                   \s
                     Select an option:\s""");
            while (!scanner.hasNextInt()) { // Validate input
                System.out.println("Invalid input. Please enter 1, 2, or 0.");
                scanner.next(); // Discard invalid input
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    displayCustomers();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 0 to exit.");
            }
        } while (choice != 0);
        scanner.close(); // Close the scanner when done

    }
}
