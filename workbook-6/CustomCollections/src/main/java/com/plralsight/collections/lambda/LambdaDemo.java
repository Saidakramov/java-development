package com.plralsight.collections.lambda;

import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {
    public static void main(String[] args) {
        //square UnaryOperator
        UnaryOperator square = (a) -> a * a;
        System.out.println(square.apply(5));

        //average TriFunction
        TriFunction avg = (a, b, c) -> (a + b + c)/3;
        System.out.println(avg.apply(2,4,6));

        //print Printer
        Printer p = s -> System.out.println(s);
        String s = "Hi, check out my lambda skills.";
        p.print(s);

        //ifEmpty Predicate
        Predicate<String> ifEmpty = (s1) -> s1.isEmpty();
        System.out.println(ifEmpty.test(""));
        System.out.println(ifEmpty.test("Hi"));

        //processStrings
        List<String> names = List.of("Akbar", "Joezari", "Gabrial", "Genald", "Adrian",
                "Genald", "Nima", "Ceaser", "Charles", "Sameem", "Samuel");
        Predicate<String> startsWithA = s2 -> s2.startsWith("A");
        System.out.println("Names that start with A :");
        processStrings(startsWithA, names);

        //Consumer<Integer> method reference
        List<Integer> integers = List.of(1,3,5,7,9,11,13,15,161,82);
        integers.forEach(System.out::println);

        //Consumer<Integer> lambda
        Consumer<Integer> printInt = integer -> System.out.println(integer);
        integers.forEach(printInt);

    }

    public static void processStrings(Predicate<String> predicate, List<String> list) {
        for (String s : list) {
            if (predicate.test(s)) {
                System.out.println(s);
            }
        }

    }
}
