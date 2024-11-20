package com.plralsight.collections;

public class Tester<T, U> {
    private T first;
    private U second;

    public Tester(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public void printFirst() {
        System.out.println("First property (T): " + first);
    }

    public void printSecond() {
        System.out.println("Second property (U): " + second);
    }
}
