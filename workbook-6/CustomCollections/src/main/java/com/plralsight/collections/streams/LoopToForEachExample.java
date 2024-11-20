package com.plralsight.collections.streams;

import java.util.List;

public class LoopToForEachExample {
    public static void main(String[] args) {
        List<String> list = List.of("bla", "la", "blabla", "lala", "blablabla", "lalala");

//        for (String s : list) {
//            System.out.println(s);
//        }

        list.forEach(s -> System.out.println(s));
    }
}
