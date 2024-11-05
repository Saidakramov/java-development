package com.pluralsight;

public class CreditCards implements Valuable {
    private String name;
    private String accountNumber;
    private double balance;

    public CreditCards(String name, String accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to add a charge to the balance
    public void charge(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Charged: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Charge amount must be positive.");
        }
    }

    // Method to make a payment toward the balance
    public void pay(double amount) {
        if (amount > 0) {
            balance -= amount;
            System.out.println("Paid: $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Payment amount must be positive.");
        }
    }

    @Override
    public double getValue() {
        return balance;
    }
}
