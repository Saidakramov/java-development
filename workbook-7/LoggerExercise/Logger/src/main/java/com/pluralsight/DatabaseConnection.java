package com.pluralsight;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
            String dbUrl = properties.getProperty("db.url");
            String dbUser = properties.getProperty("db.user");
            String dbPassword = properties.getProperty("db.password");

            // Establish database connection
            try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT productName FROM Products")) {

                // Process query results
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("productName"));
                }
            }

        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }


    }
}
