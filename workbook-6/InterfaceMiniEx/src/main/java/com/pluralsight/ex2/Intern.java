package com.pluralsight.ex2;

public class Intern extends PartTimeEmployee implements Promotable{
    private int internshipDuration;

    public int getInternshipDuration() {
        return internshipDuration;
    }

    public void setInternshipDuration(int internshipDuration) {
        this.internshipDuration = internshipDuration;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Internship duration : " + internshipDuration + " weeks.");
    }

    @Override
    public void promote() {
        System.out.println("Interns are not eligible for promotion.");
    }

    @Override
    public void getSalary() {
        System.out.println("Salary is : $" + (getHourlyRate() + getHourlyRate()));
    }
}
