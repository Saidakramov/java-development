package com.pluralsight.ex2;

public abstract class FullTimeEmployee extends Employee {
    private double annualSalary;

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public void displayInfo() {
        System.out.println("Annual salary :" + annualSalary);
    }
}
