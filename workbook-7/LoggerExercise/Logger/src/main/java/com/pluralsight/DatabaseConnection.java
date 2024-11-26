package com.pluralsight;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class DatabaseConnection {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, IOException {
        userInput();

    }

    public static void displayProducts() {
            // Establish database connection
            try (Connection connection = getConnection();
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

            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
        }
    }

    public static void displayCustomers() {
            // Establish database connection
            try (Connection connection = getConnection();
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

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void displayAllCategories() throws SQLException, IOException {
        // Establish database connection

        try (Connection connection = getConnection();
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT categoryID, categoryName FROM Categories ORDER BY categoryID")) {

                System.out.printf("%-5s %-15s%n", "categoryID", "categoryName");
                System.out.println("--------------------------------------------------------------------");
                while (resultSet.next()) {
                    System.out.printf("%-5s %-15s%n",
                            resultSet.getInt("categoryID"),
                            resultSet.getString("CategoryName"));
                }

            } catch (SQLException | IOException e) {
                e.printStackTrace();
        }

    }

    public static void filteredProducts() throws SQLException, IOException {
        System.out.println("\nPlease enter the CategoryId to display all the products for that category: ");
        String categoryChoice = scanner.nextLine();
        //PreparedStatement preparedStatement = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement(
                     "SELECT productID, productName, unitPrice, unitsInStock "+
                     "FROM Products p "+
                     "JOIN Categories c ON p.categoryID = c.categoryID "+
                     "WHERE c.categoryID = ? ")) {
            preparedStatement.setString(1, categoryChoice);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.printf("%-10s %-35s %-10s %-10s%n", "productID", "productName", "unitPrice", "unitsInStock");
                System.out.println("------------------------------------------------------------------------");
                while (resultSet.next()) {
                    System.out.printf("%-10d %-35s %-10.2f %-10d%n",
                            resultSet.getInt("productID"),
                            resultSet.getString("productName"),
                            resultSet.getDouble("unitPrice"),
                            resultSet.getInt("unitsInStock"));
                }

            } catch (SQLException ex) {
                System.err.println("An error occurred while fetching filtered products: " + ex.getMessage());
            }
        }
    }

    private static Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
        }
        String dbUrl = properties.getProperty("db.url");
        String dbUser = properties.getProperty("db.user");
        String dbPassword = properties.getProperty("db.password");
        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public static void userInput() throws SQLException, IOException {
        int choice;

        do {
            System.out.println("""
                    What would you like to do?
                   \s
                     (1) - Display all products
                     (2) - Display all customers
                     (3) - Display all categories
                     (0) - Exit
                   \s
                     Select an option:\s""");
            while (!scanner.hasNextInt()) { // Validate input
                System.out.println("Invalid input. Please enter 1, 2, or 0.");
                scanner.next(); // Discard invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> displayCustomers();
                case 3 -> {
                    displayAllCategories();
                    filteredProducts();
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Please enter 1, 2, or 0 to exit.");
            }
        } while (choice != 0);
        scanner.close(); // Close the scanner when done

    }
}
