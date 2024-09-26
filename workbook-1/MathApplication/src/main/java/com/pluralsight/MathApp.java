package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        // Question 1:
        // declare variables here
        int bobSalary = 120_000, garySalary= 150_000;
        // then code solution
        int highestSalary = Math.max(bobSalary, garySalary);
        // then use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
        System.out.println("The highest salary is " + highestSalary);
        // REPEAT FOR NEXT EXERCISE

        // min
        int carPrice = 55_000, truck_price = 65_000;
        int cheaperCar = Math.min(carPrice, truck_price);
        System.out.println("Wallet friendly option is " + cheaperCar);

        // area
        float radius = 7.25f;
        double PI = Math.PI;
        double area = Math.pow(radius, 2) * PI;
        System.out.println("The area of a circle with 7.25 radius is " + area);

        //sqrt
        float x = 5.0f;
        double sqrt = Math.sqrt(x);
        System.out.println("The sqrt of 5.0 is " + sqrt);


        //distance
        int x_1 = 5, x_2 = 85;
        int y_1 = 10, y_2 = 50;
        double a = Math.pow((x_2 - x_1), 2);
        double b = Math.pow((y_2 - y_1), 2);
        double d = Math.sqrt(a+b);
        System.out.println("The distance between a and b is " + d);

        // abs value
        double z = -3.8;
        double abs_z = Math.abs(z);
        System.out.println(" The absolute value of -3.8 is " + abs_z);

        //random
        double random = Math.random();
        System.out.println("The random number between 0 and 1 is " + random);

        float subtotal = 22.87f;
        float tax = subtotal * 0.0825f;
        float totalDue = subtotal + tax;
        System.out.printf("Total due is: %.2f", totalDue);
    }
}

