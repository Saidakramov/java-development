package com.plralsight.collections.streams;

import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1,3,5,7,9,2,4,6,8);
        List<Integer> result = integers.stream()
                .filter(nr -> nr % 2 != 0)
                .map(nr -> nr * nr)
                .toList();

        System.out.println(result);
    }
}
