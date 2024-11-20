package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;

public class Training {
    public static void main(String[] args) {
//        solve("Code");
//        solve("CODe");
//        solve("CoDe");

        LocalDate date = LocalDate.now();

        System.out.println(date.getDayOfMonth());

    }


    public String toJadenCase(String phrase) {
        // TODO put your code below this comment
        String[] divided = phrase.split(" ");
        for (String d: divided){
        }

        return null;
    }

    public static int multiply(int number) {
        // Your code here\
        int power = String.valueOf(Math.abs(number)).length();
        return (int) (number * Math.pow(5, power));

    }

    public static String solve(final String str) {
        int upperCount  = 0;
        int lowerCount = 0;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount ++;
            } else if (Character.isLowerCase(c)) {
                lowerCount++;
            }
        }

        if (upperCount > lowerCount) {
            return str.toUpperCase();
        } else {
            return str.toLowerCase();
        }

    }
    public static void tryCatch() {
        try{

        } catch (Error e) {
            throw new RuntimeException(e);
        }
    }
}