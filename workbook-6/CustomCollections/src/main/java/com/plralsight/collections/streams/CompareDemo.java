package com.plralsight.collections.streams;

import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        Course course1 = new Course("Java", 5, 16);
        Course course2 = new Course("Python", 3, 10);
        Course course3 = new Course("SQL", 4, 5);

        List<Course> courses = List.of(course1, course2, course3);

        //by title
        System.out.println("\nCourses sorted by title: ");
        courses.stream()
                .sorted()
                .forEach(System.out::println);

        //name desc
        System.out.println("\nCourses sorted by title descending:");
        courses.stream()
                .sorted(Comparator.comparing(Course::getTitle).reversed())
                .forEach(System.out::println);

        //by max students low to high
        System.out.println("\nCourser by number of maximum students:");
        courses.stream()
                .sorted(Comparator.comparingInt(Course::getMaxStudents))
                .forEach(System.out::println);

        // by nr of study points
        System.out.println("\nCourses by number of study points descending:");
        courses.stream()
                .sorted(Comparator.comparingInt(Course::getPoints).reversed())
                .forEach(System.out::println);
    }
}
