package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;
    private boolean available;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty, boolean available) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
        this.available = available;
    }
    public boolean checkedIn(){
        this.occupied = true;
        this.dirty = true;
        return true;
    }

    public boolean checkedOut() {
        this.occupied = false;
        this.dirty = true;
        return true;
    }

    public boolean cleanRoom(){
        if (!this.occupied){
            this.dirty = false;
            return true;
        }
        return false;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isAvailable() {
        return !occupied && !dirty;
    }
}


