package com.pluralsight;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActorsDataManager {
    private DataSource dataSource;
    private static Scanner scanner = new Scanner(System.in);

    public ActorsDataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Fetch all actors
    public List<Actors> getAllActors() {
        return fetchActors("SELECT * FROM actor", null);
    }

    // Fetch actors by last name
    public List<Actors> getActorsByName() {
        System.out.println("Please enter the last name of the actor you would like to see: ");
        String lastNameChoice = scanner.nextLine();

        if (lastNameChoice == null || lastNameChoice.trim().isEmpty()) {
            System.out.println("No last name provided.");
            return Collections.emptyList();
        }

        String query = "SELECT * FROM actor WHERE last_name LIKE ?";
        return fetchActors(query, "%" + lastNameChoice.trim() + "%");
    }

    // fetch movies by first last name
    public void printMovies() {
        System.out.println("Please enter the first name of the actor you would like to see: ");
        String firstNameChoice = scanner.nextLine();

        System.out.println("Please enter the last name of the actor you would like to see: ");
        String lastNameChoice = scanner.nextLine();

        if (firstNameChoice == null || lastNameChoice == null || firstNameChoice.trim().isEmpty() || lastNameChoice.trim().isEmpty()) {
            System.out.println("No first name or last name provided");
            return;
        }

        String query = "SELECT f.title " +
                        "FROM film f " +
                        "JOIN film_actor fa ON f.film_id = fa.film_id " +
                        "JOIN actor a ON  fa.actor_id = a.actor_id " +
                        "WHERE first_name LIKE ? AND last_name LIKE ?";

        List<String> movies = fetchMovies(query, "%" + firstNameChoice.trim() + "%", "%" + lastNameChoice.trim() + "%");

        if (movies.isEmpty()) {
            System.out.println("No movies found for specified actor.");
        } else {
            System.out.println("Movies :");
            movies.forEach(System.out::println);
        }
    }

    // Print actors list with dynamic headers
    public void printActorsList(List<Actors> actors) {
        if (actors == null || actors.isEmpty()) {
            System.out.println("No actors found.");
            return;
        }

        System.out.printf("%-10s %-35s %-35s%n", "actor_id", "first_name", "last_name");
        System.out.println("------------------------------------------------------------------------");
        for (Actors actor : actors) {
            System.out.println(actor.toFormattedString());
        }
    }

    // Common logic for fetching actors
    private List<Actors> fetchActors(String query, String parameter) {
        List<Actors> actors = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter if provided
            if (parameter != null) {
                statement.setString(1, parameter);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("actor_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name"); // Fixed case typo
                    actors.add(new Actors(id, firstName, lastName));
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }

        return actors;
    }

    public List<String> fetchMovies(String query, String firstName, String lastName) {
        List<String> movies = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {

            //setting parameters
            statement.setString(1, firstName);
            statement.setString(2,lastName);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    movies.add(rs.getString("title"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return movies;
    }
}
