package com.plralsight.collections.streams;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Joezari", "Borlongan",30));
        persons.add(new Person("Adrian", "San Miguel",27));
        persons.add(new Person("Fran", "Santos", 27));
        persons.add(new Person("Genal", "Ocampo", 24));
        persons.add(new Person("Akbar", "Saidakramov" ,29));
        persons.add(new Person("Sameem", "Saleem" ,25));
        persons.add(new Person("Nima", "Lama" ,26));
        persons.add(new Person("Shawn", "Chung" ,29));
        persons.add(new Person("Jesus", "Lopez" ,29));
        persons.add(new Person("Mordecai", "Anagaw" ,25));
        persons.add(new Person("Grecia", "Torres" ,29));

        String lookUpName = input("Enter the first and last name of the person. Ex John Doe");
        String[] names = lookUpName.split(" ");


        ArrayList<Person> matchedPersons = new ArrayList<>();
        if (names.length == 2) {
            String firstName = names[0];
            String lastName = names[1];
            boolean found = false;

            for (Person p : persons) {
                if (p.getFirstName().equalsIgnoreCase(firstName) && p.getLastName().equalsIgnoreCase(lastName)) {
                    System.out.println("Person found : " + p);
                    found = true;
                    matchedPersons.add(p);
                    break;
                }
            }
            if (!found) {
                System.out.println("Person not found.");
            }
        } else {
            System.out.println("Please enter both first and last name.");
        }

//        for (Person p : persons) {
//            System.out.println("Persons List : " + p);
//        }

//        for (Person p : matchedPersons) {
//            System.out.println("Matched persons list : " + p);
//        }
        double totalAge = 0;
        for (Person p : persons) {
            totalAge += p.getAge();
        }

        //avgAge
        double avgAge = totalAge / persons.size();
        System.out.println("Average age is : " + avgAge);

    }

    public static String input(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }


}
