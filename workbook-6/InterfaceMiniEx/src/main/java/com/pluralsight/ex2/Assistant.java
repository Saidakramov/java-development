package com.pluralsight.ex2;

import java.util.List;

public class Assistant extends PartTimeEmployee {
    private String supervisorName;
    private List<String> assignedTasks;

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public List<String> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<String> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Supervisor name : " + supervisorName);
        System.out.println("Assigned Tasks;");
        for (String task : assignedTasks) {
            System.out.println(" - " + task);
        }
    }

}
