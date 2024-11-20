package com.plralsight.collections.streams;

import java.util.List;

public class TerminalOperationsExample {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1,3,5,7,9,2,4,6,8);
        System.out.println(integers.stream()
                .filter(n -> n % 2 == 0)
                .count());
    }
}
