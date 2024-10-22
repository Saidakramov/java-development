package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private boolean punchedIn;
    private double punchInTime;

    public Employee(int employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0.0;
        this.punchedIn = false;
    }

    public boolean punchTimeCard(double time) {
        if (!punchedIn) { // punch in
            this.punchInTime = time;
            this.punchedIn = true;
            System.out.println(name + " punched in at: " + punchInTime);
            return true; // punched in
        } else { //punch out
            if (time > punchInTime) {
                double hours = time - punchInTime; //total hours
                this.hoursWorked += hours; //update hoursWorked
                this.punchedIn = false;
                System.out.println(name + " punched out at: " + time);
                System.out.println("Worked " + hours + " hours!");
                return true; //punched out
            } else {
                System.out.println("Please enter time after punch in time. ");
                return false;
            }
        }
    }

    public boolean isPunchedIn(){
        return punchedIn;
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

//    public double getRegular() {
//        return (hoursWorked <= 40) ? hoursWorked : 40;
        //        if (hoursWorked <= 40) {
//            return hoursWorked;
//        }
//        return 40;
//    }
//
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

//    public double getOver() {
//        return (hoursWorked > 40) ? hoursWorked - 40 : 0;
//    }

    public double getTotalPay() {
        return ((getRegularHours() * payRate)) + (getOvertimeHours() * (payRate * 1.5));
    }
}
