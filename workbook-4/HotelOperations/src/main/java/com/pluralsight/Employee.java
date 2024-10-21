package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getRegular() {
        return (hoursWorked <= 40) ? hoursWorked : 40;
        //        if (hoursWorked <= 40) {
//            return hoursWorked;
//        }
//        return 40;
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getOver() {
        return (hoursWorked > 40) ? hoursWorked - 40 : 0;
    }

    public double getTotalPay() {
        return ((getRegularHours() * payRate)) + (getOvertimeHours() * (payRate * 1.5));
    }
}
