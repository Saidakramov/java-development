package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class FamousQuotes {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loop();
        scanner.close();
    }

    private static String[] famousQuotes() {
        String[] quotes = {
                "Be yourself; everyone else is already taken.",
                "A room without books is like a body without a soul.",
                "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.",
                "Be the change that you wish to see in the world.",
                "If you tell the truth, you don't have to remember anything.",
                "A friend is someone who knows all about you and still loves you.",
                "To live is the rarest thing in the world. Most people exist, that is all.",
                "Live as if you were to die tomorrow. Learn as if you were to live forever.",
                "This too shall pass.",
                "It is better to be hated for what you are than to be loved for what you are not."};

        return quotes;

        }

        public static void tryExeptM(){
            try {
                int index;
                System.out.println("Pick a quote (Select #1 - #10) or type \"random\" ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("random")) {
                    index = (int) (Math.random() * 10 + 1);
                } else {
                    index = Integer.parseInt(input);
            }

                System.out.println(famousQuotes()[index - 1]);
            }
            catch (Exception e) {
                System.out.println("Your number was out of range!");
                //e.printStackTrace();
            }

        }

        public static void loop() {

            String answer;
            do {
                tryExeptM();

                do {
                    System.out.println("\nWould you like to see another quote? (Select y/n) ");
                    answer = scanner.nextLine().toUpperCase();
                    if (!answer.equals("Y") && !answer.equals("N")) {
                        System.out.println("Invalid input. Please input 'y' or 'n' .");
                    }
                }while (!answer.equals("Y") && !answer.equals("N")) ;



            }while (answer.equals("Y"));
        }
    }
