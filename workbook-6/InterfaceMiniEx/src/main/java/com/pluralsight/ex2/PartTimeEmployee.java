package com.pluralsight.ex2;

public abstract class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public void displayInfo() {
        System.out.println("Hourly rate is : $" + hourlyRate);
        System.out.println("Hours worked per week : " + hoursWorked);
    }
}
