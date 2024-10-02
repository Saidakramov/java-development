package com.pluralsight;

import java.util.Scanner;

public class FullNameApplication {
    static Scanner nameScanner = new Scanner(System.in);

    public static void main(String[] args) {
        String prefix = input("What is your prefix? If no prefix please hit enter. ");
        String name = input("What is your first name? ");
        String m_name = input("What is your middle name? If no middle name just hit enter. ");
        String l_name = input("What is your last name? ");
        String suffix = input("What is your suffix? If no suffix just hit enter. ");
        nameScanner.close();
        String full_name = "";

        if (!prefix.isEmpty()) {
            full_name += prefix + ". ";
        } if (!name.isEmpty()) {
            full_name += name + " ";
        } if (!m_name.isEmpty()) {
            full_name += m_name + " ";
        } if (!l_name.isEmpty()) {
            full_name += l_name;
        } if (!suffix.isEmpty()) {
            full_name += ", " + suffix;
        }
        System.out.println(full_name);
    }
    public static String input (String message){
        System.out.println(message);
        return nameScanner.nextLine().trim();
    }

}
