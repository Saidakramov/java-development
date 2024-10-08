package com.pluralsight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException {
       loop();
       scanner.close();
    }

    public static int userInput() {
        System.out.println("Please enter the number for the story you would like to read: " +
                "\n(1) - Goldilocks " +
                "\n(2) - Hansel and Gretel " +
                "\n(3) - Mary Had a Little Lamb ");
        int ans = scanner.nextInt();
        scanner.nextLine();
        return ans;
    }

    public static void stories() throws FileNotFoundException {
        int answer = userInput();

        Scanner story = null;
        switch (answer) {
            case 1:
                story = new Scanner(new FileInputStream("goldilocks.txt"));
                break;
            case 2:
                story = new Scanner(new FileInputStream("hansel_and_gretel.txt"));

                break;
            case 3:
                story = new Scanner(new FileInputStream("mary_had_a_little_lamb.txt"));
        }

        while (story.hasNextLine()) {
            System.out.println(story.nextLine());
        }
        story.close();

    }

    public static void tryingToCatch(){

        try {
            stories();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

        public static void loop() {

            String answerL;
            do {
                tryingToCatch();

                do {
                    System.out.println("\nWould you like to see another story? (Select y/n) ");
                    answerL = scanner.nextLine().toUpperCase();

                    if (!answerL.equals("Y") && !answerL.equals("N")) {
                        System.out.println("Invalid input. Please input 'y' or 'n' .");
                    }
                }while (!answerL.equals("Y") && !answerL.equals("N")) ;



            }while (answerL.equals("Y"));
        }
}

