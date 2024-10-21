package com.pluralsight;

public class Reservation {
    private String roomType;
    private double price;
    private int numberOfNights;
    private boolean weekend;
    private double reservationTotal;

    public Reservation(String roomType, int numberOfNights, boolean weekend) throws IllegalAccessException {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;

        if ("double".equalsIgnoreCase(roomType)) {
            this.price = 124.0;
        } else if ("king".equalsIgnoreCase(roomType)) {
            this.price = 139.0;
        } else {
            throw new IllegalArgumentException("Invalid room type: " + roomType + " must be king or double");
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public double getPrice() {
        return price;
    }

    public double getReservationTotal() {
        double total =  price * numberOfNights;
        if (weekend) {
            total *= 1.10;
        }
        return total;
    }
}
