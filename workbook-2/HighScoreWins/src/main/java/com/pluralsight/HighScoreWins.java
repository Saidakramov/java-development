package com.pluralsight;

import java.util.Arrays;
import java.util.Scanner;

public class HighScoreWins {
    static Scanner scoreScanner = new Scanner(System.in);

    public static void main(String[] args) {
    winner();
    }

    public static String input(String message){
        System.out.println(message);
        return scoreScanner.nextLine();
    }

    public static void winner() {
        String userInput = input("Please enter team and a score information in Home:Visitor|0:1 format. ");
        scoreScanner.close();
        String[] dividedInput = userInput.split("\\|");

        /*for (String d : dividedInput){
            System.out.println(d);
        } */
        //dividing teams and assigning them into variables
        String teams = dividedInput[0];
        String[] dividedTeams = teams.split(":");
        String team1 = dividedTeams[0];
        String team2 = dividedTeams[1];
        //System.out.println("Team 1 is: " + team1 + ", Team 2 is: " + team2);

        //dividing scores and assigning them into variables
        String scores = dividedInput[1];
        String[] dividedScores = scores.split(":");
        int score1 = Integer.parseInt(dividedScores[0]);
        int score2 = Integer.parseInt(dividedScores[1]);
        //System.out.println("Score 1 is: " + score1 + ", Score 2 is: " + score2);

        if (score1 > score2){
            System.out.println("Winner : " + team1);
        } if (score1 < score2){
            System.out.println("Winner : " + team2);
        } if (score1 == score2) {
            System.out.println("It's a tie. ");
        }

    }

}
