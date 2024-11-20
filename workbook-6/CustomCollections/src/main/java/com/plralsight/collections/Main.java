package com.plralsight.collections;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //creating box for laptops
        Box<Laptop> laptopBox = new Box<>();
        laptopBox.addContent(new Laptop("Apple", "MacbookPro"));
        laptopBox.addContent(new Laptop("Microsoft", "Surface"));
        laptopBox.addContent(new Laptop("Samsung","SLaptop"));
        laptopBox.addContent(new Laptop("Dell","Inspiration"));
        laptopBox.printContent();

        //creating box for books
        Box<Book> bookBox = new Box<>();
        bookBox.addContent(new Book("Maaike", "Learn Java with projects."));
        bookBox.addContent(new Book("Sameem", "How to be good at teaching"));
        bookBox.addContent(new Book("Gaberiel", "How to count cards"));
        bookBox.addContent(new Book("Joezari", "How to became a good parent"));
        bookBox.printContent();

        //Tester with int and string
        Tester<Integer, String> tester1 = new Tester<>(123, "OneTwoThree");
        tester1.printFirst();
        tester1.printSecond();

        //Tester with double and boolean
        Tester<Double, Boolean> tester2 = new Tester<>(45.50, true);
        tester2.printFirst();
        tester2.printSecond();

        //calculator test
        Integer[] integerNumbers = {1,2,3,4,5,6};
        System.out.println("Integer numbers average is : " + Calculator.calculateAverage(integerNumbers));

        Double[] doubleNumbers = {1.5,2.5,3.5,4.5,5.5,6.5};
        System.out.println("Double numbers average is : " + Calculator.calculateAverage(doubleNumbers));

        Float[] floatNumbers = {7.5f, 8.5f, 9.5f, 10.5f};
        System.out.println("Float numbers average is : " + Calculator.calculateAverage(floatNumbers));

        //testing fixedlist
        FixedList<Integer> numbers = new FixedList<>(3);
        numbers.add(10);
        numbers.add(3);
        numbers.add(92);
        //numbers.add(43); // this line should fail
        System.out.println(numbers.getItems().size());
        FixedList<LocalDate> dates = new FixedList<>(2);
        dates.add(LocalDate.now());
        dates.add(LocalDate.now());
        //dates.add(15); // this line should fail
        System.out.println();

    }

}
