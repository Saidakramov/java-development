package com.plralsight.collections.lambda;


@FunctionalInterface
public interface Predicate<T> {
    boolean test(T item);
}
