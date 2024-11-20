package com.plralsight.collections;

public class Calculator {
    public static <T extends Number> double calculateAverage(T[] numbers){
        double sum = 0.0;

        for (T number : numbers) {
            sum += number.doubleValue();
        }

        return sum / numbers.length;
    }
}
