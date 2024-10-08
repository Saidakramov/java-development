package com.pluralsight;

import java.sql.SQLOutput;

import static com.pluralsight.CellPhoneApplication.input;

public class CellPhone {
    private int serialNumber = 0;
    private String model = "";
    private String carrier = "";
    private String phoneNumber = "";
    private String owner = "";

    public CellPhone(int serialNumber, String model, String carrier, String phoneNumber, String owner){
        this.serialNumber = serialNumber;
        this.model = model;
        this.carrier = carrier;
        this.phoneNumber = phoneNumber;
        this.owner = owner;
    }

    // overloaded constructor
    public CellPhone(){}

    //overloaded dial method
    public void dial(CellPhone phone){
        System.out.println(owner + " 's phone is calling " + phone.getPhoneNumber());
    }

    public void dial(String phoneN){
        System.out.println(owner + "'s phone is calling " + phoneN);
    }



    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
