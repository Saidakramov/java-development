package com.pluralsight;

import java.time.LocalDateTime;

public class Actors {
    private int actorId;
    private String firstName;
    private String lastName;

    public Actors(int actorId, String firstName, String lastName) {
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toFormattedString() {
        return String.format("%-10d %-35s %-35s", actorId, firstName, lastName);
    }

    @Override
    public String toString() {
        return String.format("%-10d %-35s %-35s", actorId, firstName, lastName);
    }
}
