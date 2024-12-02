package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;


import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl("jdbc:mysql://localhost:3306/sakila");
        bds.setUsername(args[0]);
        bds.setPassword(args[1]);

        ActorsDataManager actorsDataManager = new ActorsDataManager(bds);

        List<Actors> actors;
        int answer;

        do {
            System.out.println("""
                Please choose options below:\
                
                (1) - Display all actors \
                
                (2) - Look up actors by last name \
                
                (3) - Look up films by actor id \
                
                (0) - Exit""");
            answer = scanner.nextInt();
            scanner.nextLine();

            switch (answer) {
                case 1 -> actorsDataManager.getAllActors();
                case 2 -> {
                    actors = actorsDataManager.getActorsByName();
                    actorsDataManager.printActorsList(actors);
                }
                case 3 -> actorsDataManager.printMovies();
                case 0 -> System.exit(0);
            }

        } while (answer != 0);

    }
}
