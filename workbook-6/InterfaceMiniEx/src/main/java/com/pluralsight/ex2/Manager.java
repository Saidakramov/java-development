package com.pluralsight.ex2;

import java.util.List;

public class Manager extends FullTimeEmployee implements Promotable{
    private List<Employee> managedEmployees;

    public List<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(List<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Managed Employees:");
        for (Employee e: managedEmployees) {
            System.out.println(" - " + e.getName());
        }
    }

    @Override
    public void promote() {
        System.out.println("Managers can be promoted.");
    }

    @Override
    public void getSalary() {
        System.out.println("Managers salary is : $" + getAnnualSalary());
    }
}
