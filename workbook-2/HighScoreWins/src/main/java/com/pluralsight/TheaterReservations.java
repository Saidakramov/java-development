package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

import static com.pluralsight.HighScoreWins.input;
import static com.pluralsight.HighScoreWins.scoreScanner;

public class TheaterReservations {
    public static void main(String[] args) {
    userInput();
    }

    public static void userInput(){
        String name = input("Please enter your full name. ");
        String date = input("What date will you be coming (MM/dd/yyyy)");
        String tickets = input("How many tickets would you like? ");
        scoreScanner.close();

        String[] names = name.split(" ");
        String first_name = names[0];
        String last_name = names[1];
        //LocalDate date0 = LocalDate.parse(date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date1 = LocalDate.parse(date, formatter);
        int ticket = Integer.parseInt(tickets);

        if (ticket > 1){
            System.out.println(ticket + " tickets reserved for " + date1 + " under " + last_name + ", " + first_name);
        } if (ticket <= 1){
            System.out.println(ticket + " ticket reserved for " + date1 + " under " + last_name + ", " + first_name);
        }


    }
}
