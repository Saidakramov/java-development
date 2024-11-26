package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        BasicDataSource bds = new BasicDataSource();
        bds.setUrl("jdbc:mysql://localhost:3306/sakila");
        bds.setUsername(args[0]);
        bds.setPassword(args[1]);

        ActorsDataManager actorsDataManager = new ActorsDataManager(bds);

        //System.out.println(actorsDataManager.getAllActors());
        //System.out.println(actorsDataManager.getActorsByName());

//        List<Actors> actors = actorsDataManager.getActorsByName();
//        actorsDataManager.printActorsList(actors);

        actorsDataManager.printMovies();
    }
}
