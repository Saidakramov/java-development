package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public Hotel(String name, int numberOfRooms, int numberOfSuites){
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfRooms, int numberOfSuites, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public boolean bookRoom(int numberOfRoomsNeeded, boolean isSuite){
        if (isSuite){
            if (numberOfRoomsNeeded + bookedSuites <= numberOfSuites){
                bookedSuites += numberOfRoomsNeeded;
                return true;
            } else {
                return false;
            }
        } else {
            if (numberOfRoomsNeeded + bookedBasicRooms <= numberOfRooms){
                bookedBasicRooms += numberOfRoomsNeeded;
                return true;
            } else {
                return false;
            }
        }
    }

    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms(){
        return numberOfRooms - bookedBasicRooms;
    }

}
