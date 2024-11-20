package com.plralsight.collections.streams;

import java.util.List;

public class IntermediateOperationsExample {
    public static void main(String[] args) {
        List<String> list = List.of("bla", "la", "blabla", "lala", "blablabla", "lalala");
        List<String> result = list.stream()
                .filter(s -> s.length() >= 6)
                .map(String::toUpperCase)
                .toList();

        System.out.println(result);

    }
}
